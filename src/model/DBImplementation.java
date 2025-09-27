package model;

import java.sql.*;
import java.util.*;
import utilidades.Utilidades;

/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public class DBImplementation implements ModelDAO {
    /**
     * Prepare statement variables
     */
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    /**
     * Prepare SQL Connection variables
     */
    private ResourceBundle configFile;
    @SuppressWarnings("unused")
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;

    /**
     * SQL Queries: INSERTS
     */
    final String SQLINSERT_TEACHINGUNIT = "INSERT INTO TeachingUnit (ACRONIM, TITLE, EVALUATION, DESCRIPTION) VALUES (?, ?, ?, ?)";
    final String SQLINSERT_EXAMSTATEMENT = "INSERT INTO ExamStatement (DESCRIPTION, STATEMENT_LEVEL, AVAILABLE, RUTA) VALUES (?, ?, ?, ?)";
    final String SQLINSERT_EXAMSESSION = "INSERT INTO ExamSession VALUES (?, ?, ?, ?, ?)";
    final String SQLINSERT_STATEMENTUNIT = "INSERT INTO StatementUnit VALUES (?, ?)";

    /**
     * SQL Queries: SELECTS
     */
    final String SQLSELECT_TEACHINGUNIT = "SELECT * FROM TeachingUnit WHERE acronim = ?";
    final String SQLSELECT_ALLTEACHINGUNITS = "SELECT * FROM TeachingUnit";

    final String SQLSELECT_EXAMSTATEMENT = "SELECT * FROM ExamStatement WHERE id = ?";
    final String SQLSELECT_ALLEXAMSTATEMENTS = "SELECT * FROM ExamStatement";

    final String SQLSELECT_EXAMSESSION = "SELECT * FROM ExamSession WHERE id = ?";

    final String SQLSELECT_EXAMSESSIONBYEXAMSTATEMENT = "SELECT * FROM ExamSession WHERE E_id=(SELECT Id FROM ExamStatement WHERE ID = ?);";
    final String SQLSELECT_EXAMSTATEMENTBYTEACHINGUNIT = "SELECT * FROM ExamStatement WHERE ID IN (SELECT ES_ID FROM StatementUnit WHERE TU_ACRONIM = ?)";

    /**
     * Declare implementation constructor
     */
    public DBImplementation() {
        this.configFile = ResourceBundle.getBundle("model.classConfig");
        this.driverBD = this.configFile.getString("Driver");
        this.urlBD = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }

    /**
     * Method to open a new connection
     */
    private void openConnection() {
        try {
            // Try opening the connection
            con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            System.out.println("Error when attempting to open the DB.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifyes if the TEACHING UNIT (UnidadDIdactica) already exist.
     *
     * @param teachingUnit
     * @return exists
     */
    @Override
    public boolean verifyTeachingUnit(TeachingUnit teachingUnit) {
        // Open connection and declare a boolean to check if the user exists
        boolean exists = false;
        this.openConnection();

        try {
            // Prepares the SQL query
            stmt = con.prepareStatement(SQLSELECT_TEACHINGUNIT);
            stmt.setString(1, teachingUnit.getAcronim());
            // Executes the SQL query
            ResultSet rs = stmt.executeQuery();
            // If there is any result, the user exists
            if (rs.next()) {
                exists = true;
            }
            // Closes the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("The TEACHING UNIT couldn't be verified properly.");
            e.printStackTrace();
        }
        return exists;
    }

    /**
     * Creates a new TEACHING UNIT (UnidadDIdactica).
     *
     * @param teachingUnit
     * @return register
     */
    @Override
    public void newTeachingUnit() {

        System.out.print("Enter the ACRONIM: ");
        TeachingUnit teachingUnit = new TeachingUnit(Utilidades.introducirCadena());
        if (!verifyTeachingUnit(teachingUnit)) {
            System.out.print("Enter the TITLE: ");
            teachingUnit.setTitle(Utilidades.introducirCadena());
            System.out.print("Enter the EVALUATION: ");
            teachingUnit.setEvaluation(Utilidades.introducirCadena());
            System.out.print("Enter the DESCRIPTION: ");
            teachingUnit.setDescription(Utilidades.introducirCadena());

            this.openConnection();
            try {
                stmt = con.prepareStatement(SQLINSERT_TEACHINGUNIT); //(ACRONIM, TITLE, EVALUATION, DESCRIPTION)
                stmt.setString(1, teachingUnit.getAcronim());
                stmt.setString(2, teachingUnit.getTitle());
                stmt.setString(3, teachingUnit.getEvaluation());
                stmt.setString(4, teachingUnit.getDescription());
                
                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("An error has occurred when attempting to register the user.");
                e.printStackTrace();
            }

        } else {
            System.out.print("[ ERROR ] That Teaching Unit already exist.");
        }

    }

    /**
     * Shows all the TEACHING UNIT's (UnidadDIdactica) on the database
     */
    @Override
    public void showAllTeachingUnits() {
        // Open connection and checks all the existing units.
        this.openConnection();

        try {
            // Prepare the SQL query
            stmt = con.prepareStatement(SQLSELECT_ALLTEACHINGUNITS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                TeachingUnit teachingUnit = new TeachingUnit();
                teachingUnit.setAcronim(rs.getString("ACRONIM"));
                teachingUnit.setTitle(rs.getString("TITLE"));
                teachingUnit.setEvaluation(rs.getString("EVALUATION"));
                teachingUnit.setDescription(rs.getString("DESCRIPTION"));
                teachingUnit.toString();
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifyes if the EXAM STATEMENT (UnidadDIdactica) already exist.
     *
     * @param examStatement
     * @return exists
     */
    @Override
    public boolean verifyExamStatement(ExamStatement examStatement) {
        // Open connection and declare a boolean to check if the user exists
        boolean exists = false;
        this.openConnection();

        try {
            // Prepares the SQL query
            stmt = con.prepareStatement(SQLSELECT_EXAMSTATEMENT);
            stmt.setInt(1, examStatement.getId());
            // Executes the SQL query
            ResultSet rs = stmt.executeQuery();
            // If there is any result, the user exists
            if (rs.next()) {
                exists = true;
            }
            // Closes the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("The TEACHING UNIT couldn't be verified properly.");
            e.printStackTrace();
        }
        return exists;
    }

    /**
     * Creates an exam STATEMENT (Enunciado) by adding an existent teaching
     * units (UnidadDidactica).
     *
     * @param examStatement
     * @return register
     */
    @Override
    public void newExamStatement() {
        ExamStatement examStatement = new ExamStatement();
        boolean exists = true;

        System.out.print("Enter the DESCRIPTION: ");
        examStatement.setDescription(Utilidades.introducirCadena());
        System.out.println("[ LEVELS ]");
        System.out.println("1 - ALTO");
        System.out.println("2 - MEDIO");
        System.out.println("3 - BAJO");
        System.out.print("Enter the NIVEL: ");
        switch (Utilidades.leerInt(1, 3)) {
            case 1:
                examStatement.setStatementLevel(StatementLevel.ALTO);
                break;
            case 2:
                examStatement.setStatementLevel(StatementLevel.MEDIO);
                break;
            case 3:
                examStatement.setStatementLevel(StatementLevel.BAJO);
                break;
        }
        System.out.print("Enter the AVAILABILITY (Y/N): ");
        switch (Utilidades.leerChar('Y', 'N')) {
            case 'Y':
                examStatement.setAvailable(true);
                break;
            case 'N':
                examStatement.setAvailable(false);
                break;
        }
        System.out.print("Enter the RUTA: ");
        examStatement.setRuta(Utilidades.introducirCadena());

        System.out.println("[ AVAILABLE TEACHING UNITS ]");
        showAllTeachingUnits();

        do {
            System.out.print("Add the TEACHING UNIT's ACRONIM: ");
            TeachingUnit teachingUnit = new TeachingUnit(Utilidades.introducirCadena());
            exists = verifyTeachingUnit(teachingUnit);
            if (exists) {
                System.out.print("[ ERROR ] Invalid ACRONIM");
            } else {
                this.openConnection();
                try {
                    stmt = con.prepareStatement(SQLINSERT_EXAMSTATEMENT); //(DESCRIPTION, STATEMENT_LEVEL, AVAILABLE, RUTA)
                    stmt.setString(1, examStatement.getDescription());
                    switch (examStatement.getStatementLevel()) {
                        case ALTO:
                            stmt.setString(2, "ALTO");
                            break;
                        case MEDIO:
                            stmt.setString(2, "MEDIO");
                            break;
                        case BAJO:
                            stmt.setString(2, "BAJO");
                            break;
                    }
                    stmt.setBoolean(3, examStatement.getAvailable());
                    stmt.setString(4, examStatement.getDescription());                  
                    stmt.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println("An error has occurred when attempting to register the user.");
                    e.printStackTrace();
                }
                newStatementForUnit(teachingUnit, examStatement);
            }
        } while (exists);
    }

    /**
     * Shows all the EXAM STATEMENT's (Enunciado) on the database
     */
    @Override
    public void showAllExamStatements() {
        // Open connection and checks all the existing units.
        this.openConnection();

        try {
            // Prepare the SQL query
            stmt = con.prepareStatement(SQLSELECT_ALLEXAMSTATEMENTS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ExamStatement examStatement = new ExamStatement();

                examStatement.setId(rs.getInt("ID"));
                examStatement.setDescription(rs.getString("DESCRIPTION"));

                switch (rs.getString("STATEMENT_LEVEL")) {
                    case "ALTO":
                        examStatement.setStatementLevel(StatementLevel.ALTO);
                        break;
                    case "MEDIO":
                        examStatement.setStatementLevel(StatementLevel.MEDIO);
                        break;
                    case "BAJO":
                        examStatement.setStatementLevel(StatementLevel.BAJO);
                        break;
                }

                examStatement.setAvailable(rs.getBoolean("AVAILABLE"));
                examStatement.setRuta(rs.getString("RUTA"));
                System.out.println(examStatement.toString());
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a insert on the StatementUnit table
     *
     * @param teachingUnit
     * @param examStatement
     * @return register
     */
    @Override
    public boolean newStatementForUnit(TeachingUnit teachingUnit, ExamStatement examStatement) {
        boolean register = false;

        this.openConnection();
        try{
            stmt = con.prepareStatement(SQLINSERT_STATEMENTUNIT);
            stmt.setString(1, teachingUnit.getAcronim());
            stmt.setInt(2, examStatement.getId());
            if(stmt.executeUpdate()>0){
                register = true;
            }
            stmt.close();
            con.close();
        }catch (Exception e){
            System.out.println("An error has ocurred when attempting to register the user");
            e.printStackTrace();
        }
        return register;
    }

    /**
     * Create a EXAM SESSION (Convocatoria) by adding an existent STATEMENT
     * (Enunciado).
     *
     * @param examSession
     * @return register
     */
    @Override
    public void newExamSession() {
        ExamSession examSession = new ExamSession();
        boolean exists = true;

        System.out.print("Enter the CONVOCATORIA: ");
        examSession.setConvocatoria(Utilidades.introducirCadena());
        System.out.print("Enter the DESCRIPTION: ");
        examSession.setDescription(Utilidades.introducirCadena());
        System.out.print("Enter the DESCRIPTION: ");
        examSession.setSession_date(java.sql.Date.valueOf(Utilidades.leerFechaAMD()));
        System.out.print("Enter the COURSE: ");
        examSession.setCourse(Utilidades.introducirCadena());

        System.out.println("[ AVAILABLE EXAM STATEMENTS ]");
        showAllExamStatements();

        do {
            System.out.print("Add the EXAM STATEMENTS's ID: ");
            ExamStatement examStatement = new ExamStatement(Utilidades.leerInt());
            exists = verifyExamStatement(examStatement);
            if (exists) {
                System.out.print("[ ERROR ] Invalid ID");
            }
        } while (exists);
        
        this.openConnection();
        try {
            stmt = con.prepareStatement(SQLINSERT_EXAMSESSION); //(CONVOCATORIA, DESCRIPTION, SESSION_DATE, CURSO, E_ID)
            stmt.setString(1, examSession.getConvocatoria());
            stmt.setString(2, examSession.getDescription());
            stmt.setDate(3, examSession.getSession_date());
            stmt.setString(4, examSession.getCourse());
            stmt.setInt(5, examSession.geteId());
          
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("An error has occurred when attempting to register the user.");
            e.printStackTrace();
        }
    }

    /**
     * Consult the exam STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica).
     *
     */
    @Override
    public void consultStatementByTeachingUnit() {
        TeachingUnit teachingUnit;
        boolean exists = false;
        
        showAllTeachingUnits();
        
        do {
            System.out.print("Enter the acronim of a teaching unit: ");
            teachingUnit = new TeachingUnit(Utilidades.introducirCadena());
            
            exists = verifyTeachingUnit(teachingUnit);
            
            if (!exists) {
                System.out.print("The acronim entered is not registered\n");
            }
        } while(!exists);
        
        this.openConnection();
        
        try {
            stmt = con.prepareStatement(SQLSELECT_EXAMSTATEMENTBYTEACHINGUNIT);
            stmt.setString(1, teachingUnit.getAcronim());
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.print(new ExamStatement(rs.getInt(1), rs.getString(2), StatementLevel.valueOf(rs.getString(3)), rs.getBoolean(4), rs.getString(5)) + "\n");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("An error has occurred when attempting to list theaching units.");
            e.printStackTrace();
        }
    }

    /**
     * Consult in which SESSIONS (Convocatoria) a specific STATEMENT (Enunciado)
     * has been used.
     */
    @Override
    public void consultSessionsByStatement() {
        ExamSession examSession = null;
        ExamStatement examStatement = null;
        int statement;
        boolean valido = false , unico = true , respuesta = false;
        
        showAllExamStatements();
        System.out.println("Select the id of an existent statement, please: ");
        
        do{
            statement = Utilidades.leerInt(); //Te da la oportunidad de repetir en caso de no introducir un numero?
            examStatement = new ExamStatement(statement);

            if (!verifyExamStatement(examStatement)){
                System.out.println("Id incorrect. Try again, please:");
            } else {
                valido = true;
            }
        } while (!valido);
        
        this.openConnection();
        
        try{
            stmt = con.prepareStatement(SQLSELECT_EXAMSESSIONBYEXAMSTATEMENT);
            stmt.setInt(1, examStatement.getId());
            rs = stmt.executeQuery();
            
            while (rs.next()){
                examSession = new ExamSession(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5));
                if (unico){
                    System.out.println("The exam session are:\n" + examSession.getConvocatoria());
                } else {
                    System.out.println(examSession.getConvocatoria());
                }
                unico = false;
                respuesta = true;
            }
            
            if (!respuesta){
                System.out.println("There is no session with this statement."); 
            }
        } catch (SQLException e){
            System.out.println("SQL ERROR: " + e.getMessage());
        }
    }
}

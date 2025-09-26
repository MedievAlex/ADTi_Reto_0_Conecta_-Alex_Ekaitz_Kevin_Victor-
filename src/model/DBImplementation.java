package model;

import java.sql.*;
import java.util.*;

/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public class DBImplementation implements ModelDAO {

    /**
     * Prepare statement variables
     */
    private Connection con;
    private PreparedStatement stmt;

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

    /**
     * SQL Queries: SELECTS
     */
    final String SQLSELECT_TEACHINGUNIT = "SELECT * FROM TeachingUnit WHERE acronim = ?";
    final String SQLSELECT_ALLTEACHINGUNITS = "SELECT * FROM TeachingUnit";
    
    final String SQLSELECT_EXAMSTATEMENT = "SELECT * FROM ExamStatement WHERE id = ?";
    final String SQLSELECT_ALLEXAMSTATEMENTS = "SELECT * FROM ExamStatement";
    
    final String SQLSELECT_EXAMSESSION = "SELECT * FROM ExamSession WHERE id = ?";

    final String SQLSELECT_EXAMSTATEMENTBYTEACHINGUNIT = "";
    final String SQLSELECT_EXAMSESSIONBYEXAMSTATEMENT = "";

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
    public boolean newTeachingUnit(TeachingUnit teachingUnit) {
        boolean register = false;

        if (!verifyTeachingUnit(teachingUnit)) {
            this.openConnection();
            try {
                stmt = con.prepareStatement(SQLINSERT_TEACHINGUNIT); //(ACRONIM, TITLE, EVALUATION, DESCRIPTION)
                stmt.setString(1, teachingUnit.getAcronim());
                stmt.setString(2, teachingUnit.getTitle());
                stmt.setString(3, teachingUnit.getEvaluation());
                stmt.setString(4, teachingUnit.getDescription());
                if (stmt.executeUpdate() > 0) {
                    register = true;
                }
                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("An error has occurred when attempting to register the user.");
                e.printStackTrace();
            }
        }
        return register;
    }

    /**
     * Shows all the TEACHING UNIT's (UnidadDIdactica) on the database
     */
    @Override
    public void showAllTeachingUnits() {
        // Open connection and checks all the existing units.
        this.openConnection();
        ResultSet rs = null;

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
    public boolean newExamStatement(ExamStatement examStatement) {
        boolean register = false;

        if (!verifyExamStatement(examStatement)) {
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
                if (stmt.executeUpdate() > 0) {
                    register = true;
                }
                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("An error has occurred when attempting to register the user.");
                e.printStackTrace();
            }
        }
        return register;
    }

    /**
     * Shows all the EXAM STATEMENT's (Enunciado) on the database
     */
    @Override
    public void showAllExamStatements() {
        // Open connection and checks all the existing units.
        this.openConnection();
        ResultSet rs = null;

        try {
            // Prepare the SQL query
            stmt = con.prepareStatement(SQLSELECT_ALLEXAMSTATEMENTS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ExamStatement examStatement = new ExamStatement();
                examStatement.setId(rs.getInt("ID"));
                examStatement.setDescription(rs.getString("DESCRIPTION"));
                //examStatement.setStatementLevel(rs.getStatement_Level(""));
                examStatement.setAvailable(rs.getBoolean("AVAILABLE"));
                examStatement.setRuta(rs.getString("RUTA"));
                examStatement.toString();
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
    public boolean newExamSession(ExamSession examSession) {
        boolean register = false;

        this.openConnection();
        try {
            stmt = con.prepareStatement(SQLINSERT_EXAMSESSION); //(CONVOCATORIA, DESCRIPTION, SESSION_DATE, CURSO, E_ID)
            stmt.setString(1, examSession.getConvocatoria());
            stmt.setString(2, examSession.getDescription());
            stmt.setDate(3, examSession.getSession_date());
            stmt.setString(4, examSession.getCourse());
            stmt.setInt(5, examSession.geteId());
            if (stmt.executeUpdate() > 0) {
                register = true;
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("An error has occurred when attempting to register the user.");
            e.printStackTrace();
        }
        return register;
    }

    /**
     * Consult the exam STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica).
     *
     * @param teachingUnit
     * @return user
     */
    @Override
    public boolean consultStatementByTeachingUnit(TeachingUnit teachingUnit) {
        return true;
    }

    /**
     * Consult in which SESSIONS (Convocatoria) a specific STATEMENT (Enunciado)
     * has been used.
     *
     * @param examStatement
     * @return true
     */
    @Override
    public boolean consultSessionsByStatement(ExamStatement examStatement) {
        return true;
    }
}

    //****************************EJEMPLO DE TIPO*******************************
    /* Verify the user type (only used once the user is verified)
  
    public boolean verifyUserType(User user) {
        // Open connection and declare a boolean to check if the user is an admin
        boolean admin = false;
        this.openConnection();

        try {
            // Prepares the SQL query
            stmt = con.prepareStatement(SQLTYPE);
            stmt.setString(1, user.getCodU());
            // Executes the SQL query
            ResultSet rs = stmt.executeQuery();
            // If there is any result, the user exists, and they are an admin
            if (rs.next() && rs.getString(1).equals("Admin")) {
                admin = true;
            }
            // Closes the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("The user couldn't be verified properly.");
            e.printStackTrace();
        }
        return admin;
    }
     */

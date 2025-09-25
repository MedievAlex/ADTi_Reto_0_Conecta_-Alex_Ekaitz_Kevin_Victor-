package main;

import controller.Controller;
import java.sql.Date;
import model.ExamSession;
import model.ExamStatement;
import model.StatementLevel;
import model.TeachingUnit;
import utilidades.Utilidades;

/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public class Main {

    /**
     * Shows the menu and its options returning the value entered by console.
     * Read by using Utilidades.
     *
     * @return Utilidades.leerInt(0, 5)
     */
    public static int mostrarMenu() {
        System.out.println(" ________________\n|                |\n|      MAIN      |\n|      MENU      |\n|________________|\n");
        System.out.println("[ 0 ] EXIT");
        System.out.println("[ 1 ] Create a new TEACHING UNIT");
        System.out.println("[ 2 ] Create a new exam STATEMENT");
        System.out.println("[ 3 ] Create a exam SESSION");
        System.out.println("[ 4 ] Consult the exam STATEMENT by TEACHING UNIT");
        System.out.println("[ 5 ] Consult in which SESSIONS a specific STATEMENT has been used");
        System.out.print("Choose: ");
        return Utilidades.leerInt(0, 5);
    }

    /**
     * Verifyes if the TEACHING UNIT (UnidadDIdactica) already exist first to
     * create it after.
     *
     * @param controller
     */
    public static void createTeachingUnit(Controller controller) {
        System.out.print("Enter the ACRONIM: ");
        TeachingUnit teachingUnit = new TeachingUnit(Utilidades.introducirCadena());
        if (!controller.verifyTeachingUnit(teachingUnit)) {
            System.out.print("Enter the TITLE: ");
            teachingUnit.setTitle(Utilidades.introducirCadena());
            System.out.print("Enter the EVALUATION: ");
            teachingUnit.setEvaluation(Utilidades.introducirCadena());
            System.out.print("Enter the DESCRIPTION: ");
            teachingUnit.setDescription(Utilidades.introducirCadena());

            controller.newTeachingUnit(teachingUnit);
        } else {
            System.out.print("[ ERROR ] That Teaching Unit already exist.");
        }
    }

    /**
     * Create an EXAM STATEMENT (Enunciado) by adding an existent teaching units
     * (UnidadDidactica).
     *
     * @param controller
     */
    public static void createExamStatement(Controller controller) {
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
        System.out.print("Enter the AVAIABILITY (Y/N): ");
        switch (Utilidades.leerChar('Y', 'N')) {
            case 'Y':
                examStatement.setAvaiable(true);
                break;
            case 'N':
                examStatement.setAvaiable(false);
                break;
        }
        System.out.print("Enter the RUTA: ");
        examStatement.setRuta(Utilidades.introducirCadena());

        System.out.println("[ AVAIABLE TEACHING UNITS ]");
        controller.showAllTeachingUnits();

        do {
            System.out.print("Add the TEACHING UNIT's ACRONIM: ");
            TeachingUnit teachingUnit = new TeachingUnit(Utilidades.introducirCadena());
            exists = controller.verifyTeachingUnit(teachingUnit);
            if (exists) {
                System.out.print("[ ERROR ] Invalid ACRONIM");
            }
        } while (exists);
        controller.newExamStatement(examStatement);
        controller.newStatementForUnit(teachingUnit, examStatement);
    }

    /**
     * Create a EXAM SESSION (Convocatoria) by adding an existent STATEMENT
     * (Enunciado).
     *
     * @param controller
     */
    public static void createExamSession(Controller controller) {
        ExamSession examSession = new ExamSession();
        boolean exists = true;

        System.out.print("Enter the CONVOCATORIA: ");
        examSession.setConvocatoria(Utilidades.introducirCadena());
        System.out.print("Enter the DESCRIPTION: ");
        examSession.setDescription(Utilidades.introducirCadena());
        System.out.print("Enter the DESCRIPTION: ");
        examSession.setSession_date(Date.valueOf(Utilidades.leerFechaAMD()));
        System.out.print("Enter the COURSE: ");
        examSession.setCourse(Utilidades.introducirCadena());

        System.out.println("[ AVAIABLE EXAM STATEMENTS ]");
        controller.showAllExamStatements();

        do {
            System.out.print("Add the EXAM STATEMENTS's ID: ");
            ExamStatement examStatement = new ExamStatement(Utilidades.leerInt());
            exists = controller.verifyExamStatement(examStatement);
            if (exists) {
                System.out.print("[ ERROR ] Invalid ID");
            }
        } while (exists);
        controller.newExamSession(examSession);
    }

    /**
     * Consult the EXAM STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica).
     *
     * @param controller
     */
    public static void checkStatementByTeachingUnit(Controller controller) {
        TeachingUnit teachingUnit = new TeachingUnit();

        controller.consultStatementByTeachingUnit(teachingUnit);
    }

    /**
     * Consult in which EXAM SESSIONS (Convocatoria) a specific EXAM STATEMENT
     * (Enunciado) has been used.
     *
     * @param controller
     */
    public static void checkSessionsByStatement(Controller controller) {
        ExamStatement examStatement = new ExamStatement();

        controller.consultSessionsByStatement(examStatement);
    }

    /**
     * Main.
     *
     * @param args
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        int opcion = 0;

        do {
            System.out.println("***************************************");
            opcion = mostrarMenu();
            System.out.println("***************************************");

            switch (opcion) {
                case 0:
                    System.out.println(" ________________\n|                |\n|      BYE       |\n|________________|\n");
                    break;
                case 1: // [ 1 ] Create a new TEACHING UNIT
                    createTeachingUnit(controller);
                    break;
                case 2: // [ 2 ] Create a new exam STATEMENT
                    createExamStatement(controller);
                    break;
                case 3: // [ 3 ] Create a exam SESSION
                    createExamSession(controller);
                    break;
                case 4: // [ 4 ] Consult the exam STATEMENT by TEACHING UNIT
                    checkStatementByTeachingUnit(controller);
                    break;
                case 5: // [ 5 ] Consult in which SESSIONS a specific STATEMENT has been used
                    checkSessionsByStatement(controller);
                    break;
            }
        } while (opcion != 0);
        System.out.println("***************************************");
    }

}

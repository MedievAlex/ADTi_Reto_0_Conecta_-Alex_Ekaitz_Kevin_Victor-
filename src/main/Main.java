package main;

import controller.Controller;
import model.ExamStatement;
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
        System.out.println("[ 2 ] Create a new EXAM STATEMENT");
        System.out.println("[ 3 ] Create a EXAM SESSION");
        System.out.println("[ 4 ] Consult the EXAM STATEMENT by TEACHING UNIT");
        System.out.println("[ 5 ] Consult in which EXAM SESSIONS a specific EXAM STATEMENT has been used");
        System.out.print("Choose: ");
        return Utilidades.leerInt(0, 5);
    }

    /**
     * Create a EXAM SESSION (Convocatoria) by adding an existent STATEMENT
     * (Enunciado).
     *
     * @param cont
     */
  
    /*public static void createExamSession(Controller cont) {
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

        System.out.println("[ AVAILABLE EXAM STATEMENTS ]");
        cont.showAllExamStatements();

        do {
            System.out.print("Add the EXAM STATEMENTS's ID: ");
            ExamStatement examStatement = new ExamStatement(Utilidades.leerInt());
            exists = cont.verifyExamStatement(examStatement);
            if (exists) {
                System.out.print("[ ERROR ] Invalid ID");
            }
        } while (exists);
        cont.newExamSession(examSession);
    }*/

    /**
     * Consult the EXAM STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica).
     *
     * @param cont
     */
    public static void checkStatementByTeachingUnit(Controller cont) {
        TeachingUnit teachingUnit = new TeachingUnit();

        cont.consultStatementByTeachingUnit();
    }

    /**
     * Consult in which EXAM SESSIONS (Convocatoria) a specific EXAM STATEMENT
     * (Enunciado) has been used.
     *
     * @param cont
     */
    public static void checkSessionsByStatement(Controller cont) {
        ExamStatement examStatement = new ExamStatement();

        cont.consultSessionsByStatement(examStatement);
    }

    /**
     * Main.
     *
     * @param args
     */
    public static void main(String[] args) {
        Controller cont = new Controller();
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
                    cont.newTeachingUnit();
                    break;
                case 2: // [ 2 ] Create a new EXAM STATEMENT
                    cont.newExamStatement();
                    break;
                case 3: // [ 3 ] Create a EXAM SESSION
                    cont.newExamSession();
                    break;
                case 4: // [ 4 ] Consult the EXAM STATEMENT by TEACHING UNIT
                    cont.consultStatementByTeachingUnit();
                    break;
                case 5: // [ 5 ] Consult in which EXAM SESSIONS a specific EXAM STATEMENT has been used
                    cont.consultSessionsByStatement();
                    break;
            }
        } while (opcion != 0);
        System.out.println("***************************************");
    }

}

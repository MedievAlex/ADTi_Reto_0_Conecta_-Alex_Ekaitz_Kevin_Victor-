package main;

import controller.Controller;
import model.ExamSession;
import model.ExamStatement;
import model.TeachingUnit;
import utilidades.Utilidades;


/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public class Main {

    /**
     * Shows the menu and its options returning the value entered by console. Read by using Utilidades.
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
    
    public static void createTeachingUnit(Controller controller) {
        TeachingUnit teachingUnit = new TeachingUnit();
        
        System.out.print("Enter the ACRONIM: ");
        teachingUnit.setAcronim(Utilidades.introducirCadena());
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
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        int opcion = 0;
        TeachingUnit teachingUnit = new TeachingUnit();
        ExamStatement examStatement = new ExamStatement();
        ExamSession examSession = new ExamSession();

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
                   controller.newExamStatement(examStatement);
                    break;
                case 3: // [ 3 ] Create a exam SESSION
                    controller.newExamSession(examSession);
                    break;
                case 4: // [ 4 ] Consult the exam STATEMENT by TEACHING UNIT
                    controller.consultStatementByTeachingUnit(teachingUnit);
                    break;
                case 5: // [ 5 ] Consult in which SESSIONS a specific STATEMENT has been used
                    controller.consultSessionsByStatement(examStatement);
                    break;
            }
        } while (opcion != 0);
        System.out.println("***************************************");
    }

}

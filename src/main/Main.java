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

    public static int mostrarMenu() {
        System.out.println(" ________________\n|                |\n|      MENU      |\n|   PRINCIPAL    |\n|________________|\n");
        System.out.println("[ 0 ] EXIT");
        System.out.println("[ 1 ] Create a new TEACHING UNIT");
        System.out.println("[ 2 ] Create a new exam STATEMENT");
        System.out.println("[ 3 ] Create a exam SESSION");
        System.out.println("[ 4 ] Consult the exam STATEMENT by TEACHING UNIT");
        System.out.println("[ 5 ] Consult in which SESSIONS a specific STATEMENT has been used");
        System.out.print("Choose: ");
        return Utilidades.leerInt(1, 5);
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
                    System.out.println(" ________________\n|                |\n|      AGUR      |\n|________________|\n");
                    break;
                case 1: // 1. Añadir UNIDAD DIDACTICA
                    controller.newTeachingUnit(teachingUnit);
                    break;
                case 2: // 2. Crear ENUNCIADO
                   controller.newExamStatement(examStatement);
                    break;
                case 3: // 3. Crear CONVOCATORIA
                    controller.newExamSession(examSession);
                    break;
                case 4: // 4. Buscar ENUNCIADOS por UNIDAD DIDACTICA
                    controller.consultStatementByTeachingUnit(teachingUnit);
                    break;
                case 5: // 5. Buscar en que CONVOCATORIAS ha sido usado un ENUNCIADO
                    controller.consultSessionsByStatement(examStatement);
                    break;
            }
        } while (opcion != 0);
        System.out.println("***************************************");
    }

}

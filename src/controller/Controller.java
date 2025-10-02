package controller;

import model.DBImplementation;
import model.ExamStatement;
import model.ModelDAO;
import model.TeachingUnit;

/**
 * @author Alex, Ekaitz, Kevin, Victor
 */
public class Controller {

    // Prepare the DB Implementation
    ModelDAO dao = new DBImplementation();

    /**
     * Verifies if the TEACHING UNIT (UnidadDIdactica) exists
     *
     * @param teachingUnit
     * @return dao.verifyTeachingUnit(teachingUnit)
     */
    public boolean verifyTeachingUnit(TeachingUnit teachingUnit) {
        return dao.verifyTeachingUnit(teachingUnit);
    }

    /**
     * [ 1 ] Create a new TEACHING UNIT (UnidadDIdactica)
     */
    public void newTeachingUnit() {
        dao.newTeachingUnit();
    }

    /**
     * Shows all the TEACHING UNIT's (UnidadDIdactica) on the database
     */
    public void showAllTeachingUnits() {
        dao.showAllTeachingUnits();
    }

    /**
     * Verifies if the EXAM STATEMENT (Enunciado) exists
     *
     * @param examStatement
     * @return dao.verifyExamStatement(examStatement)
     */
    public boolean verifyExamStatement(ExamStatement examStatement) {
        return dao.verifyExamStatement(examStatement);
    }

    /**
     * [ 2 ] Create an EXAM STATEMENT (Enunciado) by adding an existent teaching
     * units (UnidadDidactica)
     */
    public void newExamStatement() {
        dao.newExamStatement();
    }

    /**
     * Shows all the EXAM STATEMENT's (Enunciado) on the database
     */
    public void showAllExamStatements() {
        dao.showAllExamStatements();
    }

    /**
     * Counts all the EXAM STATEMENT's (Enunciado) on the database
     *
     * @return
     */
    public int countAllExamStatements() {
        return dao.countAllExamStatements();
    }

    /**
     * Gets the EXAM STATEMENT's (Enunciado) route
     *
     * @param examStatement
     * @return
     */
    public String getExamStatementsRoute(ExamStatement examStatement){
        return dao.getExamStatementsRoute(examStatement);
    }
    
    /**
     * Creates a insert on the StatementUnit table
     *
     * @param teachingUnit
     * @param examStatement
     * @return dao.newStatementForUnit(teachingUnit, examStatement)
     */
    public boolean newStatementForUnit(TeachingUnit teachingUnit, ExamStatement examStatement) {
        return dao.newStatementForUnit(teachingUnit, examStatement);
    }

    /**
     * [ 3 ] Create a EXAM SESSION (Convocatoria) by adding an existent
     * STATEMENT (Enunciado)
     */
    public void newExamSession() {
        dao.newExamSession();
    }

    /**
     * [ 4 ] Consult the EXAM STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica)
     */
    public void consultStatementByTeachingUnit() {
        dao.consultStatementByTeachingUnit();
    }

    /**
     * [ 5 ] Consult in which EXAM SESSIONS (Convocatoria) a specific EXAM
     * STATEMENT (Enunciado) has been used
     */
    public void consultSessionsByStatement() {
        dao.consultSessionsByStatement();
    }

    /**
     * Opens the EXAM STATEMENTS's File
     */
    public void openExamStatements(){
        dao.openExamStatements();
    }
            
}

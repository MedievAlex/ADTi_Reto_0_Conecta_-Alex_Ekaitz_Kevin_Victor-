package controller;

import model.ExamSession;
import model.DBImplementation;
import model.ExamStatement;
import model.ModelDAO;
import model.TeachingUnit;

/**
 * @author Alex, Ekaitz, Kevin & Victor
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
     *
     * @param teachingUnit
     * @return dao.newTeachingUnit(teachingUnit)
     */
    public boolean newTeachingUnit(TeachingUnit teachingUnit) {
        return dao.newTeachingUnit(teachingUnit);
    }

    /**
     * Shows all the TEACHING UNIT's (UnidadDIdactica) on the database
     */
    public void showAllTeachingUnits() {      
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
     *
     * @param examStatement
     * @return dao.newExamStatement(examStatement)
     */
    public boolean newExamStatement(ExamStatement examStatement) {
        return dao.newExamStatement(examStatement);
    }

    /**
     * Shows all the EXAM STATEMENT's (Enunciado) on the database
     */
    public void showAllExamStatements() {      
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
     *
     * @param examSession
     * @return dao.newExamSession(examSession)
     */
    public boolean newExamSession(ExamSession examSession) {
        return dao.newExamSession(examSession);
    }

    /**
     * [ 4 ] Consult the EXAM STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica)
     *
     * @param teachingUnit
     * @return dao.consultStatementByTeachingUnit(teachingUnit)
     */
    public boolean consultStatementByTeachingUnit(TeachingUnit teachingUnit) {
        return dao.consultStatementByTeachingUnit(teachingUnit);
    }

    /**
     * [ 5 ] Consult in which EXAM SESSIONS (Convocatoria) a specific EXAM
     * STATEMENT (Enunciado) has been used
     *
     * @param examStatement
     * @return dao.consultSessionsByStatement(examStatement)
     */
    public boolean consultSessionsByStatement(ExamStatement examStatement) {
        return dao.consultSessionsByStatement(examStatement);
    }

}

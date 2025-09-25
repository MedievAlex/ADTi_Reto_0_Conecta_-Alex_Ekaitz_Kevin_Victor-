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
     * [ 1 ] Create a new TEACHING UNIT (UnidadDIdactica)
     *
     * @parameter teachingUnit
     * @return teachingUnit
     */
    public boolean newTeachingUnit(TeachingUnit teachingUnit) {
        return dao.newTeachingUnit(teachingUnit);
    }

    /**
     * [ 2 ] Create an EXAM STATEMENT (Enunciado) by adding an existent teaching
     * units (UnidadDidactica)
     *
     * @parameter examStatement
     * @return examStatement
     */
    public boolean newExamStatement(ExamStatement examStatement) {
        return dao.newExamStatement(examStatement);
    }

    /**
     * [ 3 ] Create a EXAM SESSION (Convocatoria) by adding an existent
     * STATEMENT (Enunciado)
     *
     * @parameter examSession
     * @return examSession
     */
    public boolean newExamSession(ExamSession examSession) {
        return dao.newExamSession(examSession);
    }

    /**
     * [ 4 ] Consult the EXAM STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica)
     *
     * @parameter teachingUnit
     * @return teachingUnit
     */
    public boolean consultStatementByTeachingUnit(TeachingUnit teachingUnit) {
        return dao.consultStatementByTeachingUnit(teachingUnit);
    }

    /**
     * [ 5 ] Consult in which EXAM SESSIONS (Convocatoria) a specific EXAM
     * STATEMENT (Enunciado) has been used
     *
     * @parameter examSession
     * @return examStatement
     */
    public boolean consultSessionsByStatement(ExamStatement examStatement) {
        return dao.consultSessionsByStatement(examStatement);
    }

}

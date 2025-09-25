package model;

/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public interface ModelDAO {
    
    /**
     * Verifies if the TEACHING UNIT (UnidadDIdactica) exists
     *
     * @param teachingUnit
     * @return
     */
    public boolean verifyTeachingUnit(TeachingUnit teachingUnit);
    
    /**
     * [ 1 ] Create a new TEACHING UNIT (UnidadDIdactica)
     *
     * @param teachingUnit
     * @return
     */
    public boolean newTeachingUnit(TeachingUnit teachingUnit);

    /**
     * [ 2 ] Create an EXAM STATEMENT (Enunciado) by adding an existent teaching
     * units (UnidadDidactica)
     *
     * @param examStatement
     * @return
     */
    public boolean newExamStatement(ExamStatement examStatement);

    /**
     * [ 3 ] Create a EXAM SESSION (Convocatoria) by adding an existent
     * STATEMENT (Enunciado)
     *
     * @param examSession
     * @return
     */
    public boolean newExamSession(ExamSession examSession);

    /**
     * [ 4 ] Consult the EXAM STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica)
     *
     * @param teachingUnit
     * @return
     */
    public boolean consultStatementByTeachingUnit(TeachingUnit teachingUnit);

    /**
     * [ 5 ] Consult in which EXAM SESSIONS (Convocatoria) a specific EXAM
     * STATEMENT (Enunciado) has been used
     *
     * @param examStatement
     * @return
     */
    public boolean consultSessionsByStatement(ExamStatement examStatement);

}

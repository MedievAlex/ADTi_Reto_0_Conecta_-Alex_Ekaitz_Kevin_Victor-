package model;

/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public interface ModelDAO {

    /**
     * [ 1 ] Create a new TEACHING UNIT (UnidadDIdactica)
     *
     * @parameter teachingUnit
     * @return
     */
    public boolean newTeachingUnit(TeachingUnit teachingUnit);

    /**
     * [ 2 ] Create an EXAM STATEMENT (Enunciado) by adding an existent teaching
     * units (UnidadDidactica)
     *
     * @parameter examStatement
     * @return
     */
    public boolean newExamStatement(ExamStatement examStatement);

    /**
     * [ 3 ] Create a EXAM SESSION (Convocatoria) by adding an existent
     * STATEMENT (Enunciado)
     *
     * @parameter examSession
     * @return
     */
    public boolean newExamSession(ExamSession examSession);

    /**
     * [ 4 ] Consult the EXAM STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica)
     *
     * @parameter teachingUnit
     * @return
     */
    public boolean consultStatementByTeachingUnit(TeachingUnit teachingUnit);

    /**
     * [ 5 ] Consult in which EXAM SESSIONS (Convocatoria) a specific EXAM
     * STATEMENT (Enunciado) has been used
     *
     * @parameter examSession
     * @return
     */
    public boolean consultSessionsByStatement(ExamStatement examStatement);

}

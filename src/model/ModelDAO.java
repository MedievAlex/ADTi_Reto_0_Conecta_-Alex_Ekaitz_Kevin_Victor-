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
     */
    public void newTeachingUnit();

    /**
     * Shows all the TEACHING UNIT's (UnidadDIdactica) on the database
     */
    public void showAllTeachingUnits();

    /**
     * Verifies if the EXAM STATEMENT (Enunciado) exists
     *
     * @param examStatement
     * @return
     */
    public boolean verifyExamStatement(ExamStatement examStatement);

    /**
     * [ 2 ] Create an EXAM STATEMENT (Enunciado) by adding an existent teaching
     * units (UnidadDidactica)
     */
    public void newExamStatement();

    /**
     * Shows all the EXAM STATEMENT's (Enunciado) on the database
     */
    public void showAllExamStatements();

    /**
     * Counts all the EXAM STATEMENT's (Enunciado) on the database
     *
     * @return
     */
    public int countAllExamStatements();

    /**
     * Creates a insert on the StatementUnit table
     *
     * @param teachingUnit
     * @param examStatement
     * @return
     */
    public boolean newStatementForUnit(TeachingUnit teachingUnit, ExamStatement examStatement);

    /**
     * [ 3 ] Create a EXAM SESSION (Convocatoria) by adding an existent
     * STATEMENT (Enunciado)
     */
    public void newExamSession();

    /**
     * [ 4 ] Consult the EXAM STATEMENT (Enunciado) by TEACHING UNIT
     * (UnidadDIdactica)
     *
     */
    public void consultStatementByTeachingUnit();

    /**
     * [ 5 ] Consult in which EXAM SESSIONS (Convocatoria) a specific EXAM
     * STATEMENT (Enunciado) has been used
     */
    public void consultSessionsByStatement();

}

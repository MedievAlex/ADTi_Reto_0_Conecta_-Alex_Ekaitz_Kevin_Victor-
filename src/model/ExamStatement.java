package model;

/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public class ExamStatement {

    /**
     * Variables.
     */
    private int id;
    private String description;
    private StatementLevel statement_level;
    private Boolean avaiable;
    private String ruta;

    /**
     * Empty constructor.
     */
    public ExamStatement() {
        this.id = 0;
        this.description = " ";
        this.statement_level = null;
        this.avaiable = null;
        this.ruta = " ";
    }
    
    /**
     * Parametized constructor to create the EXAM STATEMENT with the necessary
     * variables to verify if it exists.
     *
     * @param id
     */
    public ExamStatement(int id) {
        this.id = id;
        this.description = " ";
        this.statement_level = null;
        this.avaiable = null;
        this.ruta = " ";
    }
    
    /**
     * Parametized constructor to create the EXAM STATEMENT with all the
     * variables.
     *
     * @param id
     * @param description
     * @param statement_level
     * @param avaiable
     * @param ruta
     */
    public ExamStatement(int id, String description, StatementLevel statement_level, Boolean avaiable, String ruta) {
        this.id = id;
        this.description = description;
        this.statement_level = statement_level;
        this.avaiable = avaiable;
        this.ruta = ruta;
    }

    /**
     * Id's getter. It gets the data of this variable from the ExamStatement.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Id's setter. It sets the data of this variable from the TeachingUnit with
     * the variable or value given.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Description's getter. It gets the data of this variable from the
     * ExamStatement.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Description's setter. It sets the data of this variable from the
     * TeachingUnit with the variable or value given.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Statement Level's getter. It gets the data of this variable from the ExamStatement.
     *
     * @return statement_level
     */
    public StatementLevel getStatementLevel() {
        return statement_level;
    }

    /**
     * Statement Level's setter. It sets the data of this variable from the TeachingUnit
     * with the variable or value given.
     *
     * @param statement_level
     */
    public void setStatementLevel(StatementLevel statement_level) {
        this.statement_level = statement_level;
    }

    /**
     * Avaiable's getter. It gets the data of this variable from the
     * ExamStatement.
     *
     * @return avaiable
     */
    public Boolean getAvaiable() {
        return avaiable;
    }

    /**
     * Avaiable's setter. It sets the data of this variable from the
     * TeachingUnit with the variable or value given.
     *
     * @param avaiable
     */
    public void setAvaiable(Boolean avaiable) {
        this.avaiable = avaiable;
    }

    /**
     * Ruta's getter. It gets the data of this variable from the ExamStatement.
     *
     * @return ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Ruta's setter. It sets the data of this variable from the TeachingUnit
     * with the variable or value given.
     *
     * @param ruta
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Method for the use of showing the variables of the object.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Enunciado [" + "ID: " + id + ", Description: " + description + ", Nivel: " + statement_level + ", Disponible: " + avaiable + ", Ruta: " + ruta + ']';
    }
}

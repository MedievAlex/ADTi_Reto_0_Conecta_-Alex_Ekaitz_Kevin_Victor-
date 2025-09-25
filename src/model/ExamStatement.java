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
    private Nivel nivel;
    private Boolean avaiable;
    private String ruta;

    /**
     * Empty constructor.
     */
    public ExamStatement() {
        this.id = 0;
        this.description = "";
        this.nivel = null;
        this.avaiable = null;
        this.ruta = "";
    }

    /**
     * Parametized constructor to create the EXAM STATEMENT with the necessary
     * variables to verify if it exists.
     *
     * @param id
     * @param description
     * @param nivel
     * @param avaiable
     * @param ruta
     */
    public ExamStatement(int id, String description, Nivel nivel, Boolean avaiable, String ruta) {
        this.id = id;
        this.description = description;
        this.nivel = nivel;
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
     * Nivel's getter. It gets the data of this variable from the ExamStatement.
     *
     * @return nivel
     */
    public Nivel getNivel() {
        return nivel;
    }

    /**
     * Nivel's setter. It sets the data of this variable from the TeachingUnit
     * with the variable or value given.
     *
     * @param nivel
     */
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
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
        return "Enunciado [" + "ID: " + id + ", Description: " + description + ", Nivel: " + nivel + ", Disponible: " + avaiable + ", Ruta: " + ruta + ']';
    }
}

package model;

/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public class TeachingUnit {

    /**
     * Variables.
     */
    private int id;
    private String acronim;
    private String title;
    private String evaluation;
    private String description;

    /**
     * Empty constructor.
     */
    public TeachingUnit() {
        this.id = 0;
        this.acronim = "";
        this.title = "";
        this.evaluation = "";
        this.description = "";
    }

    /**
     * Parametized constructor to create the TEACHING UNIT with the necessary
     * variables to verify if it exists.
     *
     * @param id
     * @param acronim
     * @param title
     * @param evaluation
     * @param description
     */
    public TeachingUnit(int id, String acronim, String title, String evaluation, String description) {
        this.id = id;
        this.acronim = acronim;
        this.title = title;
        this.evaluation = evaluation;
        this.description = description;
    }

    /**
     * Id's getter. It gets the data of this variable from the TeachingUnit.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Acronim's getter. It gets the data of this variable from the
     * TeachingUnit.
     *
     * @return id
     */
    public String getAcronim() {
        return acronim;
    }

    /**
     * Title's getter. It gets the data of this variable from the TeachingUnit.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Evaluation's getter. It gets the data of this variable from the
     * TeachingUnit.
     *
     * @return evaluation
     */
    public String getEvaluation() {
        return evaluation;
    }

    /**
     * Description's getter. It gets the data of this variable from the
     * TeachingUnit.
     *
     * @return description
     */
    public String getDescription() {
        return description;
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
     * Acronim's setter. It sets the data of this variable from the TeachingUnit
     * with the variable or value given.
     *
     * @param acronim
     */
    public void setAcronim(String acronim) {
        this.acronim = acronim;
    }

    /**
     * Title's setter. It sets the data of this variable from the TeachingUnit
     * with the variable or value given.
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Evaluation's setter. It sets the data of this variable from the
     * TeachingUnit with the variable or value given.
     *
     * @param evaluation
     */
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
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
     * Method for the use of showing the variables of the object.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "UnidadDidactica [" + "ID: " + id + ", Acronimo: " + acronim + ", Titulo: " + title + ", Evaluacion: " + evaluation + ", Descripcion: " + description + ']';
    }
}

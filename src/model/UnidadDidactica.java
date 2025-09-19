package model;

public class UnidadDidactica {
    
    //Declare variables
    private int id;
    private String acronimo;
    private String titulo;
    private String evaluacion;
    private String descripcion;

    //Declare empty constructor 
    public UnidadDidactica() {
        this.id = 0;
        this.acronimo = "";
        this.titulo = "";
        this.evaluacion = "";
        this.descripcion = "";
    }
    
    //Declare constructor with parameters
    public UnidadDidactica(int id, String acronimo, String titulo, String evaluacion, String descripcion) {
        this.id = id;
        this.acronimo = acronimo;
        this.titulo = titulo;
        this.evaluacion = evaluacion;
        this.descripcion = descripcion;
    }

    //Declare getters and setters
    public int getId() {
        return id;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Declare toString
    @Override
    public String toString() {
        return "UnidadDidactica{" + "id=" + id + ", acronimo=" + acronimo + ", titulo=" + titulo + ", evaluacion=" + evaluacion + ", descripcion=" + descripcion + '}';
    }
}

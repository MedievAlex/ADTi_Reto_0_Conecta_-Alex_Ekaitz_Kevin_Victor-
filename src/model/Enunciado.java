package model;

public class Enunciado {
    
    //Variables
    private int id;
    private String description;
    private Nivel nivel;
    private Boolean disponible;
    private String ruta;
    
    //Declare empty constructor
    public Enunciado() {
        this.id = 0;
        this.description = "";
        this.nivel = null;
        this.disponible = null;
        this.ruta = "";
    }

    //Declare constructor with parameters
    public Enunciado(int id, String description, Nivel nivel, Boolean disponible, String ruta) {
        this.id = id;
        this.description = description;
        this.nivel = nivel;
        this.disponible = disponible;
        this.ruta = ruta;
    }

    // Declare getters and setters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public String getRuta() {
        return ruta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    //Declare toString
    @Override
    public String toString() {
        return "Enunciado [" + "ID: " + id + ", Description: " + description + ", Nivel: " + nivel + ", Disponible: " + disponible + ", Ruta: " + ruta + ']';
    }
}

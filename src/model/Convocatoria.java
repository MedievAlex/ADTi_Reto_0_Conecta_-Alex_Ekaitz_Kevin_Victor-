package model;

import java.sql.Date;
import java.time.LocalDate;

public class Convocatoria {

    // Variables
    private String convocatoria;
    private String descripcion;
    private Date date;
    private String curso;
    private int eId;

    // Declare empty constructor
    public Convocatoria() {
        this.convocatoria = "";
        this.descripcion = "";
        this.date = Date.valueOf(LocalDate.now());
        this.curso = "";
        this.eId = 0;
    }
    
    //Declare constructor with parameters
    public Convocatoria(String convocatoria, String descripcion, Date date, String curso, int eId) {
        this.convocatoria = convocatoria;
        this.descripcion = descripcion;
        this.date = date;
        this.curso = curso;
        this.eId = eId;
    }

    // Declare getters and setters
    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getEId() {
        return eId;
    }

    public void setEId(int eId) {
        this.eId = eId;
    }

    //Declare toString
    @Override
    public String toString() {
        return "Convocatoria{" + "convocatoria=" + convocatoria + ", descripcion=" + descripcion + ", date=" + date + ", curso=" + curso + ", eId=" + eId + '}';
    }
    
}

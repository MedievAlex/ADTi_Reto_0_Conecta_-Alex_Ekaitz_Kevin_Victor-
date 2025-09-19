package controller;

import model.Convocatoria;
import model.DBImplementation;
import model.Enunciado;
import model.ModelDAO;
import model.UnidadDidactica;

public class Controler {
    
    // Prepare the DB Implementation
    ModelDAO dao = new DBImplementation();
    
    // [ 1 ] Create a teaching unit (UnidadDIdactica)
    public boolean nuevaUnidadDidactica(UnidadDidactica unidadDidactica){
		return dao.nuevaUnidadDidactica(unidadDidactica);
    } 
    
     // [ 2 ] Create an exam statement (Enunciado) by adding a teaching units (UnidadDidactica)
    public boolean nuevoEnunciado(Enunciado enunciado){
		return dao.nuevoEnunciado(enunciado);
    }  
   
    // [ 3 ] Create a exam session (Convocatoria) by adding an existent statement (Enunciado)
    public boolean nuevaConvocatoria(Convocatoria convocatoria){
		return dao.nuevaConvocatoria(convocatoria);
    }   

    // Consult the exam statement (Enunciado) in which a specific teaching unit (UnidadDIdactica) is covered
    public boolean consultarEnunciadoPorUnidadDidactica(UnidadDidactica unidadDidactica){
		return dao.consultarEnunciadoPorUnidadDidactica(unidadDidactica);
    }   
   
    // Consult in which session (Convocatoria) a specific statement (Enunciado) has been used
    public boolean consultarConvocatoriaPorEnunciado(Enunciado enunciado){
		return dao.consultarConvocatoriaPorEnunciado(enunciado);
    }    
     
}

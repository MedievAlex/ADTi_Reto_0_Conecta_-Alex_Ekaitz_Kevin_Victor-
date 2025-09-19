/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.DBImplementation;
import model.Enunciado;
import model.ModelDAO;
import model.UnidadDidactica;

public class Controler {
    
    // Prepare the DB Implementation
    ModelDAO dao = new DBImplementation();
    
    // Create a teaching unit (UnidadDIdactica)
    public boolean nuevaUnidadDidactica(UnidadDidactica unidadDidactica){
		return dao.nuevaUnidadDidactica(unidadDidactica);
    } 
    
    // Create an exam statement (Enunciado) by adding the teaching units (UnidadDidactica) that it will refer to. 
    // The session (Convocatoria) for which it is created will also be associated with this statement (Enunciado)
    public boolean nuevoEnunciado(Enunciado enunciado){
		return dao.nuevoEnunciado(enunciado);
    }  
   
    // Consult the exam statement (Enunciado) in which a specific teaching unit (UnidadDIdactica) is covered
    public boolean consultarEnunciadoPorUnidadDidactica(UnidadDidactica unidadDidactica){
		return dao.consultarEnunciadoPorUnidadDidactica(unidadDidactica);
    }   
   
    // Consult in which session (Convocatoria) a specific statement (Enunciado) has been used
    public boolean consultarConvocatoriaPorEnunciado(Enunciado enunciado){
		return dao.consultarConvocatoriaPorEnunciado(enunciado);
    }    
    
    // View the text document associated with a statement (Enunciado)
    public boolean mostrarTextoPorEnunciado(Enunciado enunciado){
		return dao.mostrarTextoPorEnunciado(enunciado);
    }     
    
    // Assign a statement (Enunciado) to a session (Convocatoria)
    public boolean asignarEnunciado(Enunciado enunciado){
		return dao.asignarEnunciado(enunciado);
    }      
    
}

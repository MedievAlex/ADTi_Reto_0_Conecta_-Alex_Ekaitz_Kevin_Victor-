package model;

public interface ModelDAO {
    
    // Create a teaching unit (UnidadDIdactica)
    public boolean nuevaUnidadDidactica(UnidadDidactica unidadDidactica); 
    
    // Create a exam session (Convocatoria)
    public boolean nuevaConvocatoria(Convocatoria convocatoria); 
    
    // Create an exam statement (Enunciado) by adding the teaching units (UnidadDidactica) that it will refer to. 
    // The session (Convocatoria) for which it is created will also be associated with this statement (Enunciado)
    public boolean nuevoEnunciado(Enunciado enunciado); 
   
    // Consult the exam statement (Enunciado) in which a specific teaching unit (UnidadDIdactica) is covered
    public boolean consultarEnunciadoPorUnidadDidactica(UnidadDidactica unidadDidactica); 
   
    // Consult in which session (Convocatoria) a specific statement (Enunciado) has been used
    public boolean consultarConvocatoriaPorEnunciado(Enunciado enunciado); 
    
    // View the text document associated with a statement (Enunciado)
    public boolean mostrarTextoPorEnunciado(Enunciado enunciado); 
    
    // Assign a statement (Enunciado) to a session (Convocatoria)
    public boolean asignarEnunciado(Enunciado enunciado); 
     
}

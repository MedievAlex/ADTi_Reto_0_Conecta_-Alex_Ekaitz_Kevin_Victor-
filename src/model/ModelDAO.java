package model;

public interface ModelDAO {
    
    // [ 1 ] Create a teaching unit (UnidadDIdactica)
    public boolean nuevaUnidadDidactica(UnidadDidactica unidadDidactica); 
    
    // [ 2 ] Create an exam statement (Enunciado) by adding a teaching units (UnidadDidactica)
    public boolean nuevoEnunciado(Enunciado enunciado); 
    
    // [ 3 ] Create a exam session (Convocatoria) by adding an existent statement (Enunciado)
    public boolean nuevaConvocatoria(Convocatoria convocatoria); 
   
    // [ 4 ] Consult the exam statement (Enunciado) in which a specific teaching unit (UnidadDIdactica) is covered
    public boolean consultarEnunciadoPorUnidadDidactica(UnidadDidactica unidadDidactica); 
   
    // [ 5 ] Consult in which session (Convocatoria) a specific statement (Enunciado) has been used
    public boolean consultarConvocatoriaPorEnunciado(Enunciado enunciado); 
        
}

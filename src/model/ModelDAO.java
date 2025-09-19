/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public interface ModelDAO {
    public boolean nuevaUnidadDidactica(UnidadDidactica unidadDidactica);
    
    /*
     Create a teaching unit (Unit) and an exam session (Session).
     Create an exam statement by adding the teaching units that it will refer to. The session for
    which it is created will also be associated
    with this statement.
     Consult the exam statements in which a
    specific teaching unit is covered.
     Consult in which sessions a specific
    statement has been used.
     View the text document associated with a
    statement.
     Assign a statement to a session.
    */
}

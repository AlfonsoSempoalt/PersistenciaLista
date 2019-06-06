/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Alfonso Sempoalt
 */
public class DaoException extends RuntimeException{
    
public DaoException(String s){
    super(s);
}    
public DaoException(String s,Throwable causa ){
    super(s,causa);
}    
public DaoException(Throwable causa ){
    super(causa);
}    

}

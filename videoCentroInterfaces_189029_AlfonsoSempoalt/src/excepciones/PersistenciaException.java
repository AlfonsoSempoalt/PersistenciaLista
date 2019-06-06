 
package excepciones;

/**
 *
 * @author Alfonso Sempoalt
 */
public class PersistenciaException extends RuntimeException {

    public PersistenciaException(String s){
        super(s);
    }
    public PersistenciaException(String s, Throwable causa){
        super(s, causa);
    }
    public PersistenciaException( Throwable causa){
        super(causa);
    }
    
}

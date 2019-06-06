package objetonegocio;

import java.util.Objects;

public class Cliente {

    private String numCredencial;
    private String nombre;
    private String direccion;
    private String telefono;
    /**
     * método constructor vacio
     */
    public Cliente() {
    }
    /**
     * método constructor que asigna todos los atributos de clase
     * @param numCredencial
     * @param nombre
     * @param direccion
     * @param telefono 
     */
    public Cliente(String numCredencial, String nombre, String direccion, String telefono) {
        this.direccion = direccion;
        this.numCredencial = numCredencial;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    /**
     * método constructor que asigna el número de credencial y el resto lo pone en null
     * @param numCredencial 
     */
    public Cliente(String numCredencial) {
        this.numCredencial = numCredencial;
        nombre = null;
        direccion = null;
        telefono = null;
    }
    /**
     * regresa el número de credencial
     * @return 
     */
    public String getNumCredencial() {
        return numCredencial;
    }
    /**
     * asigna el número de credencial
     * @param numCredencial 
     */
    public void setNumCredencial(String numCredencial) {
        this.numCredencial = numCredencial;
    }
    /**
     * Nos retorna el nombre 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Nos sirve para asignar el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Nos retorna la direccion
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * ASigna la dirección 
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Nos retorna el número de télefono
     * @return 
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Asigna el número de télefono
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Método equals que dependiendo el numCredencial nos regresara true or false
     * @param obj
     * @return 
     */
    
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Cliente) {
            Cliente cliente = (Cliente) obj;
            if (cliente.getNumCredencial().equals(numCredencial)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método hashcode que genera una clave número único dependiendo atributos
     * @return 
     */
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 78 * hash + Objects.hashCode(this.numCredencial);
        hash = 78 * hash + Objects.hashCode(this.nombre);
        hash = 78 * hash + Objects.hashCode(this.direccion);
        hash = 78 * hash + Objects.hashCode(this.telefono);
        return hash;
    }

        /**
         * Método toString que nos regrea el valor de los atributos en un string
         * @return 
         */
    
    @Override
    public String toString() {
        return "Cliente{" + "numCredencial=" + numCredencial + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
}

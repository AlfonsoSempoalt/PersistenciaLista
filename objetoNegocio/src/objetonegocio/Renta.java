package objetonegocio;

import Fecha.*;
import java.util.Objects;

public class Renta {

    private Cliente cliente;
    private Articulo articulo;
    private Fecha fechaRenta;
    private int tiempoRenta;
    /**
     * Método constructor vacio
     */
    public Renta() {

    }
    /**
     * Método constructor que asigna los atributos de la clase
     * @param cliente
     * @param articulo
     * @param fechaRenta 
     * @param tiempoRenta 
     */
    public Renta(Cliente cliente, Articulo articulo, Fecha fechaRenta, int tiempoRenta) {
        this.cliente = cliente;
        this.articulo = articulo;
        this.fechaRenta = fechaRenta;
        this.tiempoRenta= tiempoRenta;
    }
    /**
     * método contructor que solo asigna dos atributos de la clase
     * @param cliente
     * @param articulo 
     */
    public Renta(Cliente cliente, Articulo articulo) {
        this.cliente = cliente;
        this.articulo = articulo;
    }
    /**
     * método que nos retorna al cliente
     * @return 
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * método que asigna al cliente
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * método que nos retorna el articulo
     * @return 
     */
    public Articulo getArticulo() {
        return articulo;
    }
    /**
     * método que nos asigna el articulo
     * @param articulo 
     */
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    /**
     * método que retorna la fechaRenta
     * @return 
     */
    public Fecha getFechaRenta() {
        return fechaRenta;
    }
    /**
     * Asigna fecha renta
     * @param fechaRenta 
     */
    public void setFechaRenta(Fecha fechaRenta) {
        this.fechaRenta = fechaRenta;
    }
    /**
     * Método equals que compara si los objetos son iguales
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Renta) {
            Renta renta = (Renta) obj;
            if (cliente == renta.getCliente() && articulo == renta.getArticulo()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Método que genera un número para la clase
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.articulo);
        return hash;
    }
    /**
     * método que retorna los atributos en un string
     * @return 
     */
    @Override
    public String toString() {
        return "Número de crendencial: " + cliente.getNumCredencial() + ", Número de catalogo: " + articulo.getNumCatalogo() + ", Nombre articulo: " + articulo.titulo + ", Fecha renta: " + fechaRenta.getTime().toLocaleString()+", Tiempo de renta: "+tiempoRenta;
    }
}

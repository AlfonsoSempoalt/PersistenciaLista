package objetonegocio;

import java.util.Objects;

public class ArticuloED {

    private Articulo articulo;
    private int existencia;
    private int disponibilidad;

    /**
     * Constructor vacio de articuloED
     */
    public ArticuloED() {

    }
    /**
     * Constructor que solamente asigna articulo
     * @param articulo 
     */
    public ArticuloED(Articulo articulo) {
        this.articulo = articulo;
    }
    /**
     * Constructor que asigna todos los parametros de la clase 
     * @param articulo
     * @param existencia
     * @param disponibilidad 
     */
    public ArticuloED(Articulo articulo, int existencia, int disponibilidad) {
        this.articulo = articulo;
        this.disponibilidad = disponibilidad;
        this.existencia = existencia;
    }
    /**
     * Método que nos retorna el articulo
     * @return 
     */
    public Articulo getArticulo() {
        return articulo;
    }
    /**
     * metodo que asigna el articulo
     * @param articulo 
     */
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    /**
     * método que nos dice cuanto hay en existencia
     * @return 
     */
    public int getExistencia() {
        return existencia;
    }
    /**
     * método que asigna cuanto hay disponible
     * @param existencia 
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    /**
     * nos retorna si esta disponible el articulo
     * @return 
     */
    public int getDisponibilidad() {
        return disponibilidad;
    }   
    /**
     * asigna la disponibilidad del articulo
     * @param disponibilidad 
     */
    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    /**
     * método equals que nos dice si los objetos son iguales
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArticuloED) {
            ArticuloED artED = (ArticuloED) obj;
            if (artED.getArticulo() == articulo) {
                return true;
            }
        }
        return false;
    }
    /**
     * método hashcode que genera una clave única para el articulo
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.articulo);
        hash = 97 * hash + this.existencia;
        hash = 97 * hash + this.disponibilidad;
        return hash;
    }
    /**
     * método que nos retorna los atributos de la clase en string 
     * @return 
     */
    @Override
    public String toString() {
        String f=null;
            if (articulo instanceof Pelicula) {
            f= "Pelicula";
        } else if (articulo instanceof VideoJuego) {
            f= "Videojuego";
        }
        return "ArticuloED{" + "articulo=" + f + ", Num Catalogo= " + articulo.getNumCatalogo() + ", Nombre del articulo= " + articulo.getTitulo() + ", existencia=" + existencia + ", disponibilidad=" + disponibilidad + '}';
    }

}

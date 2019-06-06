package objetonegocio;

import java.util.Objects;

public class Articulo {

    protected String numCatalogo;
    protected String titulo;
    protected String genero;
    protected String clasificacion;
    /**
     * Constructor vacio de la clase articulo
     */
    public Articulo() {

    }
    /**
     * Constructor con todos los atributos de la clase 
     * @param numCatal String
     * @param titulo    String
     * @param genero    String  
     * @param clasificacion   String
     */
    public Articulo(String numCatal, String titulo, String genero, String clasificacion) {
        this.numCatalogo = numCatal;
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacion = clasificacion;
    }
    /**
     * Constructor que solamente asigna número en catalogo y el resto le asigna un null
     * @param numCatal 
     */
    public Articulo(String numCatal) {
        this.numCatalogo = numCatal;
        titulo = null;
        genero = null;
        clasificacion = null;
    }
    /**
     * retorna el num Catalogo
     * @return 
     */
    public String getNumCatalogo() {
        return numCatalogo;
    }
    /**
     * método para asignar el numCatalogo
     * @param numCatalogo 
     */
    public void setNumCatalogo(String numCatalogo) {
        this.numCatalogo = numCatalogo;
    }
    /**
     * nos retorna el titulo
     * @return 
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * nos asigna el titulo
     * @param titulo 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Nos retorna el genero del articulo
     * @return 
     */
    public String getGenero() {
        return genero;
    }
    /**
     * Asigna el genero
     * @param genero 
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    /**
     * nos retorna el genero 
     * @return Dato de tipo String
     */
    public String getClasificacion() {
        return clasificacion;
    }
    /**
     * Asigna la clasificacion del articulo 
     * @param clasificacion String
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    /**
     * Método que compara si el objeto es igual o no
     * @param obj
     * @return un boolean true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Articulo) {
            Articulo art = (Articulo) obj;
            if (numCatalogo.equalsIgnoreCase(art.numCatalogo)) {
                return true;
            } else {
                return false;
            }
        } 
            return false;
        

    }
    /**
     * hashCode que genera una clave única dependiendo de los atributos de clase
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 4;
        hash = 59 * hash + Objects.hashCode(this.numCatalogo);
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + Objects.hashCode(this.genero);
        hash = 59 * hash + Objects.hashCode(this.clasificacion);
        return hash;
    }
    /**
     * método toString que nos retorna un String con los atributos de clase
     * @return 
     */
    @Override
    public String toString() {
        return "numCatalogo=" + numCatalogo + ", titulo=" + titulo + ", genero=" + genero + ", clasificacion=" + clasificacion ;
    }
    

}

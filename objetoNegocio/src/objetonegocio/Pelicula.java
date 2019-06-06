package objetonegocio;

public class Pelicula extends Articulo {

    private String actor1;
    private String actor2;
    private String productora;

    /**
     * método constructor vacio de la clase
     */
    public Pelicula() {
    }

    /**
     * método constructor que asigna los valores de la clase padre y atributos
     * de esta clase
     *
     * @param actor1
     * @param actor2
     * @param productora
     * @param numCatal
     * @param titulo
     * @param genero
     * @param clasificacion
     */
    public Pelicula(String actor1, String actor2, String productora, String numCatal, String titulo, String genero, String clasificacion) {
        super(numCatal, titulo, genero, clasificacion);
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.productora = productora;
    }

    /**
     * método constructor que solo asigna el número de catalogo y el resto a
     * null
     *
     * @param numCatal
     */
    public Pelicula(String numCatal) {
        super(numCatal);
        actor1 = null;
        actor2 = null;
        productora = null;
        super.clasificacion = null;
        super.genero = null;
        super.titulo = null;
    }

    /**
     * regresa el nombre del actor número 1
     *
     * @return
     */
    public String getActor1() {

        return actor1;
    }

    /**
     * Asigna al actor 1
     *
     * @param actor1
     */
    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    /**
     * Retorna al actor 2
     *
     * @return
     */
    public String getActor2() {
        return actor2;
    }

    /**
     * Asigna al actor 2
     *
     * @param actor2
     */
    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    /**
     * Nos regresa la productora
     *
     * @return
     */
    public String getProductora() {
        return productora;
    }

    /**
     * Asigna la productora
     *
     * @param productora
     */
    public void setProductora(String productora) {
        this.productora = productora;
    }

    /**
     * Método toString que nos regresa los atributos de la clase
     *
     * @return
     */
    @Override
    public String toString() {
        return "Pelicula{" + super.toString() + "actor1=" + actor1 + ", actor2=" + actor2 + ", productora=" + productora + '}';
    }

}

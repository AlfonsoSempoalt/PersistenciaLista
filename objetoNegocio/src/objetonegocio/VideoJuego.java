 
package objetonegocio;
 
public class VideoJuego extends Articulo{
 private String consola;
 private String fabricante;
 private int version;
    /**
     * Constructor vacio
     */
    public VideoJuego() {
    }
    /**
     * Constructor que asigna todos los valores de atributos
     * @param consola
     * @param fabricante
     * @param version
     * @param numCatal
     * @param titulo
     * @param genero
     * @param clasificacion 
     */
    public VideoJuego(String consola, String fabricante, int version, String numCatal, String titulo, String genero, String clasificacion) {
        super(numCatal, titulo, genero, clasificacion);
        this.consola = consola;
        this.fabricante = fabricante;
        this.version = version;
    }
    /**
     * Constructor que solo asigna el numero de catalogo
     * @param numCatal 
     */
    public VideoJuego(String numCatal) {
        super(numCatal);
        super.clasificacion=null;
        super.genero=null;
        super.titulo=null;
        consola=null;
        fabricante=null;
        version=0;
    }
     
     /**
      * método que nos retorna la consola
      * @return 
      */

    public String getConsola() {
        return consola;
    }
    /**
     * Método que asigna la consola
     * @param consola 
     */
    public void setConsola(String consola) {
        this.consola = consola;
    }
    /**
     * Método que nos retorna el fabricante
     * @return 
     */
    public String getFabricante() {
        return fabricante;
    }
    /**
     * Método que asigna el fabricante
     * @param fabricante 
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    /**
     * Método que nos ayuda a obtener la versión
     * @return 
     */
    public int getVersion() {
        return version;
    }
    /**
     * método que asigna la versión
     * @param version 
     */
    public void setVersion(int version) {
        this.version = version;
    }
    /**
     * método que retorna los atributos en una cadena String
     * @return 
     */
    @Override
    public String toString() {
        return "VideoJuego{"+super.toString() + ", consola=" + consola + ", fabricante=" + fabricante + ", version=" + version + '}';
    }
    
 
    
}

package Fecha;

public class Periodo {

    public Fecha desde = new Fecha();
    public Fecha hasta = new Fecha();
    /**
     * Retronar el objeto desde
     * @return 
     */
    public Fecha getDesde() {
        return desde;
    }
    /**
     * método set del objeto desde
     * @param desde 
     */
    public void setDesde(Fecha desde) {
        this.desde = desde;
    }
    public Periodo(){
    }    /**
     * método get de objeto hasta
     * @return 
     */
    public Fecha getHasta() {
        return hasta;
    }
    /**
     * método set de hasta
     * @param hasta 
     */
    public void setHasta(Fecha hasta) {
        this.hasta = hasta;
    }
    /**
     * iguala los objetos de los paramatros a desde y hasta
     * @param desde
     * @param hasta 
     */
    public Periodo(Fecha desde, Fecha hasta) {
        this.desde = desde;
        this.hasta = hasta;

    }
    /**
     * nos dice si una fecha pertence a la clase periodo
     * @param fecha
     * @return 
     */
    public boolean cotiene(Fecha fecha) {

         if (hasta.getTime().toLocaleString().equals(fecha.getTime().toLocaleString()) ) {
            return true;
        } else if(desde.getTime().toLocaleString().equals(fecha.getTime().toLocaleString()) ){
            return true;
        }
        
        return false;
    }
    /**
     * Método to string donde pone la fecha desde y hasta en formato local
     * @return 
     */
    public String toString() {
        return desde.getTime().toLocaleString()+ " a "  + hasta.getTime().toGMTString();
    }

}

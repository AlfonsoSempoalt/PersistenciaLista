 
package objetosPago;

 
public class Pago {

    protected float subTotal;
    protected final float iva = 0.16f;
    protected float total;
    /**
     * Constructor vacio del objeto 
     */
    public Pago() {

    }
    /**
     * Método para asignar el subtotal
     * @param subTotal Valor de tipo flotante 
     */
    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
        total = (subTotal * iva) + subTotal;
    }
    /**
     * Regresa los detalles de la clase listos para imprimirlos
     * @return Un String con todos los detalles de la clase pago
     */
    public String detallePago() {
        return "SubTotal: "+subTotal+"\n Iva: "+(subTotal*iva)+"\n total: "+total;
    }
    
    /**
     * Método que nos retorna los valores de los atributos en una cadena
     * @return  Un valor de tipo String
     */
    @Override
    public String toString() {
        String subTota = Float.toString(subTotal);
        String iv = Float.toString(iva);
        String tot = Float.toString(total);
        return "El subtotal es= "+subTota+ "  El iva es= "+ iv+ " El total es= "+tot;
    }
}

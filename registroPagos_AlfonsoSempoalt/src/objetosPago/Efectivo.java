package objetosPago;

public class Efectivo extends Pago {
    /**
     * Constructor vacio de la clase
     */
    public Efectivo() {
    }
    /**
     * Método que nos retornal los detalles del pago en efectivo
     * @return un dato de tipo String 
     */
    @Override
    public String detallePago() {   
        return "SubTotal: " + subTotal + "\n Iva: " + (subTotal * iva) + "\n total: " + total+"Se ha realizado un pago de "+total+" en efectivo";
    }

}

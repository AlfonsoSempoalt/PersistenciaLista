package objetosPago;

import Fecha.*;

public class TarjetaCredito extends Pago {

    private String banco;
    private String numTarjeta;
    private Fecha fechaVencimiento;
    private String nombre;
    /**
     * Método constructor con parametros de la clase tarjeta de credito que hereda de la clase pago
     * @param banco String que es el primer parametro
     * @param numTarjeta String que es el segundo parametro
     * @param fechaVencimiento  Dato de tipo fecha que se le pasa como tercer parametro
     * @param nombre String con el nombre de la persona, 4to parametro
     */
    public TarjetaCredito(String banco, String numTarjeta, Fecha fechaVencimiento, String nombre) {
        this.banco = banco;
        this.numTarjeta = numTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.nombre = nombre;
    }
    /**
     * Nos regresa la fecha en que caduca
     * @return Dato de tipo String
     */
    public String getFechaVencimiento() {
        return fechaVencimiento.getTime().toLocaleString();
    }
    
    /**
     * Nos regresa los ultimos 4 números de la tarjeta
     * @return un dato de tipo String
     */
    public String tarjetaAsteriscos() {
        String tarjeta = numTarjeta.substring(12, 16);
        String tarjeta2 = "************";
        return tarjeta2 + tarjeta;
    }
    /**
     * regresa los datos de los atributos con los datos del pago 
     * @return Dato de tipo string 
     */
    @Override
    public String detallePago() {
        //System.out.println("El subtotal es:  " + subTotal);
        // System.out.println("El IVA es:  " + (subTotal * iva));
        //System.out.println("El total es:  " + total);
        return "SubTotal: " + subTotal + "\n Iva: " + (subTotal * iva) + "\n total: " + total + " \n \n \n Se ha realizado el pago de " + total + " con la tarjeta de " + banco + " con el número " + tarjetaAsteriscos() + "  a nombre de " + nombre;

    }

}

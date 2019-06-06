package objetosPago;

import Fecha.Fecha;
import java.util.Locale;
import java.util.Scanner;

public class Ticket {

    private Producto producto[] = new Producto[20];
    private int folio;
    Pago pago = new Pago();
    private Fecha fechaCompra = new Fecha();

    /**
     * Constructor del ticket en el cual van 3 parametros
     *
     * @param Folio 1er parametro de tipo entero
     * @param fechaCompra 2do parametro de tipo Fecha
     * @param pago 3er parametro de tipo Pago
     */
    public Ticket(int Folio, Fecha fechaCompra, Pago pago) {
        this.folio = folio;
        this.pago = pago;
        this.fechaCompra = fechaCompra;
        for (int i = 0; i < producto.length; i++) {
            producto[i] = new Producto(null, 0);
        }
    }

    /**
     * Agrega un objeto de un objeto tipo producto
     *
     * @param pp Producto a agregar a nuestro arreglo
     */
    public void agregaProductoDeUnObjeto(Producto pp) {
        for (int i = 0; i < producto.length; i++) {
            if (producto[i].getNombre() == null) {
                producto[i] = pp;
            }
        }
    }

    /**
     * Nos sirve para agregar productos en nuestro arreglo de 20 objetos
     */
    public void agregarProducto() {
        Scanner reader = new Scanner(System.in).useLocale(Locale.US);
        for (int i = 0; i < producto.length; i++) {
            if (producto[i].getNombre() == null) {
                System.out.println("Ingrese el nombre...");
                producto[i].setNombre(reader.nextLine());
                System.out.println("Ingrese el precio...");
                producto[i].setPrecioUnitario(reader.nextFloat());
                break;
            }
        }
    }

    /**
     * Calcula el subTotal de todo los objetos
     *
     * @return
     */
    public float calcularSubtotal() {
        float subTotal = 0f;
        for (int i = 0; i < producto.length; i++) {
            if (producto[i].getPrecioUnitario() != 0) {
                subTotal += producto[i].getPrecioUnitario();
            }
        }
        return subTotal;
    }

    /**
     * Elimina un objeto de nuestro arreglo
     *
     * @param nombre
     */
    public void eliminarProducto(String nombre) {
        for (int i = 0; i < producto.length; i++) {
            if (producto[i].getNombre().equalsIgnoreCase(nombre)) {
                producto[i].setNombre(null);
                producto[i].setPrecioUnitario(0);
                break;
            }
        }
    }

    /**
     * Nos sirve para generar un ticket con la información que le hayamos pasado
     * al mismo
     */
    public void generarTicket() {
        float v = 0;
        System.out.println(" Folio del ticket: " + folio);
        System.out.printf("%s %25s", "Producto", "Precio Unitario");
        System.out.printf("%s %25", "--------------------", "---------------------");
        for (int i = 0; i < producto.length; i++) {
            if (producto[i].getNombre() != null) {
                System.out.printf("%s %25f", producto[i].getNombre(), producto[i].getPrecioUnitario());
                v = v + producto[i].getPrecioUnitario();
            }
        }
        pago.subTotal=v;
        System.out.println("Subtotal:" + v);
        System.out.println("IVA: " + (v * .16f));
        System.out.println("total: " + ((v * .16f) + v));
        if (pago instanceof TarjetaCredito) {
            TarjetaCredito tar= (TarjetaCredito)pago;
            tar.detallePago();
        } else if (pago instanceof Efectivo) {
            Efectivo efectivo= (Efectivo)pago;
            efectivo.detallePago();
        }
        
    }

    /**
     * Nos retorna la fecha
     *
     * @return
     */
    public Fecha getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Regresa la fecha de la compra pero en String
     *
     * @return
     */
    public String getFechaCompraString() {
        return fechaCompra.getTime().toLocaleString();
    }

    /**
     * Nos sirve para asignar la fecha de nuestro ticket
     *
     * @param fechaCompra
     */
    public void setFechaCompra(Fecha fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Regresa los datos generales del ticket
     *
     * @return
     */
    @Override
    public String toString() {
        return "Folio " + folio + "; Pago" + pago + ";fecha:" + fechaCompra + ";producto" + producto[0];
    }
}

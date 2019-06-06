package objetosPago;

public class Producto {

    private String nombre;
    private float precioUnitario;
    /**
     * Constructor de la clase producto
     * @param nombre    primer parametro que es el nombre del producto
     * @param precioUnitario segundo parametro siendo el precio del producto
     */
    public Producto(String nombre, float precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }
    /**
     * Nos regresa el nombre del producto
     * @return  Dato de tipo String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Nos regresa el precio del producto
     * @return retorna un valor de tipo flotante
     */
    public float getPrecioUnitario() {
        return precioUnitario;
    }
    /**
     * Asigna el nombre del producto o nos permite cambiarlo 
     * @param nombre El nombre del producto de tipo String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Nos sirve para asignar o cambiar el nombre de un producto
     * @param precioUnitario Dato de tipo float el cual sera el precio del producto
     */
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    /**
     * Compara si el objeto del parametro es un de tipo producto y compara si las instancias tienen el mismo nombre
     * @param obj Objeto pasado como parametro
     * @return Nos retorna un valor booleano de true or false dependiendo de si cumplio o no su función 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Producto) {
            Producto pro = (Producto) obj;
            return pro.nombre.equalsIgnoreCase(nombre);
        }
        return false;
    }
    /**
     * Métodp que nos regresa en una linea los datos del producto
     * @return Dato de tipo String 
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\t\t Precio unitario: " + precioUnitario;
    }

}

package modelo;

public class Promocionable {
    // Atributos de la clase
    private String nombre;
    private double precio;
    private boolean enPromocion;
    private double descuento;

    // Constructor
    public Promocionable(String nombre, double precio, boolean enPromocion, double descuento) {
        this.nombre = nombre;
        this.precio = precio;
        this.enPromocion = enPromocion;
        this.descuento = descuento;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    // Método para calcular el precio final con descuento si está en promoción
    public double calcularPrecioFinal() {
        if (enPromocion) {
            return precio - (precio * descuento / 100);
        }
        return precio;
    }

    // Método toString para imprimir detalles del objeto
    @Override
    public String toString() {
        return "Promocionable{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", enPromocion=" + enPromocion +
                ", descuento=" + descuento +
                ", precio final=" + calcularPrecioFinal() +
                '}';
    }
}

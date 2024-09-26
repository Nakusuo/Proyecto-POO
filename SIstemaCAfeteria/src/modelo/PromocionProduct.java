package modelo;

public class PromocionProduct  {
    private final Producto producto;

    public PromocionProduct(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "PromocionProduct{" +
                "producto=" + producto +
                '}';
    }
}
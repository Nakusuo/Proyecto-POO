package modelo;

import java.util.ArrayList;
import java.util.List;

public class ModelProductos {
    private final List<Producto> productos;

    public ModelProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "ModelProductos{" +
                "productos=" + productos +
                '}';
    }
}
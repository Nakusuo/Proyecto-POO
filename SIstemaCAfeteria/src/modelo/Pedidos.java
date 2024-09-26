package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    private final List<Pedido> pedidos;

    public Pedidos() {
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "pedidos=" + pedidos +
                '}';
    }
}

package MODELO;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Bebida> bebidas;
    private List<Comida> comidas;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.bebidas = new ArrayList<>();
        this.comidas = new ArrayList<>();
    }

    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public void agregarComida(Comida comida) {
        comidas.add(comida);
    }

    public double calcularTotal() {
        double total = 0;
        for (Bebida bebida : bebidas) {
            total += bebida.getPrecio();
        }
        for (Comida comida : comidas) {
            total += comida.getPrecio();
        }
        return total;
    }

    public void mostrarPedido() {
        System.out.println("Pedido de " + cliente.getNombre() + ":");
        for (Bebida bebida : bebidas) {
            System.out.println(bebida);
        }
        for (Comida comida : comidas) {
            System.out.println(comida);
        }
        System.out.printf("Total: $%.2f%n", calcularTotal());
    }
}

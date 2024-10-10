
package VISTA;

import MODELO.Bebida;
import MODELO.Comida;
import MODELO.Pedido;

import java.util.List;

public class CafeteriaVista {
    public void mostrarMenuBebidas(List<Bebida> menu) {
        System.out.println("Menú de Bebidas:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public void mostrarMenuComidas(List<Comida> menu) {
        System.out.println("Menú de Comidas:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public void mostrarPedido(Pedido pedido) {
        pedido.mostrarPedido();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}


package CONTROLADOR;
import MODELO.Bebida;
import MODELO.Cliente;
import MODELO.Comida;
import MODELO.Pedido;
import VISTA.CafeteriaVista;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeteriaControlador {
    private List<Bebida> menuBebidas;
    private List<Comida> menuComidas;
    private CafeteriaVista vista;
    private Scanner scanner;

    public CafeteriaControlador() {
        this.menuBebidas = new ArrayList<>();
        this.menuComidas = new ArrayList<>();
        this.vista = new CafeteriaVista();
        this.scanner = new Scanner(System.in);
        cargarMenus();
    }

    private void cargarMenus() {
        menuBebidas.add(new Bebida("Café Americano", 2.5));
        menuBebidas.add(new Bebida("Café Latte", 3.0));
        menuBebidas.add(new Bebida("Té", 2.0));
        
        menuComidas.add(new Comida("Sándwich", 5.0));
        menuComidas.add(new Comida("Ensalada", 4.5));
    }

    public void iniciar() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefonoCliente = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombreCliente, telefonoCliente);
        Pedido pedido = new Pedido(cliente);

        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenuBebidas(menuBebidas);
            System.out.print("Seleccione una bebida (o 0 para continuar): ");
            int seleccionBebida = scanner.nextInt();
            if (seleccionBebida == 0) {
                break;
            }
            if (seleccionBebida > 0 && seleccionBebida <= menuBebidas.size()) {
                pedido.agregarBebida(menuBebidas.get(seleccionBebida - 1));
            } else {
                vista.mostrarMensaje("Selección inválida.");
            }
        }

        while (continuar) {
            vista.mostrarMenuComidas(menuComidas);
            System.out.print("Seleccione una comida (o 0 para finalizar): ");
            int seleccionComida = scanner.nextInt();
            if (seleccionComida == 0) {
                continuar = false;
            } else if (seleccionComida > 0 && seleccionComida <= menuComidas.size()) {
                pedido.agregarComida(menuComidas.get(seleccionComida - 1));
            } else {
                vista.mostrarMensaje("Selección inválida.");
            }
        }

        vista.mostrarPedido(pedido);
        vista.mostrarMensaje("Gracias por su pedido!");
        scanner.close();
    }
}

import Pedido.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pedido> todosLosPedidos = new ArrayList<>();

        do {
            // Crear un nuevo pedido
            Pedido pedido = new Pedido();

            // Ingresar datos desde consola para el pedido
            pedido.ingresarDatosDesdeConsola();

            // Mostrar información del pedido
            pedido.mostrarInformacion();

            // Agregar el pedido a la lista de todos los pedidos
            todosLosPedidos.add(pedido);

            // Preguntar al usuario si desea hacer un nuevo pedido
            System.out.print("¿Desea hacer un nuevo pedido? (s/n): ");
            String respuesta = scanner.next().toLowerCase();
            if (!respuesta.equals("s")) {
                break; // Salir del bucle si la respuesta no es "s"
            }

        } while (true); // El bucle continuará mientras el usuario responda "s"

        // Mostrar todos los pedidos al final
        Pedido.mostrarTodosLosPedidos(todosLosPedidos);

        // Buscar por cliente
        System.out.print("Ingrese el cliente a buscar: ");
        String clienteABuscar = scanner.next();
        Pedido.buscarPorCliente(todosLosPedidos, clienteABuscar);

        // Buscar por fecha
        System.out.print("Ingrese la fecha a buscar (YYYY-MM-DD): ");
        String fechaABuscarStr = scanner.next();
        LocalDate fechaABuscar = LocalDate.parse(fechaABuscarStr);
        Pedido.buscarPorFecha(todosLosPedidos, fechaABuscar);
    }
}

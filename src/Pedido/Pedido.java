package Pedido;

import Producto.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    private static int contadorPedidos = 0;
    private int id;
    private String cliente;
    private LocalDate fechaPedido;
    private ArrayList<Producto> productos;

    public Pedido() {
        this.id = ++contadorPedidos;
        this.fechaPedido = LocalDate.now();
        this.productos = new ArrayList<>();
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombreProducto) {
        // Utilizamos un bucle for-each para encontrar y eliminar el producto por nombre
        productos.removeIf(producto -> producto.getNombre().equals(nombreProducto));
    }

    public Producto buscarProductoPorNombre(String nombreProducto) {
        // Utilizamos un bucle for-each para buscar el producto por nombre
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto;
            }
        }
        return null; // Devolvemos null si no se encuentra el producto
    }

    public static void mostrarTodosLosPedidos(ArrayList<Pedido> pedidos) {
        System.out.println("Todos los pedidos:");
        for (Pedido pedido : pedidos) {
            pedido.mostrarInformacion();
            System.out.println("----------------------");
        }
    }

    public static void buscarPorCliente(ArrayList<Pedido> pedidos, String clienteABuscar) {
        System.out.println("Pedidos para el cliente '" + clienteABuscar + "':");
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().equalsIgnoreCase(clienteABuscar)) {
                pedido.mostrarInformacion();
                System.out.println("----------------------");
            }
        }
    }

    public static void buscarPorFecha(ArrayList<Pedido> pedidos, LocalDate fechaABuscar) {
        System.out.println("Pedidos para la fecha '" + fechaABuscar + "':");
        for (Pedido pedido : pedidos) {
            if (pedido.getFechaPedido().equals(fechaABuscar)) {
                pedido.mostrarInformacion();
                System.out.println("----------------------");
            }
        }
    }

    public void ingresarDatosDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el cliente del pedido: ");
        setCliente(scanner.next());

        // Menú interactivo para agregar productos
        for (Producto producto : crearProductosPorDefecto()) {
            System.out.print("¿Cuántos " + producto.getNombre() + " desea agregar al pedido?: ");
            int cantidad = scanner.nextInt();
            for (int i = 0; i < cantidad; i++) {
                agregarProducto(producto);
            }
        }
    }

    public void mostrarInformacion() {
        System.out.println("Información del pedido:");
        System.out.println("ID: " + getId());
        System.out.println("Cliente: " + getCliente());
        System.out.println("Fecha de Pedido: " + getFechaPedido());
        System.out.println("Productos:");
        for (Producto producto : productos) {
            producto.mostrarInformacion();
        }
    }

    private ArrayList<Producto> crearProductosPorDefecto() {
        ArrayList<Producto> productosPorDefecto = new ArrayList<>();

        // Crear 3 productos por defecto
        Producto producto1 = new Producto();
        producto1.setNombre("ProductoA");
        producto1.setPrecio(10.0);

        Producto producto2 = new Producto();
        producto2.setNombre("ProductoB");
        producto2.setPrecio(20.0);

        Producto producto3 = new Producto();
        producto3.setNombre("ProductoC");
        producto3.setPrecio(15.0);

        // Agregar los productos a la lista
        productosPorDefecto.add(producto1);
        productosPorDefecto.add(producto2);
        productosPorDefecto.add(producto3);

        return productosPorDefecto;
    }
}

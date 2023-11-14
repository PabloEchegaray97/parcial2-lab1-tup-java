package Producto;

public class Producto {
    private String nombre;
    private double precio;

    public Producto() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrarInformacion() {
        System.out.println("Producto: " + getNombre() + ", Precio: " + getPrecio());
    }
}

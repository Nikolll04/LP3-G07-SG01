package productoApp;

public class Producto {
    String nombre;
    double precio;
    int cantidadStock;
    String categoria;

    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nPrecio: $" + precio + "\nCantidad en Stock: " + cantidadStock + "\nCategoría: " + categoria;
    }
}

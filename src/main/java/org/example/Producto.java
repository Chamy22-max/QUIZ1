package org.example;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    private static List<Producto> productos = new ArrayList<>();

    private Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public static Producto crearProducto(String codigo, String nombre, double precio, int stock) {
        Producto producto = new Producto(codigo, nombre, precio, stock);
        productos.add(producto);
        return producto;
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }

    public void venderProducto(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
            System.out.println("Venta realizada. Stock restante: " + stock);
        } else {
            System.out.println("No hay suficiente stock para vender.");
        }
    }

    public void aplicarDescuento() {
        precio = precio * 0.98;
        System.out.println("Nuevo precio después del descuento: " + precio);
    }

    public void aumentarPrecio() {
        precio = precio * 1.06;
        System.out.println("Nuevo precio después del aumento: " + precio);
    }

    public double calcularValorTotalInventario() {
        return stock * precio;
    }

    public static void eliminarProductoPorCodigo(String codigo) {
        productos.removeIf(producto -> producto.codigo.equals(codigo));
        System.out.println("Producto con código " + codigo + " ha sido eliminado.");
    }

    public static List<Producto> obtenerProductos() {
        return productos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void reponerStock(int cantidadReponer) {
    }
}

package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione lo que desea realizar:");
            System.out.println("1. Crear Producto");
            System.out.println("2. Vender Producto");
            System.out.println("3. Reponer Stock");
            System.out.println("4. Aplicar Descuento del 2%");
            System.out.println("5. Mostrar Información de un producto");
            System.out.println("6. Aumentar Precio a un 6%");
            System.out.println("7. Calcular Valor Total en Inventario");
            System.out.println("8. Eliminar Producto por Código");
            System.out.println("9. Mostrar Todos los Productos");
            System.out.println("10. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del producto:");
                    System.out.print("Código: ");
                    String codigo1 = scanner.nextLine();

                    if (existeCodigo(codigo1)) {
                        System.out.println("Error!! Este Codigo ya existe");
                    } else {
                        System.out.print("Nombre: ");
                        String nombre1 = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precio1 = scanner.nextDouble();
                        System.out.print("Stock: ");
                        int stock1 = scanner.nextInt();
                        scanner.nextLine();
                        Producto.crearProducto(codigo1, nombre1, precio1, stock1);
                        System.out.println("Ha creado su producto");
                    }
                    break;

                case 2:
                    System.out.print("Código del producto a vender: ");
                    String codigoVender = scanner.nextLine();
                    Producto productoVender = buscarProductoPorCodigo(codigoVender);
                    if (productoVender != null) {
                        System.out.print("Ingrese la cantidad a vender: ");
                        int cantidadVender = scanner.nextInt();
                        productoVender.venderProducto(cantidadVender);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Código del producto a reponer: ");
                    String codigoReponer = scanner.nextLine();
                    Producto productoReponer = buscarProductoPorCodigo(codigoReponer);
                    if (productoReponer != null) {
                        System.out.print("Ingrese la cantidad a reponer: ");
                        int cantidadReponer = scanner.nextInt();
                        productoReponer.reponerStock(cantidadReponer);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Código del producto para aplicar descuento: ");
                    String codigoDescuento = scanner.nextLine();
                    Producto productoDescuento = buscarProductoPorCodigo(codigoDescuento);
                    if (productoDescuento != null) {
                        productoDescuento.aplicarDescuento();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el código del producto a mostrar: ");
                    String codigoMostrar = scanner.nextLine();
                    Producto productoMostrar = buscarProductoPorCodigo(codigoMostrar);
                    if (productoMostrar != null) {
                        productoMostrar.mostrarInformacion();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el código del producto para aumentar precio: ");
                    String codigoAumento = scanner.nextLine();
                    Producto productoAumento = buscarProductoPorCodigo(codigoAumento);
                    if (productoAumento != null) {
                        productoAumento.aumentarPrecio();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el código del producto para calcular valor: ");
                    String codigoValor = scanner.nextLine();
                    Producto productoValor = buscarProductoPorCodigo(codigoValor);
                    if (productoValor != null) {
                        System.out.println("Valor total en inventario: " + productoValor.calcularValorTotalInventario());
                    } else System.out.println("Producto no encontrado.");
                    break;

                case 8:
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    Producto.eliminarProductoPorCodigo(codigoEliminar);
                    break;

                case 9:
                    List<Producto> productos = Producto.obtenerProductos();
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos disponibles.");
                    } else {
                        for (Producto producto : productos) {
                            producto.mostrarInformacion();
                            System.out.println();
                        }
                    }
                    break;

                case 10:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : Producto.obtenerProductos()) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    private static boolean existeCodigo(String codigo) {
        for (Producto producto : Producto.obtenerProductos()) {
            if (producto.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
}

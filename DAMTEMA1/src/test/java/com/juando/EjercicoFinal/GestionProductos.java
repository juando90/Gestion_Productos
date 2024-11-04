package com.juando.EjercicoFinal;

import java.util.Scanner;

/**
 * Clase que gestiona las operaciones relacionadas con los productos.
 * 
 * Esta clase proporciona métodos para agregar, buscar, modificar, eliminar
 * y exportar productos a un archivo CSV, interactuando con la clase Productos
 * y el sistema de almacenamiento XML.
 */
public class GestionProductos {
    private static Productos productos = ManejadorXML.cargarProductos(); // Carga los productos desde el archivo XML

    /**
     * Método para agregar un nuevo producto.
     *
     * @param scanner El objeto Scanner utilizado para leer entradas del usuario.
     */
    protected static void agregarProducto(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        double precio = Validador.validarPrecio(scanner); // Validar y obtener el precio
        int cantidad = Validador.validarStock(scanner); // Validar y obtener la cantidad

        Producto producto = new Producto(); // Crear una nueva instancia de Producto
        producto.setNombre(nombre); // Establecer el nombre del producto
        producto.setPrecio(precio); // Establecer el precio del producto
        producto.setCantidad(cantidad); // Establecer la cantidad del producto

        productos.agregarProducto(producto); // Agregar el producto a la lista
        ManejadorXML manejadorXML = new ManejadorXML(); // Crear instancia de ManejadorXML
        manejadorXML.guardarProductos(productos); // Guardar la lista actualizada en el archivo XML
        System.out.println("Producto agregado con éxito."); // Mensaje de éxito
    }

    /**
     * Método para buscar un producto por su nombre.
     *
     * @param scanner El objeto Scanner utilizado para leer entradas del usuario.
     */
    protected static void buscarProducto(Scanner scanner) {
        System.out.print("Nombre del producto a buscar: ");
        String nombre = scanner.nextLine(); // Leer el nombre del producto a buscar

        Producto productoEncontrado = productos.buscarProducto(nombre); // Llama al método buscarProducto
        if (productoEncontrado != null) { // Verificar si se encontró el producto
            System.out.println("Producto encontrado:");
            System.out.println("Nombre: " + productoEncontrado.getNombre());
            System.out.println("Precio: " + productoEncontrado.getPrecio());
            System.out.println("Cantidad en stock: " + productoEncontrado.getCantidad());
        } else {
            System.out.println("Producto no encontrado."); // Mensaje si no se encuentra el producto
        }
    }

    /**
     * Método para modificar un producto existente.
     *
     * @param scanner El objeto Scanner utilizado para leer entradas del usuario.
     */
    protected static void modificarProducto(Scanner scanner) {
        System.out.print("Nombre del producto a modificar: ");
        String nombre = scanner.nextLine(); // Leer el nombre del producto a modificar

        Producto producto = productos.buscarProducto(nombre); // Busca el producto
        if (producto != null) { // Verificar si se encontró el producto
            double nuevoPrecio = Validador.validarPrecio(scanner); // Validar y obtener el nuevo precio
            int nuevaCantidad = Validador.validarStock(scanner); // Validar y obtener la nueva cantidad
            producto.setPrecio(nuevoPrecio); // Actualizar el precio del producto
            producto.setCantidad(nuevaCantidad); // Actualizar la cantidad del producto

            ManejadorXML manejadorXML = new ManejadorXML(); // Crear instancia de ManejadorXML
            manejadorXML.guardarProductos(productos); // Guardar la lista actualizada en el archivo XML
            System.out.println("Producto modificado con éxito."); // Mensaje de éxito
        } else {
            System.out.println("Producto no encontrado."); // Mensaje si no se encuentra el producto
        }
    }

    /**
     * Método para eliminar un producto existente.
     *
     * @param scanner El objeto Scanner utilizado para leer entradas del usuario.
     */
    protected static void eliminarProducto(Scanner scanner) {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine(); // Leer el nombre del producto a eliminar

        boolean eliminado = productos.eliminarProducto(nombre); // Llama al método eliminarProducto
        if (eliminado) { // Verificar si el producto fue eliminado
            ManejadorXML manejadorXML = new ManejadorXML(); // Crear instancia de ManejadorXML
            manejadorXML.guardarProductos(productos); // Guardar la lista actualizada en el archivo XML
            System.out.println("Producto eliminado con éxito."); // Mensaje de éxito
        } else {
            System.out.println("Producto no encontrado."); // Mensaje si no se encuentra el producto
        }
    }

    /**
     * Método para exportar la lista de productos a un archivo CSV.
     *
     * @param scanner El objeto Scanner utilizado para leer entradas del usuario.
     */
    protected static void exportarACSV(Scanner scanner) {
        System.out.print("Ingrese el nombre del archivo CSV (deje en blanco para 'productos.csv'): ");
        String fileName = scanner.nextLine().trim(); // Leer el nombre del archivo CSV

        // Si el usuario no ingresa un nombre, usar un nombre predeterminado
        if (fileName.isEmpty()) {
            fileName = "productos.csv"; // Nombre predeterminado
        } else if (!fileName.endsWith(".csv")) {
            // Asegurarse de que el nombre del archivo termine en .csv
            fileName += ".csv"; // Agregar extensión .csv si no está presente
        }

        // Llamar al exportador para generar el archivo CSV
        ExportadorCSV.exportarProductos(productos, fileName); // Exportar productos a CSV
    }
}
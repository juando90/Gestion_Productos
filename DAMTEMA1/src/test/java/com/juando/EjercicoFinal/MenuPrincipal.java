package com.juando.EjercicoFinal;
import java.util.Scanner;

/**
 * Clase principal que gestiona el menú del programa.
 * 
 * Este programa permite a los usuarios agregar, buscar, modificar, eliminar y exportar productos
 * desde una lista de productos utilizando un menú interactivo.
 */
public class MenuPrincipal {
    
    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Los argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializa el escáner para leer entradas del usuario
        boolean salir = false; // Bandera para controlar la salida del bucle

        // Bucle principal del menú
        while (!salir) {
            System.out.println("\nSeleccione una opción:");
            MenuOpciones.mostrarOpcionesMenu();  // Mostrar las opciones del menú

            // Leer y validar la opción del menú
            MenuOpciones opcion = Validador.validarOpcionMenu(scanner);

            // Procesar la opción seleccionada
            switch (opcion) {
                case AGREGAR_PRODUCTO:
                    GestionProductos.agregarProducto(scanner); // Agregar un nuevo producto
                    break;
                case BUSCAR_PRODUCTO:
                    GestionProductos.buscarProducto(scanner); // Buscar un producto existente
                    break;
                case MODIFICAR_PRODUCTO:
                    GestionProductos.modificarProducto(scanner); // Modificar un producto
                    break;
                case ELIMINAR_PRODUCTO:
                    GestionProductos.eliminarProducto(scanner); // Eliminar un producto
                    break;
                case EXPORTAR_CSV:
                    GestionProductos.exportarACSV(scanner); // Exportar productos a CSV
                    break;
                case SALIR:
                    salir = true; // Cambiar la bandera para salir del bucle
                    break;
                default:
                    // No debería llegar aquí porque la opción se valida, pero se deja por si acaso
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close(); // Cerrar el escáner al final
    }
}
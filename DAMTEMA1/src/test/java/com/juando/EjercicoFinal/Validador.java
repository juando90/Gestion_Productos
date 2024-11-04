package com.juando.EjercicoFinal;

import java.util.Scanner;
/**
 * Clase que proporciona métodos para validar entradas del usuario.
 *
 * Esta clase incluye métodos para validar el precio de un producto,
 * la cantidad en stock y la opción de menú seleccionada por el usuario.
 */
public class Validador {

    /**
     * Valida el precio ingresado por el usuario.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     * @return El precio ingresado como un número decimal válido.
     */
    public static double validarPrecio(Scanner scanner) {
        double precio = 0.0; // Variable para almacenar el precio
        boolean esValido = false; // Bandera para controlar la validez del precio

        // Bucle para seguir pidiendo el precio hasta que sea válido
        while (!esValido) {
            System.out.print("Precio del producto: ");
            String precioInput = scanner.nextLine(); // Leer la entrada del usuario

            // Verificar que el precio solo contenga dígitos, con o sin separador decimal
            if (precioInput.matches("[0-9]+([.,][0-9]+)?")) {
                // Reemplazar coma por punto para normalizar el formato decimal
                precioInput = precioInput.replace(",", ".");
                try {
                    precio = Double.parseDouble(precioInput); // Convertir la entrada a un número decimal
                    esValido = true; // Cambiar a true para salir del bucle
                } catch (NumberFormatException e) {
                    System.out.println("Error: El valor ingresado no es un número válido.");
                }
            } else {
                System.out.println("Error: Solo se permiten números y un separador decimal (punto o coma).");
            }
        }
        return precio; // Retornar el precio válido
    }

    /**
     * Valida la cantidad de productos en stock ingresada por el usuario.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La cantidad ingresada como un número entero no negativo.
     */
    public static int validarStock(Scanner scanner) {
        int cantidad = 0; // Variable para almacenar la cantidad
        boolean esValido = false; // Bandera para controlar la validez de la cantidad

        // Bucle para seguir pidiendo la cantidad hasta que sea válida
        while (!esValido) {
            System.out.print("Cantidad en stock: ");
            if (scanner.hasNextInt()) { // Verificar si la entrada es un entero
                cantidad = scanner.nextInt(); // Leer la cantidad
                if (cantidad >= 0) { // Verificar que la cantidad no sea negativa
                    esValido = true; // Cambiar a true si es válida
                } else {
                    System.out.println("Error: Por favor ingrese un número entero positivo.");
                }
            } else {
                System.out.println("Error: Entrada no válida. Introduzca un número entero.");
                scanner.next(); // Descartar la entrada inválida
            }
            scanner.nextLine(); // Limpiar el buffer
        }
        return cantidad; // Retornar la cantidad válida
    }

    /**
     * Valida la opción de menú ingresada por el usuario.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La opción de menú seleccionada como un objeto de tipo MenuOpciones.
     */
    public static MenuOpciones validarOpcionMenu(Scanner scanner) {
        MenuOpciones opcionSeleccionada = null; // Variable para almacenar la opción seleccionada
        boolean esValido = false; // Bandera para controlar la validez de la opción

        // Bucle para seguir pidiendo la opción hasta que sea válida
        while (!esValido) {
            System.out.print("Elige una opción: ");
            if (scanner.hasNextInt()) { // Verificar si la entrada es un entero
                int codigo = scanner.nextInt(); // Leer el código de la opción
                scanner.nextLine(); // Limpiar el buffer
                opcionSeleccionada = MenuOpciones.desdeCodigo(codigo); // Obtener la opción correspondiente
                if (opcionSeleccionada != null) {
                    esValido = true; // Cambiar a true si la opción es válida
                } else {
                    System.out.println("Error: Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Error: Entrada no válida. Introduzca un número.");
                scanner.next(); // Descartar la entrada inválida
            }
        }
        return opcionSeleccionada; // Retornar la opción seleccionada
    }
}




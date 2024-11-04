package com.juando.EjercicoFinal;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que se encarga de exportar productos a un archivo en formato CSV.
 *
 * Esta clase proporciona un método estático para generar un archivo CSV
 * a partir de una lista de productos.
 */
public class ExportadorCSV {

    /**
     * Exporta los productos a un archivo CSV.
     *
     * Este método crea un archivo CSV con la cabecera correspondiente y
     * agrega cada producto de la lista de productos en el formato:
     * Nombre, Precio, Cantidad.
     *
     * @param productos La lista de productos a exportar.
     * @param fileName  El nombre del archivo CSV a crear.
     */
    public static void exportarProductos(Productos productos, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Escribir la cabecera del CSV
            writer.append("Nombre,Precio,Cantidad\n");

            // Iterar sobre los productos y escribir cada uno en el CSV
            for (Producto producto : productos.getListaProducto()) {
                writer.append(producto.getNombre()) // Nombre del producto
                      .append(",")
                      .append(String.valueOf(producto.getPrecio())) // Precio del producto
                      .append(",")
                      .append(String.valueOf(producto.getCantidad())) // Cantidad del producto
                      .append("\n"); // Nueva línea para el siguiente producto
            }

            System.out.println("Archivo CSV exportado correctamente a " + fileName);
        } catch (IOException e) {
            System.out.println("Error al exportar los datos a CSV: " + e.getMessage());
        }
    }
}
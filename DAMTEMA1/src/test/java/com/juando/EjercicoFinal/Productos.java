package com.juando.EjercicoFinal;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa una colección de productos.
 *
 * Esta clase se utiliza para gestionar una lista de objetos de tipo Producto,
 * permitiendo agregar, eliminar, buscar y modificar productos en la colección.
 * Está anotada para ser utilizada con JAXB para la serialización y deserialización XML.
 */
@XmlRootElement(name = "productos")
public class Productos {
    private List<Producto> listaProducto; // Lista de productos

    /**
     * Constructor que inicializa la lista de productos.
     */
    public Productos() {
        this.listaProducto = new ArrayList<>(); // Inicializa la lista vacía
    }

    /**
     * Obtiene la lista de productos.
     *
     * @return La lista de productos.
     */
    @XmlElement(name = "producto")
    public List<Producto> getListaProducto() {
        return listaProducto; // Retorna la lista de productos
    }

    /**
     * Establece la lista de productos.
     *
     * @param listaProducto La nueva lista de productos a establecer.
     */
    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto; // Establece la lista de productos
    }

    /**
     * Agrega un nuevo producto a la lista.
     *
     * @param producto El producto a agregar a la lista.
     */
    public void agregarProducto(Producto producto) {
        listaProducto.add(producto); // Añade el producto a la lista
    }

    /**
     * Elimina un producto de la lista por su nombre.
     *
     * @param nombre El nombre del producto a eliminar.
     * @return true si el producto fue eliminado, false si no se encontró.
     */
    public boolean eliminarProducto(String nombre) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getNombre().equalsIgnoreCase(nombre)) {
                listaProducto.remove(i); // Elimina el producto de la lista
                return true; // Producto eliminado
            }
        }
        return false; // Producto no encontrado
    }

    /**
     * Busca un producto en la lista por su nombre.
     *
     * @param nombre El nombre del producto a buscar.
     * @return El producto encontrado o null si no se encuentra.
     */
    public Producto buscarProducto(String nombre) {
        for (Producto producto : listaProducto) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto; // Producto encontrado
            }
        }
        return null; // Producto no encontrado
    }

    /**
     * Modifica el precio y la cantidad de un producto por su nombre.
     *
     * @param nombre        El nombre del producto a modificar.
     * @param nuevoPrecio   El nuevo precio del producto.
     * @param nuevaCantidad La nueva cantidad del producto.
     * @return true si la modificación fue exitosa, false si el producto no se encontró.
     */
    public boolean modificarProducto(String nombre, double nuevoPrecio, int nuevaCantidad) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio); // Establece el nuevo precio
            producto.setCantidad(nuevaCantidad); // Establece la nueva cantidad
            return true; // Modificación exitosa
        }
        return false; // Producto no encontrado
    }
}
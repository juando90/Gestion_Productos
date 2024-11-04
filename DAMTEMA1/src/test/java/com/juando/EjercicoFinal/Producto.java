package com.juando.EjercicoFinal;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa un producto.
 *
 * Esta clase es utilizada para almacenar información sobre un producto,
 * incluyendo su nombre, precio y cantidad en stock. Está anotada para
 * ser utilizada con JAXB para la serialización y deserialización XML.
 */
@XmlRootElement(name = "producto")
public class Producto {

    private String nombre;    // Nombre del producto
    private Double precio;    // Precio del producto
    private int cantidad;     // Cantidad en stock del producto

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    @XmlElement
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    @XmlElement
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad en stock del producto.
     *
     * @return La cantidad en stock del producto.
     */
    @XmlElement
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad en stock del producto.
     *
     * @param cantidad La nueva cantidad en stock del producto.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
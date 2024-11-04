package com.juando.EjercicoFinal;
/**
 * Enum que define las opciones del menú.
 * 
 * Este enum contiene las diferentes opciones que el usuario puede seleccionar
 * en el menú principal de la aplicación, junto con sus descripciones y códigos asociados.
 */
public enum MenuOpciones {
    
    AGREGAR_PRODUCTO(1, "Agregar un nuevo producto"),
    BUSCAR_PRODUCTO(2, "Buscar un producto"),
    MODIFICAR_PRODUCTO(3, "Modificar un producto"),
    ELIMINAR_PRODUCTO(4, "Eliminar un producto"),
    EXPORTAR_CSV(5, "Exportar a CSV"),
    SALIR(6, "Salir");

    private final int codigo; // Código numérico asociado a cada opción
    private final String descripcion; // Descripción de la opción

    /**
     * Constructor del enum.
     *
     * @param codigo El código numérico de la opción.
     * @param descripcion La descripción de la opción.
     */
    MenuOpciones(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el código de la opción.
     *
     * @return El código numérico de la opción.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Obtiene la descripción de la opción.
     *
     * @return La descripción textual de la opción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para obtener una opción del enum a partir de su código.
     *
     * @param codigo El código numérico de la opción.
     * @return La opción correspondiente al código, o null si no hay coincidencia.
     */
    public static MenuOpciones desdeCodigo(int codigo) {
        for (MenuOpciones opcion : values()) {
            if (opcion.getCodigo() == codigo) {
                return opcion; // Retornar la opción correspondiente
            }
        }
        return null; // Si el código no coincide con ninguna opción
    }

    /**
     * Método para mostrar las opciones del menú en la consola.
     * 
     * Este método imprime todas las opciones disponibles junto con sus códigos
     * en la consola para que el usuario pueda seleccionar una.
     */
    public static void mostrarOpcionesMenu() {
        for (MenuOpciones opcion : MenuOpciones.values()) {
            System.out.println(opcion.getCodigo() + ". " + opcion.getDescripcion()); // Imprimir cada opción
        }
    }
}
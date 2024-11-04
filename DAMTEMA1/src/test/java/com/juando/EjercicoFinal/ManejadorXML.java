package com.juando.EjercicoFinal;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Clase que maneja las operaciones de carga y almacenamiento de productos en formato XML.
 *
 * Esta clase utiliza JAXB para serializar y deserializar objetos de tipo Productos
 * desde y hacia un archivo XML.
 */
public class ManejadorXML {
	private static final String FILE_PATH = "productos.xml"; // Ruta del archivo XML donde se almacenan los productos

	/**
	 * Carga los productos desde el archivo XML.
	 *
	 * @return Un objeto de tipo Productos que contiene los productos cargados,
	 *         o un nuevo objeto Productos vacío si no se puede cargar.
	 */
	public static Productos cargarProductos() {
		try {
			// Crear un objeto File que representa el archivo XML
			File file = new File(FILE_PATH); 
			// Verificar si el archivo no existe
			if (!file.exists()) { 
				// Retornar un nuevo objeto Productos vacío
				return new Productos(); 
			}
			// Crear un contexto JAXB para la clase Productos
			JAXBContext jaxbContext = JAXBContext.newInstance(Productos.class);
			// Crear un unmarshaller para deserializar el XML
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			// Deserializar el contenido del archivo XML a un objeto Productos
			return (Productos) unmarshaller.unmarshal(file); 
		} catch (JAXBException e) {
			e.printStackTrace(); // Imprimir la traza de la excepción si ocurre un error
			return new Productos(); // Retornar un nuevo objeto Productos vacío en caso de error
		}
	}

	/**
	 * Guarda los productos en el archivo XML.
	 *
	 * @param productos El objeto Productos que se desea guardar en el archivo XML.
	 */
	public void guardarProductos(Productos productos) {
		try {
			// Crear un contexto JAXB para la clase Productos
			JAXBContext jaxbContext = JAXBContext.newInstance(Productos.class);
			// Crear un marshaller para serializar el objeto
			Marshaller marshaller = jaxbContext.createMarshaller(); 
			// Configurar el marshaller para salida formateada
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// Serializar el objeto Productos y guardarlo en el archivo XML
			marshaller.marshal(productos, new File(FILE_PATH)); 
		} catch (JAXBException e) {
			e.printStackTrace(); // Imprimir la traza de la excepción si ocurre un error
		}
	}
}
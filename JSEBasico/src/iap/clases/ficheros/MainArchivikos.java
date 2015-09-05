package iap.clases.ficheros;

import java.io.File;

/**
 * Clase creada para manejar.
 * @author Tamara (feat I�aki)
 *
 */
public class MainArchivikos {
	/**
	 * M�todo para que desde el directorio actual (�.�), recorra el arbol de directorios y
	 * muestre todos los directorios, subdirectorios y sus respectivos archivos.  
	 * @param ruta debo introducir la ruta del directorio que quiero mostrar.
	 */
	public static void explorar (String ruta){
		
		File explorador = new File(ruta); //creo un objeto File con el parametro ruta que se introduce
		File [] archivos = explorador.listFiles(); //igualo el m�todo listFiles me devuelve los archivos
		
		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
			if (archivos[i].isDirectory()&& !archivos[i].isHidden()) {
				explorar(archivos[i].getPath());
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		explorar(".");
	}
}

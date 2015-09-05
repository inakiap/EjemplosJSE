 package iap.clases.log4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class MainPruebas {

	private final static Logger log = Logger.getLogger("miregistro");

	public static void main(String[] args) {
		//leer el argumento que entra en el main para leer uno de los archivos de propierties
		Properties propiedades = new Properties();
		FileInputStream entrada = null;
		
		log.error("Oennn, Error!!!");
		log.info("Informando...");
		log.warn("Cuidaito!!!!!");
		log.debug("dice debug");
		log.trace("dice trace");
		
		//Seg�n el idioma tomar los valores adecuados
		
			try {
				entrada = new FileInputStream("story_en.properties");
				try {
					propiedades.load(entrada);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//String tale = "" ;
			System.out.println(propiedades.getProperty("start"));

	}

}

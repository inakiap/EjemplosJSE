package iap.clases.properties;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CuentikoMain {

	//generar el cuento
	//escribirlo en un fichero
	
	public static void main(String[] args) {
		//leer el argumento que entra en el main para leer uno de los archivos de propierties
		Properties propiedades = new Properties();
		InputStream entrada = null;
		
		String cuento = "" ;
				
		//Según el idioma tomar los valores adecuados
		switch (args[0]) {
		case "en":
			try {
				entrada = new FileInputStream("story_en.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
		case "it":
			try {
				entrada = new FileInputStream("story_it.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			break;
			
		case "es":
			try {
				entrada = new FileInputStream("story_es.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
			
			
		default:
			System.out.println("No has dicho en que idioma");
			break;
		}
		try {
			propiedades.load(entrada);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cuento = propiedades.getProperty("start")+" "+propiedades.getProperty("body")+" "+propiedades.getProperty("end");
		System.out.println(cuento);
		
		//creo un objeto File con el parametro ruta que se introduce
				FileWriter fw = null;
				try {
					fw = new FileWriter(propiedades.getProperty("outfile"), false);
					BufferedWriter bw = new BufferedWriter(fw);

					bw.write(cuento);
							
					bw.close();
					fw.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
}



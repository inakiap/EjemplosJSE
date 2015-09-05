package iap.clases.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Practica2Main {
	/**
	 * Método para leer un archivo de texto.FicheroToArray
	 * 
	 * @param ruta
	 * @return
	 */
	public static String [] leerFichero (String ruta) {
		String [] lineas = null;
		//coger un archivo
		File f = new File(ruta);//creo un objeto File con el parametro ruta que se introduce
		
		if (f.exists() && f.isFile() && f.canRead()) {//comprobar que existe, si es un archivo de texto y que se puede leer
			FileReader fileReader = null;
			
			try {
				fileReader = new FileReader(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BufferedReader lector = new BufferedReader(fileReader);
			
			
			int i = 0;
					
			try {
				while (lector.readLine()!= null) {
					i++;
					System.out.println(i);
						
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fileReader.close();
				lector.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			try {
				fileReader = new FileReader(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lector = new BufferedReader(fileReader);
			
			
		if (i != 0) {
			lineas = new String [i];
				
			for (int j = 0; j < lineas.length; j++) {
					
					try {
						lineas [j] = lector.readLine();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				}			
			}
		}
		return lineas;
	}		
		
	

	/**
	 * Método para guardar un archivo de texto a un fichero dado. ArrayToFichero
	 * 
	 * @param contenido
	 * @param destino
	 * @return
	 */
	static void guardarFichero(String [] contenido, String destino) {
		
		//creo un objeto File con el parametro ruta que se introduce
		File f = new File(destino);
		//comprobar que existe, si es un archivo de texto y que se puede leer
		if (f.exists() && f.isFile() && f.canRead()) {
			FileWriter fw = null;
			
			try {
				fw = new FileWriter(destino, true);
				BufferedWriter bw = new BufferedWriter(fw);

				for (int j = 0; j < contenido.length; j++) {
					bw.write(contenido[j]);
					bw.newLine();
				}
				bw.close();
				fw.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
	}		

	
	/**
	 * Método que copia un archivo binario
	 * @param origen
	 * @param destino
	 */
	static void ficheroToFichero (String origen , String destino) {
		File file1 = null;
		File file2 = null;
		
		FileInputStream fIS = null;
		FileOutputStream fOS = null;
		
		try {
			file1 = new File (origen);
			file2 = new File (destino);

			fIS = new FileInputStream(file1);
			fOS = new FileOutputStream(file2);
			
			file2.createNewFile();
			
			int contenido = 0;
			while ((contenido = fIS.read())!=-1){
					fOS.write(contenido); 
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	String [] mierda = leerFichero("ficherico1.txt");
		for (int i = 0; i < mierda.length; i++) {
			System.out.println(mierda[i]);
		}
		*/
		//guardarFichero(leerFichero("ficherico1.txt"), "ficherico3.txt");
		
		ficheroToFichero("foto.jpg", "foto2.jpg");
	}
}



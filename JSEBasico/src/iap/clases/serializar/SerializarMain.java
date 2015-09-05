package iap.clases.serializar;

import iap.clases.persona.Persona;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializarMain {
	public static void main(String[] args) {
		Persona personika1 = new Persona ("Juanico", 44);
		Persona personika2 = new Persona ("Pagiao", 55);
		Persona personika3 = new Persona ("Migra�a", 38);
		Persona personika4 = new Persona ("Bella", 34);
		
		Persona [] listaPersonas = {personika1, personika2, personika3, personika4};
		//serializar estas personas en un fichero
		
		ObjectOutputStream alFichero = null;
		try {
			alFichero = new ObjectOutputStream(new FileOutputStream("ficheroPersonas.txt"));
			alFichero.writeObject(listaPersonas);
			alFichero.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectInputStream delFichero = null;
		try {
			delFichero = new ObjectInputStream(new FileInputStream("ficheroPersonas.txt"));
			try {
				Persona [] listaDevuerta = (Persona []) delFichero.readObject();
				
				for (int i = 0; i < listaDevuerta.length; i++) {
					System.out.println(listaDevuerta [i].getNombre()+ " "+ listaDevuerta [i].getEdad());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}



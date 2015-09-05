package iap.clases.excepciones;

import iap.clases.persona.Persona;

public class MainExcetions {

	public static void main(String[] args) {
		Persona per1 = new Persona ();
		Persona per2 = new Persona ();
		Persona per3 = new Persona ();
		
		Persona [] grupoPer = {per1, per2, per3};
		try {
			for (int i = 0; i <= grupoPer.length; i++) {
				System.out.println(grupoPer[i]);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new InsertarPersonasExcetion("traca!! Fallaco en el array");
		}
		
	}
}

package iap.clases.cajonDesastre;

import java.util.Scanner;


/*
import java.util.regex.Matcher;
import java.util.regex.Pattern;*/

public class Password {
	static Scanner sc = new Scanner(System.in);
	private String palabraClave = null;
	
	final String BUENA = "La contrase�a es cojonuda";
	final String MALA = "La contrase�a es muy pobre/d�bil";
	
	public Password (String palabraClave) {
		this.palabraClave = palabraClave;
	}
	/**
	 * Este m�todo comprueba que la contrase�a tenga una letra may�scula en la primera posici�n, 
	 * una coma en la antepen�ltima posici�n, y dos digitos en las dos �ltimas posiciones.
	 * Si se cumplen estas espectativas la contrase�a es buena.
	 * 
	 * @return
	 */
	public String esPasswordBuena(){
		//hacer un m�tido para decir si una constrase�a es buena...
		int longitud = this.palabraClave.length();
		String resultado = MALA;
		
		if (longitud>6){// si tiene m�s de 6 caracteres
			if (Character.isUpperCase(this.palabraClave.charAt(0))){ //si la primera letra es may�sculas
				if (this.palabraClave.charAt(longitud-3)==','){ // si tiene una coma en la antepen�ltima posici�n
					if (Character.isDigit(this.palabraClave.charAt(longitud-2))){ // si tiene un n�mero en la pen�ltima posici�n
						if (Character.isDigit(this.palabraClave.charAt(longitud-1))) { // si tiene un n�mero en la �ltima posici�n
						resultado = BUENA ;	
						}
					}	
				}	
			}
			
			
				/*for (int i = 1; i < longitud; i++){
					char caracter = this.palabraClave.charAt(i);
					
				}*/
		}
		return resultado;
		
		//version con Google
		/*boolean respuesta = false;
		Pattern pat = Pattern.compile("[a-zA-Z]{5,10}");
	    Matcher mat = pat.matcher(palabraclave);
	     if (mat.matches()) {
	         respuesta = true;
	     } 
		return respuesta;*/
	}	
	public String pedirDatos () {
		System.out.println("Contrase�a: ");
		this.palabraClave = sc.next(); //capturo del teclado el n�mero de personas
		return this.palabraClave;
	}	
	
}

package iap.clases.repaso1
;

import java.util.Scanner;
/**
 * HACER UN M�TODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER PERTENECE A LA CADENA O NO
 * @author inakiap
 *
 */
public class Ejercicio1 {
	
	private String palabra = null;
	private char caracter;

	public String getPalabra() {
		return palabra;
	}


	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}


	public char getCaracter() {
		return caracter;
	}


	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}


	boolean perteneceALaCadena (){
		boolean respuesta = false;
		int i = 0;
		int longitud = 0;
		
		//pedir la palabra y el caracter
		Scanner sc = new Scanner(System.in); //creo un objeto de la clase Scanner para escanear el teclado
		
		
		System.out.println("Introduce una palabra:");
		palabra = sc.next();
		longitud = palabra.length();
		
		System.out.println("Introduce una letra:");
		caracter = sc.next().charAt(0);
		
		
		//evaluar si en la palabra introducida se encuentra el caracter
		
		do {
			if (caracter == palabra.charAt(i)) {
				respuesta = true;
			}
			else {
				i++;
			}
			
			
		} while (!respuesta &&(i < longitud));
		
		/*for (int i = 0; i < palabra.length(); i++) {
			if (caracter == palabra.charAt(i)) {
				respuesta = true;
			}
		}*/
		
		sc.close();
		return respuesta;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicio1 ej1 = null;
		
		ej1 = new Ejercicio1();
		
		if (ej1.perteneceALaCadena()==true) {
			System.out.println("La palabra: "+ej1.getPalabra()+" contiene la letra: "+ej1.getCaracter());
		} else {
			System.out.println("La palabra: "+ej1.getPalabra()+" NO contiene la letra: "+ej1.getCaracter());
		}
		
		
		
		
		

	}

}

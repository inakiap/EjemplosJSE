package iap.clases.repaso1;

import java.util.Scanner;

//HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA

public class Ejercicio2 {
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


	int contarLetraEnPalabra (){
		int contador = 0;
		
		//pedir la palabra y el caracter
		Scanner sc = new Scanner(System.in); //creo un objeto de la clase Scanner para escanear el teclado
		
		
		System.out.println("Introduce una palabra:");
		palabra = sc.next();
		
		System.out.println("Introduce una letra:");
		caracter = sc.next().charAt(0);
		
		//evaluar si en la palabra introducida se encuentra el caracter y si es así sumar 1 al contador
		
		for (int i = 0; i < palabra.length(); i++) {
			if (caracter == palabra.charAt(i)) {
				contador++;
			}
		}
		
		sc.close();
		return contador;
	}
	
	
	public static void main(String[] args) {
		Ejercicio2 ej2 = null;
		int resultado = 0;
		
		ej2 = new Ejercicio2();
		
		resultado = ej2.contarLetraEnPalabra();
		
		if (resultado>0) {
			System.out.println ("La palabra " + ej2.getPalabra() + " contiene la letra " + ej2.getCaracter() +" "+ resultado +" veces.");
		} else {
			System.out.println("La palabra "+ej2.getPalabra()+" NO contiene la letra "+ej2.getCaracter());
		}
		
		
		
		
		

	}

}

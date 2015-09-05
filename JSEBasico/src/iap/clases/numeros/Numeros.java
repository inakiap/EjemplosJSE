package iap.clases.numeros;

import java.util.Scanner;

public class Numeros {
	
	static Scanner sc = new Scanner(System.in); //creo un objeto de la clase Scanner para escanear el teclado
	
	public static int pedirNumeros () {
		int numero = 0;
	
		System.out.println("Introduce el un n�mero");
	
		numero = sc.nextInt(); //capturo del teclado el primer n�mero
	
		return numero;
	}
	/**
	 * 
	 * @param numero
	 * @param mayor
	 * @return
	 */
	public static int deVuelveMayor(int numero, int mayor){
		
		if (numero>mayor){
			mayor = numero;
		}
		return mayor;
		
	}


}


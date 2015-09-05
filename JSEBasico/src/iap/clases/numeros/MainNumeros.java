package iap.clases.numeros;

import java.util.Scanner;

public class MainNumeros {

static Scanner sc = new Scanner(System.in); //creo un objeto de la clase Scanner para escanear el teclado
	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		int numeroA = 0;
		int numeroB = 0;
		int numeroC = 0;
		/* Esta parte la puedo sustituir por el m�todo anterior
		System.out.println("Introduce el primer n�mero");
		numeroA = sc.nextInt(); //capturo del teclado el primer n�mero
	
		System.out.println("Introduce el segundo n�mero");
		numeroB = sc.nextInt();
		
		System.out.println("Introduce el tercer n�mero");
		numeroC = sc.nextInt();
		*/
		
		// 
		
		numeroA = Numeros.pedirNumeros();
		numeroB = Numeros.pedirNumeros();
		numeroC = Numeros.pedirNumeros();
		
		if (numeroA > numeroB) {
			if (numeroA > numeroC) {
				
				System.out.println("El "+numeroA+" es el mayor.");
				
			}else {
				System.out.println("El "+numeroC+" es el mayor.");
			}
		}else if (numeroB>numeroC){
			System.out.println("El "+numeroB+" es el mayor.");
			
		}else {
			System.out.println("El "+numeroB+" es el mayor.");
		}
		
		
		
	}

}

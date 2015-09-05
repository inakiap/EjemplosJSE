package iap.clases.repaso1;
//4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO
import java.util.Scanner;

public class Ejercicio4 {
	
	
	static private int MAYOR_EDAD = 18;
	static Scanner sc = new Scanner(System.in);
	
	static public boolean eresMayor (){
		boolean edadM = false;
		int edad = 0;
		System.out.println("Introduce tu edad: ");
		edad = sc.nextInt();

		if (edad >= MAYOR_EDAD) {
			System.out.println("Eres mayor de edad, por si no lo sabías ;)");
			edadM = true;
		} else {
			System.out.println("Todavía no eres mayor de edad. Ya llegará.");
		}
		return edadM;
	}
	
	public static void main(String[] args) {
				
		eresMayor();
		
	}
}
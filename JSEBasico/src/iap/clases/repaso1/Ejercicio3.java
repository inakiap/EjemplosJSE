package iap.clases.repaso1;

import java.util.Scanner;

//3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO
public class Ejercicio3 {
	
	//introducir un número
	private int num = 0;
	
	public boolean esPar (){
		boolean numPar = false;
		
		Scanner sc = null;
		sc = new Scanner(System.in);
		
		System.out.println("Introduce un número:");
		num = sc.nextInt();
		
		if (num%2 == 0) {
			numPar = true;
			System.out.println("El número es par");
			
		}else {
			System.out.println("El número es impar");
		}
		sc.close();
		return numPar;
	}
	
	public static void main(String[] args) {
		Ejercicio3 ej3 = new Ejercicio3();
		
		ej3.esPar();
	}

}
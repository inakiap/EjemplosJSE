package iap.clases.repaso1;

import java.util.Scanner;

//HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE
public class Ejercicio5 {
	
	private enum NotaEscrita {SOBRESALIENTE, NOTABLE, BIEN, APROBADO, SUSPENSO};
	
	public static void deNumaNota (){
		NotaEscrita calificacion = null;
		int nota;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); //creo un objeto de la clase Scanner para escanear el teclado
		System.out.println("Introduce una nota del 0 al 10: ");
		nota = Integer.parseInt(sc.next());
		if ((nota > 0) && (nota < 10)){
			switch (nota) {
			case 10:
			case 9:
				calificacion = NotaEscrita.SOBRESALIENTE;
				break;
			case 8:
			case 7:	
				calificacion = NotaEscrita.NOTABLE;
				break;
			case 6:
			case 5:	
				calificacion = NotaEscrita.APROBADO;
				break;	

			default:
				calificacion = NotaEscrita.SUSPENSO;
				break;
			}
		} else{
			System.out.println("La nota debe estar entre 0 y 10");
		}
		
		if (null != calificacion) {
			System.out.println("La calificación es de " + calificacion);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ejercicio5.deNumaNota();
		
	}

}

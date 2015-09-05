package iap.clases.persona;

import java.util.Scanner;

public class PedirDatosDePersona {

	static Scanner sc = new Scanner(System.in); //creo un objeto de la clase Scanner para escanear el teclado
	
	public static int pedirDatos () {
		int numeroPersonas = 0;
		System.out.println("¿Cuantas personas?");
		numeroPersonas = sc.nextInt(); //capturo del teclado el número de personas
		return numeroPersonas;
	}
	/**
	 * M�todo para pedir el nombre de nuestra persona
	 * @return
	 */
	public static String pedirNombre () {
		String nombre = null;
		System.out.println("Introduzca nombre "); //muestro una cadena de texto
		//Scanner sc = new Scanner(System.in);
		nombre = sc.next(); //capturo/scaneo la cadena que introducen en la consola
		return nombre; //con el return devuelve la funci�n el valor recogido en nombre
	}
	/**
	 * M�todo para pedir la edad de la persona
	 * @return
	 */
	public static int pedirEdad (){
		int edad = 0; //creo una variable para guardar la edad
		System.out.println("Introduzca edad ");  //la pido
		//Scanner sc = new Scanner(System.in);
		edad = sc.nextByte(); //capturo el n�mero de la edad y lo meto en byte
		return edad; //con el return devuelve la funci�n el valor recogido en edad
	}
}

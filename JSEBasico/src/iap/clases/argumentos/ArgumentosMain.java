package iap.clases.argumentos;

public class ArgumentosMain {
	//hacer un programa que diga en que posici�n est� la palabra m�s larga y cuantos caracteres tiene
	
	/**
	 * un programa que dice cual de las palabras que metemos como argumentos por el main es la m�s larga,
	 * n�mero de caracteres y su posici�n en el array
	 * @param args
	 */
	public static void main(String[] args) {
		String straux = null; //declaro una variable auxiliar
		int longStraux = 0; //declaro una variable para almacenar la longitud de las palabras
		int longStrauxMax = 0;//declaro otra variable d�nde guardar la longitud de la palabra m�s larga
		int posicionStrauxMax = 0;//declaro otra variable para guardar la posici�n de la palabra m�s larga
		String palabraStrauxMax = null; //en esta variable guardar� la palabra m�s larga
		
		
		for (int i = 0; i < args.length; i++) { //recorro el array de argumentos del main
			straux = args[i]; //guardo la palabra de la posici�n i del array
			longStraux = straux.length(); //guardo su longitud
			if (longStraux > longStrauxMax) { //evaluo si la longitud de la palabra es mayor que la guardada como la m�s grande
				longStrauxMax = longStraux; //guardo la longitud de la palabra como la m�s grande
				posicionStrauxMax = i; //guardo la posici�n de la palabra
				palabraStrauxMax = args[i]; //guardo la palabra m�s larga 
			}
			
		}
		//Imprimo los resultados
		System.out.println("La palabra máss larga es " + palabraStrauxMax);
		System.out.println("La posición de la palabra más larga es " + posicionStrauxMax);
		System.out.println("La longitud de la palabra más larga es " + longStrauxMax);
		
		
		
	}

}

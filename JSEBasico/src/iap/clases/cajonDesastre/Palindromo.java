package iap.clases.cajonDesastre;

/**
 * 
 * 
 * @author Val
 *
 *El c�digo de esta clase, es un poco misterioso. Alg�n programador Clase "C", no ha usado
 *nombres descriptivos y ahora, nos toca pegarnos y descubrir qu� narices hace este c�digo, 
 *para poder usarlo en nuestro proyecto.
 *
 *
 *Se pide:
 *
 *1) Adivinar la funcionalidad del m�todo adivinaQueHace
 *2) Una vez descubierto, aplicar un nombre apropiado al m�todo y a la clase
 *3) Idear un m�todo equivalente, pero distinto. Es decir, crear un m�todo 
 *que haga lo mismo que adivinaQueHace, pero de otra manera.
 *4) EXTRA: S�lo si resolviste los puntos anteriores, implementa una versi�n recursiva
 *
 */
public class Palindromo
{
	
	private static boolean esPalindromo (String cad)
	{
		boolean bd = true;
		
		int i = 0;
		int j = cad.length()-1;
		
		while ((i<=j)&&(bd))
		{
			bd = cad.charAt(i)==cad.charAt(j);
			i++;
			j--;
		}
		
		
		return bd;
	}
	
	private static boolean esPalindromo2 (String palabro){
		boolean respuesta = true;
		char [] letraALetra = new char [palabro.length()];
			
		for (int i = 0; i < letraALetra.length; i++) {
				letraALetra[i] = palabro.charAt(i);
			}
			int k = 0;
			int j = letraALetra.length-1;
			while ((k <= j)&&(respuesta)){
				respuesta = letraALetra[k] == letraALetra [j];
				k++;
				j--;
			}
		
		return respuesta;
		
	}
	
	private static boolean esPalindromoRecursivo (String cad, int posicion, int antiposicion){
		boolean bd = true;
		
		int i = 0;
		int j = cad.length()-1;
		
		if ((i<=j)&&(bd))
		{
			bd = cad.charAt(i)==cad.charAt(j);
			posicion = i++;
			antiposicion = j--;
		}else{
			bd = false;
		}
		
		
		return bd;
	}
	
	public static void main(String[] args) {
	/*	if (esPalindromo("mandahuevos"))
		{
			System.out.println("VERDADERO");
		} else 
		{
			System.out.println("FALSO");
		}*/
		if (esPalindromoRecursivo("anarquia", 0, 0))
		{
			System.out.println("VERDADERO");
		} else 
		{
			System.out.println("FALSO");
		}
	}

}

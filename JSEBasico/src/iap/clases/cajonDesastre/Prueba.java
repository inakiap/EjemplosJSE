package iap.clases.cajonDesastre;

public class Prueba {
	//creo el objeto
	
	public int calcula(){ //declaro una funci�n
		return 1+1;//una operaci�n
	}
	public static void main (String []argumentos){
		
		Prueba prueba = null; //declaraci�n e inicializaci�n de un objeto de la clase Prueba
		
		int resultado = 0; //declaro la variable auxiliar resultado
		//todas las variables se deben incializar al principio...
		
		prueba = new Prueba (); //creo el objeto de la clase Prueba con el constructor
		
		resultado = prueba.calcula(); //igualo la variable resultado al valor de la funci�n 
		
		System.out.println(resultado);
	}

}

package iap.clases.repasoDeLoBasico;

public class InsertarPersonaException extends Exception{
	
	public static final String mensaje = "Numero de personas excecido. Maximo " + ListaPersonas.CAPACIDAD + " personas";
		
	public InsertarPersonaException(){
			//super (mensaje);
			System.out.println(mensaje);
		}
		
	}



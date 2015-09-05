package iap.clases.persona;

public class MainPersona {

	public static void main (String args[]){
		//pedir datos
		//primero declaro variables y un objeto persona
		Persona objetoPersona = null;
		objetoPersona = new Persona("Juan", 22);
		/*
		String recojoNombre = null;
		byte recojoEdad = 0;
		int numeroPersonas = 0;
		
		// creo el objeto Persona con los atributos que recojo en pedirNombre y pedirEdad
		objetoPersona = new Persona(recojoNombre, recojoEdad);
		numeroPersonas = PedirDatosDePersona.pedirDatos();
		
		
		for (int contador = 0; contador < numeroPersonas; contador  ++){ //bucle for que repite la acci�n 5 veces
			
			System.out.println("Persona "+ (contador+1)); // Aviso de que persona se trata de las 5
			objetoPersona.nombre = PedirDatosDePersona.pedirNombre ();
			objetoPersona.edad = PedirDatosDePersona.pedirEdad ();
			objetoPersona = new Persona (objetoPersona.nombre, objetoPersona.edad);
			
			objetoPersona.mostrarPersona();
			
			if (objetoPersona.esMayorDeEdad()){
				System.out.println("Esta personica es viejuno de edad!!!");
			}
			else {
				System.out.println("La personica es un pimpinako!!");
			}
			
			if ((contador+1)==numeroPersonas){
				System.out.println("The End");
			}
		}*/
		
		System.out.println(objetoPersona);
		
		System.out.println(objetoPersona.getClass());
		
	}
}
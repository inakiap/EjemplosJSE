package iap.clases.persona;

import java.io.Serializable;


public class Persona implements Serializable {
	
	private String nombre; //creo los atributos
	private int edad;
	static final int MAYOR_EDAD = 18; 
		
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * A continuación esta el constructor de la clase persona con dos parámetros
	 * @param nombre es el nombre del nuevo objeto persona
	 * @param edad2 indica la edad de la persona
	 */
	public Persona(String nombre, int edad) {
		this.nombre = nombre; //this se refiere al atributo del objeto creado
		this.edad = edad;
		
	}
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public boolean esMayorDeEdad (){ //m�todo para saber si la persona es mayor o menor de edad
		boolean esMayor = false;
		if (this.edad >= MAYOR_EDAD){
			esMayor = true;
		}
		else {
			esMayor = false; // como esMayor se ha inicializado a false no hace falta este else pero por legilibilidad s�
			
		}
		return esMayor;
		
	}
	
	public void mostrarPersona (){
		System.out.println("Voy a mostrar con un bonito método el nombre de la persona: " + this.nombre);
		System.out.println("Voy a mostrar con un bonito método la edad de la persona: " + this.edad);
	}
	/**
	 * @param ob
	 */
	public boolean equals(Object ob) {
		
		boolean sonIguales = false;
		Persona personaAux = null; 
		
		if (ob instanceof Persona) {
			personaAux = (Persona)ob;// esto es un casting
			if (this.nombre.equals(personaAux.nombre)){
				
				if (this.edad == personaAux.edad){
					sonIguales = true;
				}
			}
		}
		return sonIguales;
	}	
	public String toString() {
		String contenido = null;
		contenido="Esta personica se llama "+this.nombre + " @ " + "Y tiene " + this.edad;
		
		return contenido;
	}

	//1 método para coger un objeto persona y sumarle a su edad un n�mero y devuelvo una persona nueva con esos nuevos datos
	public static Persona personaConMasEdadCaso1 (Persona person, int num){
		Persona personNueva = null;
		personNueva = new Persona(person.getNombre(), person.getEdad());
		personNueva.edad = person.getEdad() + num;
		return personNueva;
		
	}
	//2 método entra un objeto persona y sumarle a su edad un n�mero, devuelvo el mismo objeto
	public void personaConMasEdadCaso2 (int num){
		this.edad = this.edad + num;
		
	}
	//3 método estático
	public static void personaConMasEdadCaso3 (Persona person, int num){
		person.setEdad(person.getEdad()+ num);
		
	}
}
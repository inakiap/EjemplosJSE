package iap.clases.repasoDeLoBasico;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Persona implements Serializable, Comparable<Persona> {
	
	private int edad;
	private String nombre;
	
	
	public Persona(String nombre, int edad) {
		this.edad = edad;
		this.nombre = nombre;
	}


	public Persona() {
		// TODO Auto-generated constructor stub
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre + " " + this.edad;
	}

	@Override
	public int compareTo(Persona p) {
		int resp = 0;
		if (this.edad > p.getEdad()){
			resp= 1;
		}else if (this.edad < p.getEdad()){
			resp = -1;
		}
		
		return resp;
	}


	
	
}

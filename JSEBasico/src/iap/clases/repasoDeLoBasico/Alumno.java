package iap.clases.repasoDeLoBasico;


public class Alumno extends Persona{
	
	private int nota;
	private TipoNota nombre_nota; 
	
	
	public Alumno (String nombre, int edad, int nota) throws NotaException
	{
		super (nombre, edad);
		this.nota = nota;
		this.nombre_nota = TipoNota.traduceNota(nota);
		
	}


	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}


	public TipoNota getNombre_nota() {
		return nombre_nota;
	}


	public void setNombre_nota(TipoNota nombre_nota) {
		this.nombre_nota = nombre_nota;
	}
	
	public String toString() {
		String contenido = null;
		contenido = "Esta personica se llama " + this.getNombre() + ", tiene "
				+ this.getEdad() + " años y tiene esta nota: "
				+ this.nota + " y la calificación es "+ this.nombre_nota +"\n";

		return contenido;

	}
	
	

}

package iap.clases.persona;


public class Alumno extends Persona {

	private int nota = 0;
	
	public enum NotaEscrita {SOBRESALIENTE, NOTABLE, BIEN, APROBADO, SUSPENSO};
	
	private NotaEscrita calificacion = NotaEscrita.SOBRESALIENTE;

	
	/**
	 * método para tomar el valor
	 * 
	 * @return nota
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * metodo para cambiar el atributo
	 * 
	 * @param nota
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}

	private NotaEscrita calificaciones() {

		NotaEscrita notas = null;

		switch (this.nota) {

		case 10:
		case 9:
			notas = NotaEscrita.SOBRESALIENTE;
			break;

		case 8:
		case 7:
			notas = NotaEscrita.NOTABLE;
			break;

		case 6:
			notas = NotaEscrita.BIEN;
			break;

		case 5:
			notas = NotaEscrita.APROBADO;
			break;

		default:
			notas = NotaEscrita.SUSPENSO;
			break;
		}

		return notas;
	}

	/**
	 * constructor de objetos tipo Alumno
	 * 
	 * @param nota
	 */
	public Alumno(int nota) {
		// super();
		this.nota = nota;
	}

	/**
	 * constructor que recoge las caracter�sticas de Persona
	 * 
	 * @param nombre
	 * @param edad
	 */
	public Alumno(String nombre, int edad) {
		super(nombre, edad);
	}

	/**
	 * constructor con todas las variables.
	 * 
	 * @param nombre
	 * @param edad
	 * @param nota
	 */
	public Alumno(String nombre, int edad, int nota) {
		super(nombre, edad);
		this.nota = nota;
		this.calificacion = this.calificaciones();
	}

	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * sobreescribo el m�todo toString
	 */
	public String toString() {
		String contenido = null;
		contenido = "Esta personica se llama " + this.getNombre() + ", tiene "
				+ this.getEdad() + " y tiene esta nota: "
				+ this.nota + " y la calificaci�n es "+ this.calificacion ;

		return contenido;

	}

}

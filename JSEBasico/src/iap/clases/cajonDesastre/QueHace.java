package iap.clases.cajonDesastre;

import java.util.Scanner; //de esta forma llamo a otras clases, en este caso java.util.Scanner

public class QueHace {

	int a;// por estar declarada aqu�, fuera de cualquier m�todo; a es un
			// atributo de la clase. Por lo tanto, es accesible y visible desde
			// todos los m�todos de la clase

	static int b = 50; // declaro una variable y le pongo el modificador static

	public QueHace() {
		// TODO Auto-generated constructor stub
		a = 0; //se pueden inicializar variables dentro del construcctor para crear objetos que ya tengan valores en sus variables
	}
	public QueHace (int valor){//sobrecarga = tener m�s de un m�todo con el mismo nombre
		a = valor;
	}
	
	void metodo() {
		System.out.println(a);
		a++; // equivalente --> a = a + 1;
	}

	public static void main(String args[]) {
		QueHace qh1 = null;
		QueHace qh2 = null;
		String nombre = null;
		byte edad = 0;

		qh1 = new QueHace();
		qh2 = new QueHace();
		qh1.b++;
		System.out.println(qh1.b);
		System.out.println(qh2.b);

		qh1.metodo();
		qh1.metodo();
		qh1.a = 33;
		qh1.metodo();
		System.out.println(qh1.a);
		qh2.metodo();
		System.out.println(QueHace.b);

		/*Scanner sc = new Scanner(System.in); //creo un objeto de la clase Scanner
		System.out.println("Introduzca nombre"); //muestro una cadena de texto
		nombre = sc.next(); //capturo/scaneo la cadena que introducen en la consola
		
		System.out.println("Introduzca edad");
		edad = sc.nextByte();
		System.out.println("Tu nombre es " + nombre);//muestro lo capturado
		System.out.println("Tu edad es " + edad);//muestro lo capturado*/
		
		QueHace qh7 = null; //inicializo qh7
		qh7 = new QueHace(); //creo un objeto de tipo QueHace
		System.out.println(qh7.a); //imprimo el valor de a
		
		qh7 = new QueHace(7); //creo otro objeto tipo QueHace con valor asignado al atributo a
		System.out.println(qh7.a); //imprimo el valor de a
	}

}

package test.clases.junit;

import iap.clases.repasoDeLoBasico.InsertarPersonaException;
import iap.clases.repasoDeLoBasico.ListaPersonas;
import iap.clases.repasoDeLoBasico.Persona;

import org.junit.Before;

public class TestListaPersonas {
	
	ListaPersonas lp = null;
	
	@Before
	public void iniciarListaPersonas () throws InsertarPersonaException{
		lp = new ListaPersonas();
		Persona per1 = new Persona("Tamara", 32);
		Persona per2 = new Persona("Mikel" , 30);
		Persona per3 = new Persona("Alberto" , 31);
		lp.insertarPersona(per1);
		lp.insertarPersona(per2);
		lp.insertarPersona(per3);
	}
}


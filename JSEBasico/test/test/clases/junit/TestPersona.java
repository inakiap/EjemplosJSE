package test.clases.junit;

import iap.clases.persona.Persona;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;


public class TestPersona {
	
	Persona person = null;
	
	@Before
	public void inciarPersona (){
		this.person = new Persona("Jauma I", 58);
	}
	
	@Test
	public void probarGetNombre (){
		 assertThat(person.getNombre(), equalTo("Jauma I"));
	}
	
	@Test
	public void probarSetEdad (){
		person.setEdad(17);
		assertThat(person.getEdad(), is(17));
	}
	
	@Test
	public void probarEsMayorDeEdad (){
		assertTrue(person.esMayorDeEdad());
	}
	
}

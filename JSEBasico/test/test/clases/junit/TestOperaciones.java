package test.clases.junit;

import static org.junit.Assert.*;
import iap.clases.junit.Operaciones;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOperaciones {

	public static Operaciones tester;
	
	@BeforeClass
	public static void iniciaClase(){
		tester = new Operaciones();
	}
	
	@Test
	public void testSuma() {
		assertEquals("5 + 3 = 8", 8, tester.suma(5,3));
		assertEquals("10 + 3 = 13", 13, tester.suma(10,3));
		assertEquals("5 + 1 = 6", 6, tester.suma(5,1));
	}

	@Test
	public void testMultiplicacion() {
		assertEquals("5 x 3 = 15", 15 , tester.multiplicacion(5, 3));
	}

	@Test
	public void testDivision() {
		assertEquals("6 / 3 = 1", 2, tester.division(6, 3));	
	}

	@Test
	public void testResta() {
		assertEquals("5 - 3 = 2", 2, tester.resta(5, 3));
	}
	
	@AfterClass
	public static void finalizoClase(){
		tester = null;
	}
}

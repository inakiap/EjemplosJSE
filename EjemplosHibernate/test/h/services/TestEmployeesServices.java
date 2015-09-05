package h.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import hibernate.dominio.Employees;
import hibernate.services.EmployeesServices;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Iñaki Alfaro
 *
 */
public class TestEmployeesServices {
	
	private static EmployeesServices tester;
	
	@BeforeClass
	public static void iniciarClase(){
		tester = new EmployeesServices();
	}
	@AfterClass
	public static void finClase (){
		tester= null;
	}
	
	
	@Test
	/**
	 * Prueba del método modificar salario con un empleado concreto, se saca su salario de inicio,
	 * se aplica el método mofidificarSalario y se vuelve a tomar el mismo empleado y se comparan.
	 */
	public void testModificarSalario() {
				
		Employees e1 = tester.leerEmpleado(100);
		
		int salarioInicial = e1.getSalary().multiply(new BigDecimal(1.2)).intValue();
		
		tester.modificarSalario(1.2);
		
		e1 = tester.leerEmpleado(100);
		int salarioFinal = e1.getSalary().intValue();
		
		assertTrue(salarioInicial == salarioFinal);
		
	}

	@Test
	/**
	 * Prueba el método que obtiene todos los empleados de un departamento.
	 * saco la lista de empleados y compruebo que está un empleado que previamente he visto que debería estar.
	 */
	public void testObtenerEmpleadosPorDepartamento() {
		
		List<Employees> lE = tester.obtenerEmpleadosPorDepartamento("executive"); 
		
		Employees e1 = tester.leerEmpleado(100);
		
		assertTrue(lE.contains(e1));
		
			
		
	}
	
	
	
	
	
}

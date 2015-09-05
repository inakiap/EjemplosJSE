package h.services;

import static org.junit.Assert.*;
import hibernate.dominio.Employees;
import hibernate.services.DepartmentServices;
import hibernate.services.EmployeesServices;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Iñaki Alfaro
 *
 */
public class TestDepartmentServices {

	private static DepartmentServices tester;
 
	@BeforeClass
	public static void inicioClase(){
		tester = new DepartmentServices();
	}

	@AfterClass
	public static void finClase(){
		tester = null;
	}
	
	/**
	 * Test method for {@link hibernate.services.DepartmentServices#mejorPagadosDepartamentos()}.
	 */
	@Test
	public void testMejorPagadosDepartamentos() {
		EmployeesServices eS = new EmployeesServices();
		 try {
			 List <Employees> le = tester.mejorPagadosDepartamentos();
				Employees e1 = le.get(0);
				
				List <Employees> le2 = eS.obtenerEmpleadosPorDepartamento("administration");
				Employees e2 = tester.sueldoMax(le2);
				
				assertTrue(e1.equals(e2));
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
}

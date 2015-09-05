import java.util.List;
import java.util.Set;

import hibernate.dao.DepartmentDAO;
import hibernate.dao.SessionManager;
import hibernate.dominio.Departments;
import hibernate.dominio.Employees;
import hibernate.services.DepartmentServices;
import hibernate.services.EmployeesServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class MainPruebas {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EmployeesServices eS = new EmployeesServices();
		
		System.out.println(eS.mostrarTodos());
		eS.modificarSalario(1.2);
		System.out.println(eS.mostrarTodos());
		
		Employees e1 = eS.leerEmpleado(100);
		System.out.println(e1);
		eS.modificarSalario(0.5);
		
		Employees e2 = eS.leerEmpleado(100);
		System.out.println(e2);
		
		//DepartmentServices dS = new DepartmentServices();
		//System.out.println(dS.mejorPagadosDepartamentos());
		
		//Session s = SessionManager.obtenerSesionNueva();
		//DepartmentDAO dDAO = new DepartmentDAO();
		//dDAO.setSesion(s);
		
		//Departments d = (Departments) dDAO.leer("shipping");
		//System.out.println(d.getDepartmentName());
		
		
		//List<Employees> listado = eS.obtenerEmpleadosPorDepartamento("shipping");
		//System.out.println(listado);
		
		
		//SessionManager.cerrarSession(s);
		SessionManager.cerrarFactory();
	}	
		
}



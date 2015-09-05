package hibernate.services;

import hibernate.dao.DepartmentDAO;
import hibernate.dao.EmployeesDAO;
import hibernate.dao.SessionManager;
import hibernate.dominio.Departments;
import hibernate.dominio.Employees;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Iñaki Alfaro
 *
 */
public class EmployeesServices {
	
	private final static Logger log = Logger.getLogger("miregistro");
	private EmployeesDAO eDAO = null;
	
	public EmployeesServices (){
		 eDAO = new EmployeesDAO();
	}
	
	/**
	 * Método que modifica los salarios de todos lo trabajadores
	 * @param d hay que pasarle el factor de variación del sueldo
	 * @return devuelve verdadero en caso de haber cambiado los sueldos
	 */
	public boolean modificarSalario (double d){
		//declaro todas las variables que voy a necesitar
		boolean exito = false;
		Session s = null;
		List <Employees> le = null;
		BigDecimal variacion = new BigDecimal(d);
		Transaction t = null;
		Employees empleado = null;
		log.trace("Incializando las variables del método modificarSalario");
		
		try {
			s = SessionManager.obtenerSesionNueva(); //obtengo una sesión
			t = s.beginTransaction();//coloco un punto de salvaguarda
			eDAO.setSesion(s);//paso la sesión al objeto EmpleadoDAO que nos nos proporciona un método para tener todos los empleados
			
			log.info("Inicio sesión y comienzo la transacción");
			
			le = eDAO.leerTodos();
			
			Iterator<Employees> it = le.iterator();
			log.info("Recorro la lista con todos lo empleados");
						
			while (it.hasNext())
			{
				empleado = it.next();
					
				empleado.setSalary(empleado.getSalary().multiply(variacion)); //cambio el salario de cada uno de los empleados
				
			}
			t.commit(); //si no hubo error hago permanentes los cambios en la bbdd
			exito = true; // cambio el valor de mi variable booleana a verdadero
			log.info("Todo salió bien");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.error("Error en la operación de modificar salario");
			exito = false; //en caso de atrapar una excepción la variable booleana pasa a ser falso, aunque en realidad al haber incializado a falso no haría falta.
		}
		finally{
			SessionManager.cerrarSession(s); //cierro la sesión.
			log.info("Cerrar la conexión");
		}
		
		
		return exito;
	}
	
	/**
	 * Método que obtiene los empleados de un departamento
	 * @param nombreDept introducir el nombre del departamento, es importante que sea con todas las letras en mínusculas
	 * @return devuelve una lista de objetos empleado
	 */
	@SuppressWarnings("unchecked")
	public List<Employees> obtenerEmpleadosPorDepartamento (String nombreDept){
		
		//declaro todas las variables que necesitaré
		List<Employees> lE = null;
		Departments dep = new Departments();
		DepartmentDAO dD = new DepartmentDAO();
		Session s = null;
		Transaction t = null;
		log.trace ("Inicialización de variables y objetos");
		
		try {
			s = SessionManager.obtenerSesionNueva(); //obtengo la sesión
			t = s.beginTransaction(); //coloco un punto de salvaguarda
			dD.setSesion(s); //paso la sesión a mi objeto DepartmentDao que me permite a continuación utilizar el método leer que me devuevle un objeto departamento
			dep = (Departments) dD.leer(nombreDept); //con este método leer obtengo el objeto Departamento que coincide con el nombre que introduje
			log.trace("El departamento se ha encontrado");
			lE = new ArrayList<Employees>();
			Set<Employees> conjuntoEmp = dep.getEmployeeses();
			Iterator<Employees> it = conjuntoEmp.iterator();
			while (it.hasNext()) {
				lE.add(it.next());
				
			}
			log.trace("La lista de empleados está cargada");
			
			t.commit(); // si todo fue bien hago los cambios persistentes.
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en la transacción");
		} finally {
			SessionManager.cerrarSession(s); //cierro la sesión
			log.info("Cierre de la conexión");
		}

		
		return lE;
	}
	
	/**
	 * Método que obtiene un empleado de la bbdd a partir de su identificador
	 * @param id el identificador es un intenger
	 * @return devuelve un objeto empleado
	 */
	public Employees leerEmpleado (int id){
		Employees emp = null;
		Session s = null;
		Transaction t = null;
		log.trace("Inicialización de variables y objetos");
		try {
			s = SessionManager.obtenerSesionNueva(); //obtengo la sesión
			t = s.beginTransaction(); //coloco un punto de salvaguarda
			eDAO.setSesion(s);
			
			emp = (Employees) eDAO.leer(id);
									
			t.commit(); //si no hubo error hago permanentes los cambios en la bbdd
			log.info("Todo salió bien");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.error("Error en la transacción");
		}
		finally{
			SessionManager.cerrarSession(s); //cierro la sesión.
			log.info("Cerrar la conexión");
		}
		
		return emp;
	}
	
	/**
	 * Método que devuelve una relación de todos los empleados
	 * @return un objeto lista con objetos de empleados
	 */
	public List<Employees> mostrarTodos (){
		List <Employees> le = null;
		Session s = null;
		Transaction t = null;
		log.info("Inicializando el método");
		try 
		{
			s = SessionManager.obtenerSesionNueva();
			t = s.beginTransaction();
			eDAO.setSesion(s);
			le = eDAO.leerTodos();
			
			log.trace("Está cargada la lista de empleados");
			
			t.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			t.rollback();//si algo ha ido mal, deshago la transacci�n
			log.error("La transacción ha fallado");
		}
		finally 
		{
			SessionManager.cerrarSession(s);
			log.info("Cierre de la conexión");
		}
		return le;
	}
	
}

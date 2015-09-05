package hibernate.services;

import hibernate.dao.DepartmentDAO;
import hibernate.dao.SessionManager;
import hibernate.dominio.Departments;
import hibernate.dominio.Employees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;


/**
 * @author Iñaki Alfaro
 *
 */
public class DepartmentServices {
	
	private final static Logger log = Logger.getLogger("miregistro");
	
	private DepartmentDAO dDAO = null; //declaro un objeto de la clase DAO correspondiente
	
	public DepartmentServices (){
		dDAO = new DepartmentDAO(); //lo inicializo en el constructor
	}
	
		@SuppressWarnings("unchecked")
		/**
		 * Método que nos muestra una lista del empleado mejor pagado de cada departamento
		 * @return lista de objetos empleado
		 */
		public List<Employees> mejorPagadosDepartamentos(){
			//creo todas las variables que me harán falta
			List <Departments> ld = null;
			Departments dep = null;
			Iterator<Departments> idp = null;
			
			List <Employees> sEmp = null;
			List <Employees> sEmp2 = null;
			
			Session s = null;
			Transaction t = null;
			log.info("Establezco todos las variables");
			try {
				s = SessionManager.obtenerSesionNueva(); //obtengo una sesión
				t = s.beginTransaction(); //coloco un punto de salvaguarda
				dDAO.setSesion(s); //paso la sesión al objeto DepartmentDAO
				ld = dDAO.leerTodos(); //utilizo el objeto DAO para obtener una lista de los departamentos
				idp = ld.iterator(); // me preparo para recorrerla
				
				sEmp2 = new ArrayList<Employees>();
				
				while(idp.hasNext()){ //la recorro
					dep = idp.next();
					sEmp = new ArrayList<Employees>(dep.getEmployeeses()); //de cada departamento obtengo una lista con todos sus empleados
					if (sEmp != null){ 
					sEmp2.add(sueldoMax(sEmp)); //añado el objeto empleado con el sueldo máximo que he obtenido gracias a otro método en otra lista que devolveré
					}
				}
				
				t.commit(); // si todo fue bien confirmo los cambios, en este caso, al ser solo una consutla no habría cambios.
				
			} catch (Exception e2) {
				log.error("Error en la operación con la bbdd");
			} finally {
				SessionManager.cerrarSession(s); //Cierro la sesión
				log.info("Cerrar la sesión");
			}
			
			return sEmp2;
		}
		
		/**
		 * Método que calcula el empleado con un sueldo mayor en una lista de empleados
		 * @param sE se le introduce una lista de empleados
		 * @return devuelve un objeto empleado
		 */
		public Employees sueldoMax (List<Employees> sE){
			Employees max = null;
			
			if (sE.size() > 0 ){
				max = sE.get(0);
			}
			return max;
		}
		
}

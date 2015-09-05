package hibernate.dao;

import hibernate.dominio.Employees;

import java.util.List;
import java.util.Set;


public class EmployeesDAO extends SessionDAO implements GenericoDAO{
	
	public EmployeesDAO (){}
	
	@Override
	public void crear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Método que extrae un empleado de la bbdd por su identificador
	 * @param se introduce el identificador del empleado
	 * @return devuelve un objeto de la clase empleado
	 */
	public Object leer (int key) {
		Object emp = new Object();
		emp = (Employees)getSesion().get(Employees.class, key);
		return emp;
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * Método que devuelve todos los empleados de la bbdd
	 * @return devuelve una lista de empleados
	 */
	public List leerTodos() {
		@SuppressWarnings("unchecked")
		List<Employees> list = getSesion().createSQLQuery(InstrucionesSQL.b1).addEntity(Employees.class).list();
		return list;
	}

	@Override
	public void modificar(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Object obj) {
		//getSesion().delete(Employees.class, obj);
	}
}

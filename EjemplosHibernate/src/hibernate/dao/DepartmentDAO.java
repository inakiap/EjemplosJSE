package hibernate.dao;

import hibernate.dominio.Departments;

import java.util.List;

public class DepartmentDAO extends SessionDAO implements GenericoDAO {

	@Override
	public void crear() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * Método que devuelve una lista con todos los departamentos que existen en la bbdd.
	 */
	public List leerTodos() {
		@SuppressWarnings("unchecked")
		List<Departments> ld = getSesion().createSQLQuery(InstrucionesSQL.d1).addEntity(Departments.class).list();
		return ld;
	}

	@Override
	/**
	 * Método que devuelve un Departamento de la bbdd introduciendo su ID.
	 * @param id Introducir el department_id del departamento.
	 * @return devuelve un objeto departamento.
	 */
	public Object leer(int id) {
		Departments d = (Departments) super.getSesion().get(Departments.class, (short) id);
		return d;
	}
	/**
	 * Método que devuleve un Departamento de la bbdd por su nombre.
	 * @param name es el department_name del departamento.
	 * @return devuelve un objeto departamento.
	 */
	public Object leer(String name){
		Departments d = null;
		try{
			d = (Departments) super.getSesion().createSQLQuery("select * from Departments where lower (department_name) like '" + name +"'").addEntity(Departments.class).uniqueResult();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return d;
	}
	
	@Override
	public void modificar(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Object o) {
		// TODO Auto-generated method stub
		
	}

}

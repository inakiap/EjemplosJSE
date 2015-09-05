package Recuperable.Services;

import Recuperable.Persistencia.Recuperable;

public class EmpService {
	
	private Recuperable obj_DAO;
	
	/**
	 * Método que establece el objeto recuperable que va a trabajar con la bbdd
	 * @param r hay que introducir un objeto de la interface Recuperable
	 */
	public void setRecuperable (Recuperable r){
		this.obj_DAO = r;
		
	}
	
	/**
	 * Método que devuelve un empleado
	 * @param n introducir un int con el valor del identificador del empleado
	 * @return devuelve un objeto empleado
	 */
	public Object LeerEmpleado (int n){
		Object obj = obj_DAO.leerEmpleado(n);
		return obj;
	}
	

}

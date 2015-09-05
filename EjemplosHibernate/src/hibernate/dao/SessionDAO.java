package hibernate.dao;

import org.hibernate.Session;

/**
 * @author Iñaki Alfaro
 *
 */
public class SessionDAO {
	
	private Session sesion = null;
	
	public Session getSesion() {
		return this.sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}

	public SessionDAO (){
		
	}
	
}

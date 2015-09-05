package Recuperable.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Recuperable.DTO.Employee;

public class EmpJPADAO implements Recuperable {
	
	@Override
	public Object leerEmpleado(int n) {
		Employee empleado = null;
		Long empId = new Long(n);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
		    empleado = em.find(Employee.class, empId);
		    
		    em.getTransaction().commit();
		    } catch (Exception e) {
		        
		    e.printStackTrace();
		    }finally {
		    em.close();
		    emf.close();
		        
		    }
		
		return empleado;
	}

}

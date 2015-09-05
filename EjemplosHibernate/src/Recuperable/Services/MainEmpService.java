package Recuperable.Services;

import Recuperable.DTO.EmpleadoDTO;
import Recuperable.DTO.Employee;
import Recuperable.Persistencia.EmpHiberDAO;
import Recuperable.Persistencia.EmpJDBCDAO;
import Recuperable.Persistencia.EmpJPADAO;
import Recuperable.Persistencia.Recuperable;
import hibernate.dominio.Employees;


public class MainEmpService {

	public static void main(String[] args) {

		EmpService eS = new EmpService();
		
		//Con Hibernate
		Recuperable Obj_recuperable1 = new EmpHiberDAO();
		eS.setRecuperable(Obj_recuperable1);
		Object emp1 = (Employees) eS.LeerEmpleado(100);
		
		System.out.println("");
		System.out.println("Resultado de usar Hibernate");
		System.out.println(emp1.toString());
		System.out.println("");
		
		//Con JDBC
		Recuperable Obj_recuperable2 = new EmpJDBCDAO();
		eS.setRecuperable(Obj_recuperable2);
		Object emp2 = (EmpleadoDTO) eS.LeerEmpleado(100);

		System.out.println("Resultado de usar JDBC");
		System.out.println(emp2.toString());
		System.out.println("");
		
		//Con JPA
		Recuperable Obj_recuperable3 = new EmpJPADAO();
		eS.setRecuperable(Obj_recuperable3);
		Object emp3 = (Employee) eS.LeerEmpleado(100);
		
		System.out.println("Resultado de usar JPA");
		System.out.println(emp3.toString());
	
		
		
	}
	

}

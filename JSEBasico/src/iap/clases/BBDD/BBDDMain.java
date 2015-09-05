package iap.clases.BBDD;

import java.util.ArrayList;
import java.util.List;


public class BBDDMain {

	public static void main(String[] args) throws Exception {
		
		EmpleadoDAO empDAO = new EmpleadoDAO();
		
		ArrayList<EmpleadoDTO> le = empDAO.recuerarTodos();
		
		System.out.println(le);
		
	}

}

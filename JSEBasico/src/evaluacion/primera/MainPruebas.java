package evaluacion.primera;

import java.sql.SQLException;
import java.util.ArrayList;


public class MainPruebas {

	public static void main(String[] args) throws SQLException {
		
		RegionDAO reg = new RegionDAO();
//		RegionDTO objDTO = new RegionDTO(50, "Cuernavaca");
//		
//		//Insertar región
//		boolean ok;
//		ok = reg.insertarRegion(objDTO);
//		System.out.println(ok);
		
		//Recuperar región por ID
		//RegionDTO reg1 = reg.recuperarRegionXId(1);
		
		//System.out.println(reg1.toString());
		
//		Recuperar todas las regiones
		ArrayList<RegionDTO> le = reg.recuerarTodos();
		System.out.println(le);

	}

}

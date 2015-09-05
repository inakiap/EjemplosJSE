package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

public class RegionDAO {
	
	public RegionDAO (){}
	
	/**
	 * Método que muestra todas las regiones  
	 * @return devuelve un ArrayList
	 * @throws SQLException
	 */
	public ArrayList<RegionDTO> recuerarTodos () {
		
		ArrayList<RegionDTO> le = null;
		Connection conn = ConexionBBDD.obtenerConexion(); //Obtengo la conexión de la clase ConexionBBDD
		
		ResultSet rset = null;
		Statement busqueda = null;
		RegionDTO emp = null;
		
		try{
			busqueda = conn.createStatement(); //esta linea y la siguiente se encargan de hacer la búsqueda 
			rset = busqueda.executeQuery (InstruccionesSQL.consultaRegiones); // las describo en la clase InstruccionesSQL
		
			le = new ArrayList<RegionDTO>();
			while (rset.next()) {
				emp = new RegionDTO (rset.getInt(1), rset.getString(2));
									
				le.add(emp);
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Error de la bbdd");
		}
		finally {
		ConexionBBDD.liberarRecursos(ConexionBBDD.obtenerConexion(), busqueda, rset);
		}
		return le;
	}

	/**
	 * Método que insterta una región a partir de un objeto región que le paso y me dice si sale o no
	 * @param objReg le doy un objeto de región
	 * @return devuelve true si salió la operación y false si no.
	 * @throws SQLException
	 */
	public boolean insertarRegion(RegionDTO objReg) throws SQLException {
		boolean ok = true;
		
		System.out.println(recuperarRegionXId(objReg.getId()));
		
		if (recuperarRegionXId(objReg.getId()) == null) {
		
			Connection conn = ConexionBBDD.obtenerConexion(); //Obtengo la conexión de la clase ConexionBBDD
			Savepoint inicio = null;
			PreparedStatement insercion = null; 
			
			try {
				//me aseguro que los cambios de la base de datos no se hagan a menos que yo lo diga
				conn.setAutoCommit(false);
	
				//pongo un punto de salvaguarda en las operaciones con la bbdd
				inicio = conn.setSavepoint();
				
				//A continuación utilizo PreparedStatement para insertar los datos de la región que quiero crear
				
				insercion = conn.prepareStatement(InstruccionesSQL.insertarRegion);
				insercion.setInt(1, objReg.getId());
				insercion.setString(2, objReg.getNombre());
				insercion.execute();
				
				conn.commit();
				ok = true;
			} catch (SQLException e) {
				System.out.println("Error al trabajar con la bbdd");
				conn.rollback(inicio); //En caso de error le digo que vuelva al punto de salva guarda puesto
				e.printStackTrace();
			} finally{
				ConexionBBDD.liberarRecursos(ConexionBBDD.obtenerConexion(), insercion);
			}
		}else {
			ok = false;
		}
		return ok;
	}
	
	/**
	 * Método que devuelve una región mostrar una región introduciendo su id y me devuelve el objeto región
	 * @param region_id le introduzco un número de identificador de la región a buscar
	 * @return el objeto región encontrado
	 * @throws SQLException
	 */
	public RegionDTO recuperarRegionXId (int region_id) throws SQLException{

		RegionDTO region = null;
		ResultSet rS = null;
		String nombreRegion = "";
		int idRegion = 0;
		
		Connection conn = ConexionBBDD.obtenerConexion(); //Obtengo la conexión de la clase ConexionBBDD
		
		PreparedStatement busqueda = null;
		
		try {
			//Utilizo PreparedStatement para buscar los datos de la región que quiero ver
			busqueda = conn.prepareStatement(InstruccionesSQL.recuperarRegionXId);
			busqueda.setInt(1,region_id);
			rS = busqueda.executeQuery();
		
			while (rS.next()){
				idRegion = rS.getInt(1);
				nombreRegion = rS.getString(2);
			}
			region = new RegionDTO(idRegion, nombreRegion);

		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error con la bbdd");
		}	
		finally {
		ConexionBBDD.liberarRecursos(ConexionBBDD.obtenerConexion(), busqueda, rS);
		}
		return region;
		
	}

}	

	
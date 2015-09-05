package iap.clases.BBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoDAO {
	
	public EmpleadoDAO (){}
	
	/**
	 * método que recupera todos los empleados de la base de datos en un ArrayList con objetos de tipo EmpleadoCTO
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<EmpleadoDTO> recuerarTodos () throws SQLException{
		
		ArrayList<EmpleadoDTO> le = null;
		Connection conn = ConexionBBDD.obtenerConexion(); //Obtengo la conexión de la clase ConexionBBDD
		conn.setAutoCommit(false); //me aseguro que los cambios de la base de datos no se hagan a menos que yo lo diga
		Savepoint inicio = conn.setSavepoint(); //pongo un punto de salvaguarda en las operaciones con la bbdd
		
		
		ResultSet rset = null;
		Statement busqueda = null;
		EmpleadoDTO emp = null;

		try {
			
			busqueda = conn.createStatement(); //esta linea y la siguiente se encargan de hacer la búsqueda según 
			rset = busqueda.executeQuery (InstruccionesSQL.consultaEmpleado); // las describo en la clase InstruccionesSQL
		} catch (SQLException e) {
			System.out.println("Fallo de la BBDD");
			conn.rollback(inicio); //En caso de error le digo que vuelva al punto de salva guarda puesto
			e.printStackTrace();
		}
		le = new ArrayList<EmpleadoDTO>();
		try {
			while (rset.next()) {

				emp = new EmpleadoDTO (rset.getInt(1), //aquí paso todos los datos
									rset.getString(2),
									rset.getString(3),
									rset.getString(4),
									rset.getString(5),
									rset.getString(6),
									rset.getString(7),
									rset.getString(8),
									rset.getString(9),
									rset.getString(10),
									rset.getString(11));
				le.add(emp);
				}
		} catch (SQLException e) {
				System.out.println("Fallo de la BBDD");
				conn.rollback(inicio);
			e.printStackTrace();
		} finally {
		conn.commit();
		ConexionBBDD.liberarRecursos(ConexionBBDD.obtenerConexion(), busqueda, rset);
		}
		return le;
	}
}

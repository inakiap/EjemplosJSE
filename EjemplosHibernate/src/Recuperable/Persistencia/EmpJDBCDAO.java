package Recuperable.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Recuperable.DTO.EmpleadoDTO;

public class EmpJDBCDAO implements Recuperable{
		@Override
	public Object leerEmpleado(int n) {
		
		EmpleadoDTO empleado = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String cadena_conexion = "jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "HR";
		String pass = "tehure";
		
		String busquedaEmpleado = "select * from employees where employee_id = ?";
		
		Connection conn = null;
		ResultSet rset = null;
		PreparedStatement busqueda = null;
		
		
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection (cadena_conexion, usuario, pass);
  	        busqueda = conn.prepareStatement(busquedaEmpleado);
  	        busqueda.setInt(1, n);
  	        rset = busqueda.executeQuery();
  	        if (rset.next()){
  	        	empleado = new EmpleadoDTO(rset.getInt(1),
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
  	        }
			
			conn.commit();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally 
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (busqueda != null)	{ try {	busqueda.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		} 
		return empleado;
	}

}

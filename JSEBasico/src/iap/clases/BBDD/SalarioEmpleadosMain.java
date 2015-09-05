package iap.clases.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SalarioEmpleadosMain {
	
	
	
	public static void main(String[] args) {
		
		//creamos los objetos necesarios para la conexión, recoger los datos y para hacer la búsqueda
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		
		
		try
		{
			//registro el driver, en realidad, hago que se ejecuten unas pocas l�neas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// m�todo equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexi�n, se la pides a esa clase!>>
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "tehure");
  	        stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from EMPLOYEES where SALARY >3000 order by salary desc");
			EmpleadoDTO emp = null;
			ArrayList<EmpleadoDTO> le = new ArrayList<EmpleadoDTO>();
			
			while (rset.next()) {
				/*  
				for (int j = 1; j < 12; j++) {
					System.out.print (rset.getString(j)+" ");
				}
				System.out.println();*/
				
				emp = new EmpleadoDTO (rset.getInt(1),
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
				
			System.out.println(le.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		}   
		
	}
	
}

package iap.clases.BBDD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexionBBDD {
	
	//
	private static ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection = null;
	
	
	
	private ConexionBBDD (){
		Properties datosBD = new Properties ();
		
		try {
			datosBD.load(new FileInputStream("datosBBDD.properties"));
			
			Class.forName(datosBD.getProperty("driver"));
			this.connection = DriverManager.getConnection (datosBD.getProperty("bbdd"),datosBD.getProperty("usuario"),datosBD.getProperty("contrasenia"));
			this.connection.setAutoCommit(false);
			
		} catch (FileNotFoundException e) {
			System.out.println("No encuentra el archivo de propiedades");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Fichero de properties no encontrado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Falla la conexión a la bd");
			e.printStackTrace();
		}
	
	}

	public static Connection obtenerConexion ()
	{
		return conexion.connection;
	}
	
	
	public static void liberarRecursos (Connection conexion, Statement stmt, ResultSet rset ){
		
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conexion != null) 	{ try { conexion.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	  	   
	}
	
}

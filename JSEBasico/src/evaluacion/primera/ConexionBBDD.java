package evaluacion.primera;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * Esta clase sirve para crear la conexión con una base de datos utilizando Hibernate
 * @author inakiap
 *
 */
public class ConexionBBDD {
	
	private static ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection = null;
	
	
	/**
	 * Método constructor que inicia la conexión. Los datos para la conexión estan guardados en un archivo de propiedades datosBBDD.properties
	 */
	private ConexionBBDD (){
			
			Properties datosBD = datosConexion();
		
		try {
			
			Class.forName(datosBD.getProperty("driver"));
			this.connection = DriverManager.getConnection (datosBD.getProperty("bbdd"),datosBD.getProperty("usuario"),
					datosBD.getProperty("contrasenia"));
			this.connection.setAutoCommit(false);
			
		} catch (SQLException e) {
			System.out.println("Falla la consulta SQL");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Falla la conexión a la bd");
			e.printStackTrace();
		}
	
	}
	/**
	 * Método que establece la conexión con la bbdd
	 * @return
	 */
	public static Connection obtenerConexion ()
	{
		Properties datosBD = datosConexion();
		
		try {
			conexion.connection = DriverManager.getConnection (datosBD.getProperty("bbdd"),datosBD.getProperty("usuario"),
					datosBD.getProperty("contrasenia"));
		} catch (SQLException e) {
			System.out.println("Falla la conexión a la bd");
			e.printStackTrace();
		}
		return conexion.connection;
	}
	/**
	 * Método que permite cargar los datos de la conexión a la bbdd desde un archivo .properties
	 * @return
	 */
	public static Properties datosConexion (){
		Properties datosBD = new Properties ();
		String driver = null;
		String cadenaConexion = null;
		String usuario = null;
		String contrasenia = null;
		try {
			datosBD.load(new FileInputStream("datosBBDD.properties"));
			driver = datosBD.getProperty("driver");
			cadenaConexion = datosBD.getProperty("bbdd");
			usuario = datosBD.getProperty("usuario");
			contrasenia = datosBD.getProperty("contrasenia");
		} catch (IOException e1) {
			System.out.println("Error en el archivo de properties");
			e1.printStackTrace();
		}
		return datosBD;
	}
	
	/**
	 * Método que libera recursos, cuando hay tres elementos que cerrar resulset, statemente y conexión
	 * @param conexion
	 * @param stmt
	 * @param rset
	 */
	public static void liberarRecursos (Connection conexion, Statement stmt, ResultSet rset ){
		
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conexion != null) 	{ try { conexion.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	  	   
	}
	
	/**
	 * Método que libera recursos, cuando hay dos statemente y conexión
	 * @param conexion
	 * @param stmt
	 * @param rset
	 */
	public static void liberarRecursos (Connection conexion, PreparedStatement Pstmt){
		
		if (Pstmt != null)	{ try {	Pstmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conexion != null) 	{ try { conexion.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	  	   
	}
	
}

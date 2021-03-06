package hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {
	
	static {
		
		Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	sesion_factory = configuration.buildSessionFactory(builder.build());
		
	}
	
	private static SessionFactory sesion_factory;
	
	
	private SessionManager (){}
	
	public static SessionFactory getSessionFactory ()
	{
		return sesion_factory;
	}
	
	public static Session obtenerSesionNueva ()
	{
		return sesion_factory.openSession();
	}
	
	
	public static void cerrarSession (Session sesion)
	{
		sesion.close();
		
	}
	
	public static void cerrarFactory (){
		sesion_factory.close();
	}
}


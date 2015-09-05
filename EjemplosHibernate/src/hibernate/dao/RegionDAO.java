package hibernate.dao;

import hibernate.dominio.Countries;
import hibernate.dominio.Regions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RegionDAO extends SessionDAO implements GenericoDAO  {
	
	public static final String bus_regiones = "SELECT * FROM REGIONS";

	/**
	 * Método que realiza una busqueda en la tabla de regiones
	 * @param sesion hay que darle la sesión activa
	 * @param busqueda se le pasa busqueda SQL como cadena
	 */
	@SuppressWarnings("unchecked")
	public void verRegiones (){
		
		List<Regions> list = getSesion().createSQLQuery(bus_regiones).addEntity(Regions.class).list();
		Iterator<Regions> it = list.iterator();
		Regions continente = null;
		Countries pais = null;
		
		while (it.hasNext())
		{
			continente = it.next();
			System.out.println(continente.getRegionName());
			
			Set <Countries> paises = new HashSet<Countries>();
			paises = continente.getCountrieses();
			
			Iterator<Countries> it2 = paises.iterator();
			
			
			
			while (it2.hasNext()) {
				
				pais = it2.next();
				
				System.out.println("--->  " + pais.getCountryName());
				
			}
			
		}
	}

	@Override
	public void crear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object leer(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List leerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Object o) {
		// TODO Auto-generated method stub
		
	}

}

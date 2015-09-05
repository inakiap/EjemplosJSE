package test.evaluacion.primera;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;





import evaluacion.primera.RegionDAO;
import evaluacion.primera.RegionDTO;

public class TestRegionDAO {
	RegionDAO prueba = null;
	RegionDTO prueba2 = new RegionDTO (10, "Caracas");
	
	/**
	 * Creo un objeto de prueba
	 */
	@Before
	public void inicio (){
		prueba = new RegionDAO();
	}
	
	/**
	 * Prueba que el método recuperarTodos devuelve algo.
	 * @throws SQLException
	 */
	@Test
	public void testRecuerarTodos() throws SQLException {
		assertNotNull(prueba.recuerarTodos());
	}
	
	/**
	 * Prueba que el método devuelve verdadero al insertar
	 * @throws SQLException
	 */
	@Test
	public void testInsertarRegion() throws SQLException {
		assertTrue(prueba.insertarRegion(prueba2));
	}
	
	/**
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testRecuperarRegionXId () throws SQLException{
		assertNotNull(prueba.recuperarRegionXId(1));
	}
}
;
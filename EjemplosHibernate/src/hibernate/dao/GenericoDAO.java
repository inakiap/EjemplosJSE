package hibernate.dao;

import java.util.List;

/**
 * 
 * @author Iñaki Alfaro
 *
 */
public interface GenericoDAO {
	
	void crear ();
	
	Object leer(int key);
	
	@SuppressWarnings("rawtypes")
	List leerTodos ();
	
	void modificar (int key);

	void borrar (Object o);

	
}

package evaluacion.primera;

/**
 * En clase la utilizamos solamente para escribir las sentencias SQL que vamos a utilizar en el programa.
 * @author inakiap
 *
 */
public class InstruccionesSQL {
	
	public static final String consultaRegiones = "select * from REGIONS";
	
	public static final String insertarRegion = "insert into Regions (region_id, region_name) values (?, ?)";
	
	public static final String recuperarRegionXId = "select * from REGIONS where region_id =?";
	
			
}

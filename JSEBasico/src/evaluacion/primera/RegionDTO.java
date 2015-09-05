package evaluacion.primera;

public class RegionDTO {
	private int id;					//1
	private String nombre;			//2
	
	/**
	 * Método constructor para crear objeto con valores 
	 * @param id
	 * @param nombre
	 */
	public RegionDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Método constructor vacio
	 */
	public RegionDTO (){
		
	}
	@Override
	public String toString() {
		String res = "----------------------\n";
		res += "id: " + this.id + "\n";
		res += "nombre: " + this.nombre + "\n";
		res += "----------------------\n";
		return res;
	}
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		RegionDTO  rgDTO = (RegionDTO)arg0;
		return (this.id == rgDTO.getId() && this.nombre.equals(rgDTO.getNombre()));
	}
	
	public int compareTo(RegionDTO arg0) {
		// TODO Auto-generated method stub
		return this.id - arg0.getId();
	}
}

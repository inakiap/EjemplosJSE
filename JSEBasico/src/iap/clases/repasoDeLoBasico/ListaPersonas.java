package iap.clases.repasoDeLoBasico;

import iap.clases.iterator.Recorrer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Properties;


public class ListaPersonas implements Iterable<Persona>{

	public static final int CAPACIDAD = 10;
	//la clase persona implica serializable
	
	private int numPersonas;
	private Persona[] array_personas;
	
	/**
	 * Sirve para devolver el número de personas de la lista
	 * @return
	 */
	private int getNumPersonas(){
		return this.numPersonas;
	}
	//método para cambiar el número de personas de la lista
	private void setNumPersonas(int numPersonas){
		this.numPersonas = numPersonas;
	}
	//método para mostrar el número de personas de la lista
	private Persona[] getArray_Personas (){
		return array_personas;
	}
	//método para cambiar el array de personas
	private void setArray_Personas (Persona[] array_personas){
		this.array_personas = array_personas;
	}
	
	//método constructor de la clase ListaPersonas	
	public ListaPersonas()
	{
		//TODO HAY QUE HACER UN CONSTRUCTOR
		//RECUERDA QUE EL CONSTRUCTOR SIRVE PARA
			//RESERVAR MEMORIA
			//INICIALIZAR EL ESTADO DEL OBJETO Y SUS ATRIBUTOS
		this.array_personas = new Persona [CAPACIDAD];
		this.numPersonas = 0;
	}
	
	/**
	 * Método para buscar una persona en la lista por el nombre
	 * @param nombre
	 * @return un objeto de la clase Persona
	 */
	public Persona buscarPersona (String nombre)
	{
		//TODO BUSCAR PERSONA POR NOMBRE Y DEVOLVERLA
		//SI NO ESTÓ, DEVOLVER NULO

		int i = 0;
		Persona perBuscada = null;
		boolean encontrado = false;
		
		if (numeroPersonas()!= 0) {
			while (!encontrado && (i<CAPACIDAD) ) {
				if (this.array_personas[i].getNombre().equals(nombre)) {
					perBuscada = array_personas [i];
					encontrado = true;
				
				}
				i++;
			
			}
		}	
			return perBuscada;
		
	}
	
	/**
	 * Método para buscar una persona en la lista por la edad
	 * @param edad
	 * @return
	 */
	public Persona busarPersona (int edad)
	{
		//TODO BUSCAR PERSONA POR EDAD Y DEVOLVERLA
		//SI NO ESTÓ, DEVOLVER NULO
		int i = 0;
		Persona perBuscada = null;
		boolean encontrado = false; 
		
		while (!encontrado && (i < getNumPersonas()-1)) {
			if (this.array_personas[i].getEdad() == edad) {
				encontrado = true;
				perBuscada = array_personas [i];
			}
			
			i++;
			
		}
		
			return perBuscada;
	}
	
	/**
	 * Método para leer el archivo .properties donde vienen dado datos para el programa
	 * @return devuelve una cadena
	 */
	private String leerProperties () 
	{
		//Hacer uso del fichero de propiedades serializa.properties, 
		String archivoSalida = "";
		Properties prop = new Properties();
		FileInputStream nomArchivo = null;
				
		try {
			nomArchivo = new FileInputStream("serializa.properties");
				
		} catch (FileNotFoundException e) {
		
			System.out.println("No se encuentra el archivo .properties");
			e.printStackTrace();
		}
		//para obtener de él el valor de la clave destino, 
		try {
			prop.load(nomArchivo);
		} catch (IOException e) {
			System.out.println("Error al leer el archivo . propoerties");
			e.printStackTrace();
		}
		//que representa el nombre del fichero de salida
		archivoSalida = prop.getProperty("destino");
		return archivoSalida;
	}	
	
	/**
	 * Método para pasar el programa a un archivo
	 * @return se devuelve un true o false para saber si tuvo éxito el programa
	 */
	public boolean serializar ()
	{
		boolean hecho = true;

		//serializamos
		ObjectOutputStream alFichero = null;
		try {
			alFichero = new ObjectOutputStream(new FileOutputStream(leerProperties()));
			alFichero.writeObject(this);
			alFichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Me");
			hecho = false;
			e.printStackTrace();
		} catch (IOException e) {
			hecho = false;
			e.printStackTrace();
		}
		
		return hecho;
	}
	
	/**
	 * Método para tomar el archivo y pasarlo a memoria
	 * @return
	 */
	public Persona[] deserializar()
	{
		Persona [] ap = null;
		ObjectInputStream delFichero = null;
		
		try {
			delFichero = new ObjectInputStream(new FileInputStream(leerProperties()));
			ap = (Persona[])delFichero.readObject();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado en las propierties \"listapersonas.dat\"");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				delFichero.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero deserializable \"listapersonas.dat\"");

			}
		}
		
		return ap;
	}
	
	public void insertarPersona (Persona p) throws InsertarPersonaException
	{
		Persona nuevaPersonita = null;
		//ver que la lista no esté llena
		if (!estaLlena()){
			//que la persona no se repita
			if (buscarPersona(p.getNombre()) == null) {
				nuevaPersonita = p ;
				array_personas[this.numPersonas] = nuevaPersonita;
				this.numPersonas++;
			}else {
				System.out.println("Ya existe una persona en la lista llamada: " + p.getNombre());
			}
			
		}
		
	}
	
	public int numeroPersonas()
	{
		return getNumPersonas();
	}
	
	public boolean estaLlena()
	{
		boolean resp = false;
		if (CAPACIDAD <= getNumPersonas()) {
			resp = true;
		}
		return resp;
	}
	
	public boolean estaVacia()
	{
		boolean resp = false;
		if (getNumPersonas() == 0){
			resp = true;
		}
		return resp;
	}
	
	public int posicionPersona (String nombre) {
		int pos =-1;
		boolean encontrada = false;
		int aux = 0;
		while(!encontrada && aux < numPersonas){
			if (this.array_personas[aux].getNombre().equals(nombre)){
				pos = aux;
			}
			aux++;
		}
		
		return pos;
	}
	
	public void eliminarPersona (String nombre) {
		int pos =0;
		if (  (numeroPersonas()>0 )&&((pos = posicionPersona(nombre))!= -1)   ){ //si hay personas y si existe esa persona...
			for(int i= pos; i<CAPACIDAD-1; i++){
				this.array_personas[i] = this.array_personas[i+1];
			}
			this.array_personas[CAPACIDAD-1] = null;
			this.numPersonas--;
		}
		else{//si no existe la persona a borrar
			System.out.println("La persona \"" + nombre + "\" NO existe en la lista" );
		}
	}
	
	public void mostrar(){
		if(this.numPersonas > 0){
			for (int i = 0; i < this.numPersonas; i++){
				System.out.println(array_personas[i].toString());
			}
		}
		else{
			System.out.println("No hay personas en la lista");
		}
	}
	
	@Override
	public Iterator<Persona> iterator() {
		Recorrer r = new Recorrer(this);
		return r;
	}
	

	/*@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}*/

}

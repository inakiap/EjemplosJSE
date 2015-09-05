package iap.clases.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


	
	public class ExtraerYOrdenarEmails {
		
		private static final String PPIO_MAIL = "***";
		private static final String FIN_MAIL = "///";
		
		
		/**
		 * Método que saca de una linea leida del fichero todos los emails entre *** y ///
		 * @param lineaActual
		 * @return
		 */
		private static String procesarLinea (String lineaActual){
			
			String mailsLineaActual = "";
		//TODO tienes que acabar 
			
			while (((lineaActual.indexOf(PPIO_MAIL)) != -1) && ((lineaActual.indexOf(FIN_MAIL)) != -1) ) {
				//tiene que haber marcas de inicio y de final
				// en la posici�n final pongo un +1 para coger una de las / para separar los mails en la cadena
				mailsLineaActual = mailsLineaActual + lineaActual.substring((lineaActual.indexOf(PPIO_MAIL))+3, (lineaActual.indexOf(FIN_MAIL))+1);
				
				// se supone que tras sacar el correo acabado en una / le digo que vuelva a buscar en la linea recortada hasta el mail...
				lineaActual = lineaActual.substring(lineaActual.indexOf(FIN_MAIL)+3);
				
			}
						
				
			return mailsLineaActual;
		}
		/**
		 * Método que recorre el fichero y devuelvo un String, que estar� compuesto por todos
		 * los mails que aparecen en el fichero separados por /
		 * 
		 * @param br
		 * @return
		 * @throws IOException
		 */
		private static String obtenerEmails (BufferedReader br) throws IOException
		{
			String listaMails = "";
			String linea = null;
		
			boolean final_fichero = false;
			
			while (!final_fichero)
			{
				linea = br.readLine();
				if (linea == null)
				{
					final_fichero = true;
				} else 
					{
						listaMails = listaMails + procesarLinea (linea);
					
					}
			}
			
			return listaMails;
			
		}
		/**
		 * M�todo para leer el archivo del que extraer las direcciones
		 * @param ruta
		 * @return
		 * @throws FileNotFoundException
		 */
		private static BufferedReader abrirYPrepararFichero (String ruta) throws FileNotFoundException
		{
			BufferedReader br = null;
			File f = new File(ruta);//creo un objeto File con el parametro ruta que se introduce
			if (f.exists() && f.isFile() && f.canRead()) {//comprobar que existe, si es un archivo de texto y que se puede leer
				FileReader fileReader = new FileReader(f);
				br = new BufferedReader(fileReader);
			}
			return br;
		}
		/**
		 * Método que recibe un String que contiene TODOS los mails
		 * separados por una / y los pasa a una array
		 * @param lista_mails
		 * @return
		 */
		private static String [] hacerArrayDeMails (String listaMails)
		{
			String [] arrayMails = null;
			
			arrayMails = listaMails.split("/");
			
			return arrayMails;
		}
		/**
		 * Método que recorre e imprime un array
		 * @param listaMails
		 */
		private static void mostrarMails (String [] listaMails)
		{
			for (int i = 0; i < listaMails.length; i++) {
				System.out.println((i+1) + " " + listaMails[i]);
			}
		}
		/**
		 * Le paso un array de cadenas y las ordena en función a su naturaleza.
		 * @param arrayMails
		 */
		private static void ordenarMails (String [] arrayMails)
		{
			Arrays.sort(arrayMails);
		}
		
		/**
		 * Cerrar el archivo abierto
		 * @param br
		 * @throws IOException
		 */
		private static void cerrarFichero (BufferedReader br) throws IOException
		{
			br.close();
			
		}
		

		/**
		 * NOTA Todos los métodos de la clase son static, para facilitar su uso sin tener
		 * que instanciar un Objeto. Si no fueran static, con declarar un objeto de la clase
		 * ya podría llamar a los métodos, por ejempleo
		 * 	
		 * 	ClaseLeeMails clm = new ClaseLeeMails();
		 *  clm.ababrirYPrepararFichero ... etc 
		 *  
		 *  OK????
		 * 	 
		 * */
		
		public static void main(String[] args) throws IOException {
			
			//invoco a Runtime que me permite o bien llamar al Garbagecollector o bien
			Runtime runtime = Runtime.getRuntime();
			long memoInicio = runtime.freeMemory();
			
			long t0 = System.currentTimeMillis();
			
			
			String ruta = "direcconesApegote.txt";//el nombre del fichero de entrada
			String listaMails = null; //aqu� guardar� los mails, separados por la el s�mbolo /
			String [] arrayMails = null; //aqu� guardaer los mails, cada uno en su posici�n!
			BufferedReader br = null; // Objeto para leer un fichero de texto por l�neas!
			
					
			br = abrirYPrepararFichero(ruta);
			listaMails = obtenerEmails(br);
			cerrarFichero (br);
			arrayMails =  hacerArrayDeMails(listaMails);
			ordenarMails (arrayMails); // Este m�todo es opcional, aunque luego veremos que es muy f�cil de hacer!
			mostrarMails(arrayMails);
			
			/*System.out.println(obtenerEmails(abrirYPrepararFichero("direcconesApegote.txt")));*/
			
			runtime.gc();
			long t1 = System.currentTimeMillis();
			long memoFin = runtime.freeMemory();
			System.out.println(t1-t0);
			System.out.println("Memoria al inicio: " + memoInicio + " bytes.");
			System.out.println("Memoria al final: " + memoFin + " bytes.");
			System.out.println("Memoria usada: " + (memoFin-memoInicio) + " bytes.");
			
		}
	
}
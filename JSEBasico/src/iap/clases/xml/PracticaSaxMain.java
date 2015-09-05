package iap.clases.xml;

import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class PracticaSaxMain {
	public static void main(String[] args) {
		 try {  
	         // Creamos nuestro objeto libro vac�o  
	         Libro libro = new Libro();  
	         
	         // Creamos la factoria de parseadores por defecto  
	         XMLReader reader = XMLReaderFactory.createXMLReader();  
	         
	         // 
	         LibroXML libroleido = new LibroXML(libro);
	         
	         // A�adimos nuestro manejador al reader pasandole el objeto libro  
	         reader.setContentHandler(libroleido);   
	         
	         // Procesamos el xml de ejemplo  
	         reader.parse(new InputSource(new FileInputStream("libros.xml")));  
	         
	         //System.out.println(libro.toString());
	         System.out.println(libroleido.getColeccionLibros());
	         
	         
	      } catch (SAXException e) {  
	         e.printStackTrace();  
	      } catch (IOException e) {  
	         e.printStackTrace();  
	      }  
	}
}

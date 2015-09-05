package iap.clases.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class PracticaJDOMMain {
	
	public static Element parsearXML (String ruta) throws FileNotFoundException,
	JDOMException , IOException{
		//CREAMOS EL PARSER
		SAXBuilder builder = new SAXBuilder();
		// Construimos el arbol DOM a partir del fichero xml
		Document documentJDOM = builder.build(new FileInputStream("libros.xml"));
				
		//recorro el documento en busca del elemento raiz
		Element raiz = documentJDOM.getRootElement();

		return raiz; 
	}
	
	public static ArrayList <Libro> crearArrayList (Element e){
		//creo un objeto libro
		Libro aguardar = null;
		// creo el arraylist para meter los libros
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		// Recorremos los hijos de la etiqueta raíz
		List<Element> libros = e.getChildren();
		for (Element libro : libros) {
			//para cada libro, obtenemos su detalle
			aguardar = new Libro();
			aguardar.setIsbn(libro.getAttribute("isbn").getValue());
			List<Element> detalles = libro.getChildren();
			
			for (Element detalle : detalles) {
				switch (detalle.getName()) {
				case "titulo":
					aguardar.setTitulo(detalle.getValue());
					break;
				case "autor":
					aguardar.setAutor(detalle.getValue());
					break;
				case "anyo":
					aguardar.setAnyo(detalle.getValue());
					break;
				case "editorial":
					aguardar.setEditorial(detalle.getValue());
					break;
				default:
					break;
				}
			
			}
			listaLibros.add(aguardar);
		
		}
		return listaLibros;
	}

	public static void ordenarArrayList (ArrayList<Libro> al){
				
		//creo objeto para ordenar libros
		OrdenarLibrosPorTitulo olpt = new OrdenarLibrosPorTitulo();
							
		//Ordenar el arrayList
		Collections.sort(al, olpt);
		 
	}
	
	public static Document generarNuevoDocumento (ArrayList<Libro> al){
		Element padre = new Element("libros");
		Document salida = new Document(padre);
		
		//contar los libros
		int contador = 0;
		
		
		for (Libro ele : al){
			//creo elemento libro y le añado atributo isbn
			Element libNuevo = new Element("libro");
			libNuevo.setAttribute("ISBN", ele.getIsbn());
			//creo elemento título
			Element tit = new Element("Título");
			tit.addContent(ele.getTitulo());
			//creo elemento autor
			Element aut = new Element("Autor");
			aut.addContent(ele.getAutor());
			//creo elemento año
			Element ano = new Element("Año");
			ano.addContent(ele.getAnyo());
			//creo elemento editorial
			Element edit = new Element("Editorial");
			edit.addContent(ele.getEditorial());
			
			libNuevo.addContent(tit);
			libNuevo.addContent(aut);
			libNuevo.addContent(ano);
			libNuevo.addContent(edit);
			padre.addContent(libNuevo);
			//contar los libros
			contador ++;
			
		}
			Element numero = new Element("total");
			numero.addContent(Integer.toString(contador));
			padre.addContent(numero);	
		return salida;
	}

	public static void escribirAFichero (Document doc, String ruta) throws IOException {
	//SERIALIZO EL DOCUMENT A UN FICHERO DE SALIDA
    Format format = Format.getPrettyFormat();
    // Creamos el serializador con el formato deseado  
    XMLOutputter xmloutputter = new XMLOutputter(format);
    // Serializamos el document parseado  
    String docStr = xmloutputter.outputString(doc);
    //contador de libros
    
    //Volcamos en un fichero
    FileWriter fw = new FileWriter(ruta);
    fw.write(docStr);
    fw.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, JDOMException { 
		
		Element raiz = parsearXML ("libros.xml");
		
		ArrayList<Libro> biblio = crearArrayList(raiz);
		
		ordenarArrayList(biblio);
		
		Document nuevo = generarNuevoDocumento(biblio);
		
		escribirAFichero(nuevo, "librosPorMtodos.xml");
		
		
		
		
				
		
			
		
		
	  
	}

}

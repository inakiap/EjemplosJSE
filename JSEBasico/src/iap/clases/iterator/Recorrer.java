package iap.clases.iterator;

import iap.clases.repasoDeLoBasico.ListaPersonas;
import iap.clases.repasoDeLoBasico.Persona;

import java.util.ArrayList;
import java.util.Iterator;

public class Recorrer implements Iterator<Persona>{

	public Recorrer(ListaPersonas listaPersonas) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Persona next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		Iterator.super.remove();
	}
	
	public static void main(String[] args) {
		
		Persona p1 = new Persona ("Juanico", 54);
		Persona p2 = new Persona ("Carles", 85);
		Persona p3 = new Persona ("Ioana", 44);


		
		ArrayList <Persona> al = new ArrayList<Persona>();
		al.add(p1); 
	    al.add(p2);
	    al.add(p3);
	    
	    System.out.println("For each");
	    System.out.println("----------");
		for (Persona element : al) {
		
			System.out.println(element.toString());//for each, válido para recorrer Colecciones
	   }
		System.out.println();
		System.out.println("con Iterator");
		System.out.println("------------");
		Iterator<Persona> alI = al.iterator();
		while (alI.hasNext()) {
			System.out.println(alI.next());
			
		}
		

	}

}

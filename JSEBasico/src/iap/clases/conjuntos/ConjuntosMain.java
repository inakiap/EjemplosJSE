package iap.clases.conjuntos;

import iap.clases.repasoDeLoBasico.Alumno;
import iap.clases.repasoDeLoBasico.NotaException;
import iap.clases.repasoDeLoBasico.Persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class ConjuntosMain {
	public static void main(String[] args) throws NotaException {
		//los árboles se usan para tener una colección ordenada
		Map<Integer,Persona> map1 = new HashMap<Integer,Persona>();
		
		Persona per1 = new Persona("Juanico", 12);
		Persona per2 = new Persona("Mariano", 20);
		Persona per3 = new Persona("Eva", 3 );
		Persona per4 = new Persona("Larix", 36);
		
		map1.put(1, per1);
		map1.put(2, per2);
		map1.put(3, per3);
		map1.put(4, per4);
		
		//System.out.println(map1);
		//System.out.println(map1.toString());
		
		
		Map<Integer, Persona> mapica2 = new TreeMap<Integer, Persona>();
		
		mapica2.put(1, per1);
		mapica2.put(4, per2);
		mapica2.put(3, per3);
		mapica2.put(2, per4);
		
		
		
		//System.out.println(mapica2);
		
		Map<Integer, Persona> mapica3 = new LinkedHashMap<Integer, Persona>();
		
		//Creo alumnos aprovechando
		Persona a1 = new Alumno ("Paquito", 32, 6);
		Persona a2 = new Alumno ("Jaimito", 15, 10);
		Persona a3 = new Alumno ("Jorgito", 14, 7);
		Persona a4 = new Alumno ("Modosito", 13, 5);
				
		//
		mapica3.put(((Alumno)a1).getNota(), a1);
		mapica3.put(((Alumno)a2).getNota(), a2);
		mapica3.put(((Alumno)a3).getNota(), a3);
		mapica3.put(((Alumno)a4).getNota(), a4);
		
		//System.out.println(mapica3);
		
		//System.out.println(a1.compareTo(a4));
		
		Set<Persona> setJuegoYPartido = new TreeSet<Persona>();
		
		setJuegoYPartido.add(a1);
		setJuegoYPartido.add(a2);
		setJuegoYPartido.add(a3);
		setJuegoYPartido.add(a4);
		
		//System.out.println(setJuegoYPartido);
		
		ArrayList<Persona> al = new ArrayList<Persona>();
		
		al.add(per1);
		al.add(per2);
		al.add(per3);
		
		OrdenarPorNombre ordenNombre = new OrdenarPorNombre();
		OrdenarPorEdad ordenEdad = new OrdenarPorEdad();
		
		Collections.sort(al, ordenNombre);
		System.out.println(al);
		
		Collections.sort(al, ordenEdad);
		System.out.println(al);
		
		
	}
}

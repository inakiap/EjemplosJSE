package iap.clases.conjuntos;

import iap.clases.repasoDeLoBasico.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MainHashMapTo2 {
	
	public static HashMap <Persona, Persona> hashMapToHM (HashMap <Persona, Persona> hm) {
		HashMap<Persona, Persona> resp = new HashMap<Persona, Persona>();
		Persona person = new Persona();
		//paso el contenido a un TreeSet
		Set <Persona> arbolico = new TreeSet<Persona>();
		arbolico.addAll(hm.values());
		
		ArrayList<Persona> aKey = new ArrayList<Persona>();
		ArrayList<Persona> aValues = new ArrayList<Persona>();
		
		aKey.addAll(hm.keySet());
		aValues.addAll(hm.values());
		
		Iterator<Persona> orden = arbolico.iterator();
		
		while (orden.hasNext()) {
			person = orden.next();
			resp.put(aKey.get(aValues.indexOf(person)), person);
		}
		
		return resp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona per1 = new Persona("Juanico", 12);
		Persona per2 = new Persona("Mariano", 20);
		Persona per3 = new Persona("Eva", 50 );
		Persona per4 = new Persona("Larix", 36);
		
		Persona jar1 = new Persona("A", 1);
		Persona jar2 = new Persona("B", 2);
		Persona jar3 = new Persona("C", 3);
		Persona jar4 = new Persona("D", 4);
		
		HashMap<Persona, Persona> prueba = new HashMap<Persona, Persona>();
		prueba.put(jar1, per1);
		prueba.put(jar2, per2);
		prueba.put(jar3, per3);
		prueba.put(jar4, per4);
		
		System.out.println(prueba);
		System.out.println();
		System.out.println(hashMapToHM(prueba));
		
	}

}

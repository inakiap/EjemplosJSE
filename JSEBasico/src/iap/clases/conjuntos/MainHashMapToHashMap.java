package iap.clases.conjuntos;

import iap.clases.repasoDeLoBasico.Persona;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainHashMapToHashMap {

	public static HashMap<Integer,Persona> hashMap2HashMap (HashMap<Integer, Persona> hm){
		Map <Integer,Persona> resp  = new LinkedHashMap<Integer, Persona>();
		
		//cojo todos los valores
		Map<Integer, Persona> paraOrdenar = new TreeMap<Integer, Persona>(); 
		paraOrdenar.putAll(hm);
		
		//los ordeno > en un TreeMap por el orden Natur
		resp.putAll(paraOrdenar);
		
		//recorro el tree y los vuelco en un LinkedHashMap que respeta el orden
		
		return (HashMap<Integer, Persona>) resp;
		
		
	}
	
	//public MainHashMapToHashMap () {}
	
	public static void main(String[] args) {
		
		Persona per1 = new Persona("Juanico", 12);
		Persona per2 = new Persona("Mariano", 20);
		Persona per3 = new Persona("Eva", 50 );
		Persona per4 = new Persona("Larix", 36);
		
		HashMap <Integer,Persona> hm = new HashMap<Integer, Persona>();
		
		hm.put(15, per1);
		hm.put(42, per2);
		hm.put(63, per3);
		hm.put(4, per4);
		
		//MainHashMapToHashMap mHMTHM = new MainHashMapToHashMap();
		
		System.out.println(hm);
		System.out.println("		-------*-------");
		System.out.println(hashMap2HashMap(hm));
		
		
	}

}

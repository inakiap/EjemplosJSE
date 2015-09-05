package iap.clases.conjuntos;

import iap.clases.repasoDeLoBasico.Persona;

import java.util.Comparator;

public class OrdenarPorNombre implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}
	
	public OrdenarPorNombre () {}
	
}

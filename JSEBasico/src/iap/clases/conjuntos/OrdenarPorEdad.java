package iap.clases.conjuntos;

import iap.clases.repasoDeLoBasico.Persona;

import java.util.Comparator;

public class OrdenarPorEdad implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		int respuesta = -5;
		if (o1.getEdad() < o2.getEdad()) {
			respuesta = -1;
		}else if (o1.getEdad() > o2.getEdad()) {
			respuesta = 1;
		}else {
			respuesta = 0;
		}
		return respuesta;
	}
	
	public OrdenarPorEdad () {}
	
}

package iap.clases.persona;

public class MainComprobacionPersona {

	/*public boolean equals (Object obj){
		boolean dev = false;
		Persona p = null;
		// este churro se supone que es la solucion del profesor al problema de sobreescribir equals en la clase persona
		dev = (null!=obj)&&((obj==this)||((null!=(p=estipopersona(obj)))&&(contienelaMisma(this,p))));
		
		return dev;
				
	}*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Persona paco = new Persona("Paquito", 80);
		//1� caso
		Persona.personaConMasEdadCaso1(paco, 15).mostrarPersona();
		
		
		//2� caso
		paco.personaConMasEdadCaso2(3);
		paco.mostrarPersona();
		//personNueva.mostrarPersona();
		
		
		//3� caso
		Persona.personaConMasEdadCaso3(paco, -55);
		paco.mostrarPersona();
	}

}

package iap.clases.cajonDesastre;

public class PasswordMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Password clave = null;
		String palabra = null;

		clave = new Password(palabra);

		
		do {
											
			clave.pedirDatos();
			
			System.out.println(clave.esPasswordBuena());
			
		} while (clave.esPasswordBuena() == clave.MALA);
		
		
	}

}

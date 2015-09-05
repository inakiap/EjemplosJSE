package iap.clases.repaso1;
//HACER UN M�TODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREV�S
public class Ejercicio6 {

	public static String cadenaInvertida(String cadena){
		String cadenaAlreves = null;
		cadenaAlreves = "";
		for (int i = (cadena.length()-1); i >=0; i--) {
			cadenaAlreves = cadenaAlreves + cadena.charAt(i);
		}
		
		
		return cadenaAlreves;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cadenaInvertida("constantinopla"));
	}

}

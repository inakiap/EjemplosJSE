package iap.clases.array;

public class UltimaLetraMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		char c = args[args.length-1].charAt(0);	/*con esta expresi�n almaceno el primer caracter de la �ltima palabra
												que s� que es una letra y que la quiero contar en el resto del array*/
		int contador = 0; //declaro una variable para que almacene las veces que aparece la letra en cuesti�n
		
		//recorer los argumentos/palabras 
		for (int i = 0; i < args.length-2; i++) {
			
			//recorrer las letras de cada palabra
			for (int j = 0; j < args[i].length(); j++) {
				if (c == args[i].charAt(j)) {
					contador++;
				}
			}
		}
		System.out.println("La letra " +c+ " se repite "+ contador);
		
	}

}

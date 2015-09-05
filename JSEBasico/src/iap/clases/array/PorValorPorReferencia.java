package iap.clases.array;

public class PorValorPorReferencia {
	/*public static int suma(int a, int b) {
		int suma = a + b;
		return suma;

	}

	public static void porValor (int a){
		a = a + 7 ;
	}*/
	/*m�todo con un array de enteros y un valor incremental me devuelva un nuevo array 
	que sea el resultado de sumar el valor incrementado al array de entrada.*/
	public static int [] sumaArray (int[]array, int valor){//podr�a declarar void y no crear un array local del m�todo
		int [] arrayads = new int [array.length];
			for (int i = 0 ; i < array.length ; i++){
				arrayads [i] = array [i] + valor;
			}
		return arrayads;
	}

	public static void mostrarArray (int [] array){
		
		for (int j = 0 ; j < array.length; j++){
			System.out.println(array[j]);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int c = 0;
		c = suma(6, 8);
		System.out.println(c);
		
		int a= 5;
		porValor(a);
		System.out.println(a);*/
		
		int [] array = {5,6,9};
		int [] arrayads = sumaArray (array, 3);
		
		mostrarArray(arrayads);
		
	}

}

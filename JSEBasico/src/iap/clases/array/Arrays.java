package iap.clases.array;

public class Arrays {

	int[] array_de_enteros = new int[10];
	
	static int[] array_cabron;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		array_cabron = new int[15];
		//array bidimensional
		
		String [] [] gente = {{"Peter", "Joan", "Jaime"},{"Jaimito","Jens"}};
		
		int [] arrayaco ={15,65,8,459,55};
		
		int aux = 0;
		String g = null;
		
		for (int i=0; i<arrayaco.length ; i++){
			
			aux = arrayaco [i];
			
			System.out.println(aux);
		}
		
		g = gente [1][1];
		System.out.println(g);
		
		
	}

}

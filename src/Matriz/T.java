package Matriz;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class T extends Thread {  

	// ....................................................... MATRIZ
	
	// .. Caracteristicas
	
	private static int DIM;
	private final static int LIM = 1000;
	private static int[][] matriz;
	
	// .. Inicializar

	public static void inicializarMAtriz() {
		
		matriz = new int[DIM][DIM];

		for(int i = 0; i < DIM; i++) {
			for(int j = 0; j < DIM; j++) {
				matriz[i][j] = ThreadLocalRandom.current().nextInt(0, LIM);
			}
		}
	}
	
	// .. Imprimir

	public static void imprimirMatriz() {

		for(int i = 0; i < DIM; i++) {
			for(int j = 0; j < DIM; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("----------");
	}

	// ....................................................... M�ximo 

	private static Maximo oMax;
	
	private int id = 0 ;
	private int maxEnFila = -1;
	
	// .. Inicializar cada 'Thread' con un identificador (id = fila de la matriz)

	public T (int pId) {
		id = pId ;
	}
	
	// .. Encontrar el max�mo de la fila y actualizar el m�ximo global. 

	public void run () {
		
		// .. Encontrar mayo de la fila
		
		for(int j = 0; j < DIM; j++){
			if(this.maxEnFila < matriz[this.id][j]) this.maxEnFila = matriz[this.id][j];
		}
		
		// .. Imprimir el mayor si ya todos los threads se ejecutaron.
		
		if(oMax.anotar(this.maxEnFila, this.id)) 
			System.out.println("El max�mo de la matriz es: " + oMax.darMaximo() + " - Localizado por el thread: " + oMax.darLocalizador());

	}

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner lector = new Scanner (System.in);
		System.out.println("Ingrese el n�mero de filas de la matriz cuadrada:");
		DIM = lector.nextInt();
		
		// .. Inicializo e imprimo la matriz
		
		System.out.println("----------");
		System.out.println("  Matriz  ");
		System.out.println("----------");

		inicializarMAtriz();
		imprimirMatriz();
		
		// .. Creo el objeto maximo y una cantidad FIJA de threads igual a las dimensiones de la matriz
		
		int numThreads = DIM;
		oMax = new Maximo(numThreads);

		for (int i = 0; i < numThreads; i++) 
			new T (i).start();

	}

}
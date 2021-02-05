package Matriz;

public class Maximo {  
	
	// ........... Variable que lleva el max�mo. Adem�s contador de la cantidad threads que han pasado.

	private int maximo, contador, numThreads, localizador; 
	
	// .. Constructor
	
	public Maximo(int pThreads) {
		maximo = 0;
		contador = 0;
		numThreads = pThreads;
	}
	
	// .. M�ximo

	public int darMaximo () {
		return maximo ;
	}
	
	// .. Id del thread 
	
	public int darLocalizador() {
		return localizador;
	}
	
	// .. M�todo que solo accede UN SOLO THREAD a la vez
	
	public synchronized boolean anotar (int n, int pId) {
		
		if (n > maximo) {
			maximo = n ;
			localizador = pId+1;
		}
		
		if(++contador == numThreads) return true;
		else return false;
	}
	
}
package Pasarela;

public class Persona extends Thread{
	
	// .. Caracteristicas 
	
	public int direccion;
	public static Psarela desfile;
	
	// .. Constructor
	
	public Persona(int pDireccion) {
		this.direccion = pDireccion;
	}
	
	// .. RUN
	
	public void run() {
		
		desfile.entrar(this.direccion);
		desfile.caminar();
		desfile.salir(this.direccion);
		
	}
	
	// .. Main 
	
	public static void main(String[] args) {
		
		desfile = new Psarela();
		
		for (int i = 0; i < 2; i++)
			new Persona( i % 2 ).start();
		
	}
	
	
}

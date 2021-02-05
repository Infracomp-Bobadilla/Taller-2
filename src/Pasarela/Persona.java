package Pasarela;

public class Persona extends Thread{
	
	// .. Caracteristicas 
	
	public int direccion;
	public static Psarela desfile;
	
	// .. Constructor
	
	public Persona() {
		this.direccion = (int)(Math.random()*2);
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
		
		for (int i = 0; i < 10; i++) 
			new Persona().start();
		
	}
	
	
}

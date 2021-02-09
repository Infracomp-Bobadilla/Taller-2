package Pasarela;

public class Psarela {

	// .......................................... Contadores de cada direcci�n

	public static int derchaIzquierda = 0;
	public static int izquierdaDerecha = 0;

	// .......................................... Entran al sistema

	public synchronized void entrar(int direccion) {

		// ........................... �Cu�l direcci�n llego?

		// .. 0 = Izquierda a Derecha	

		if(direccion == 0) {

			System.out.println("Voy a caminar de Izquierda a Derecha");

			// ........................... �Puede caminar?

			// .. NO 

			while(derchaIzquierda != 0) {
				try {
					System.out.println("Me toco esperar porque hay de Derecha a Izquierda.");
					wait();
				} 
				catch (InterruptedException e) {}
			}

			// ..S�
			System.out.println("Caminado de Izquierda a Derecha");
			izquierdaDerecha++;

		}

		// .. 1 = Derecha a Izquierda

		else {

			System.out.println("Voy a caminar de Derecha a Izquierda");

			// ........................... �Puede caminar?

			// .. NO 

			while(izquierdaDerecha != 0) {
				try {
					System.out.println("Me toco esperar porque hay de Izquierda a Derecha.");
					wait();
				} 
				catch (InterruptedException e) {}
			}

			// ..S�
			System.out.println("Caminado de Derecha a Izquierda");
			derchaIzquierda++;

		}

	}

	public synchronized void caminar() {
		try {
			System.out.println("Caminando ando");
			Thread.sleep(20);
		} 
		catch (InterruptedException e) {}
	}

	public synchronized void salir(int dirrecion) {
		// El código está bien. Te habia dejado algunos mensajes al inicio, ignoralos es que
		// con los mensajes de consola que tienes es un poco confuso para depurar.
		// Cambie un poco el código para colocar un caso mas sencillo de ver si funciona bien el proceso.

		if(dirrecion == 1) {
			if(--derchaIzquierda == 0) {
				System.out.println("Libre caminar, no hay Derecha a Izquierda \n -------------");
				notifyAll();
			}
			else {
				System.out.println("Saliendo de caminar en el sentido Derecha Izquierda");
			}
		}
		else {
			if(--izquierdaDerecha == 0 ) {
				System.out.println("Libre caminar, no hay Izquierda a Derecha \n -------------");
				notifyAll();
			}
			else {
				System.out.println("Saliendo de caminar en el sentido Izquierda Derecha");
			}
		}
	}
}

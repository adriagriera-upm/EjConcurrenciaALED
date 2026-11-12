package ej5;

public class Filosofo extends Thread{
	
	String nombre;
	Cubierto izquierdo;
	Cubierto derecho;

	
	public Filosofo(String nombre, Cubierto izquierdo, Cubierto derecho) {
		
		this.nombre = nombre;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
		
	}
	
	public synchronized void come() {
		
		try {
			if(derecho.cogerCubierto()) {
				Thread.sleep(200);
				
					if(izquierdo.cogerCubierto()) {
						System.out.println(nombre + " está comiendo");
						Thread.sleep(1000);
						System.out.println(nombre + " ha terminado de comer");
						izquierdo.soltarCubierto();
						derecho.soltarCubierto();
					}
					else {
					derecho.soltarCubierto();
					System.out.println(nombre + " se muere de hambre");
				}
			} 
		} catch(InterruptedException e){
			return;
		}
	}
		
	
		
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			this.come();
		}
		
	}
	
}

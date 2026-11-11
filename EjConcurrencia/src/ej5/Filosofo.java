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
		
		while(!(derecho.libre && izquierdo.libre)) {
			
			try {
				System.out.println(this.nombre + " se muere de hambre");
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
			
		System.out.println(this.nombre + " procede a comer");
		try {
			derecho.setLibre(false);
			izquierdo.setLibre(false);
			Thread.sleep(1000);
			derecho.setLibre(true);
			izquierdo.setLibre(true);
			System.out.println(this.nombre + " ha terminado de comer");
			notifyAll();
			} catch (InterruptedException e) {
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

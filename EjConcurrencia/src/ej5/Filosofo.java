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
		
	
		if(derecho.libre) {
			derecho.setLibre(false);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				return;
			}
			if(izquierdo.libre) {
				izquierdo.setLibre(false);
				System.out.println(nombre + "procede a comer");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					return;
				}
				
			} else {
				int i = 0;
				while(i < 11) {
					try {
						wait();
					} catch (InterruptedException e) {
						return;
					}
					System.out.println(nombre + " se muere de hambre");
					i++;
				}
			}
		}
		
			 
	}
		
	
		
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			this.come();
		}
		
	}
	
}

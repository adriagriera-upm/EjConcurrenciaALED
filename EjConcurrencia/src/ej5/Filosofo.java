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
	
	public Cubierto[] OrdenCubiertos() {
		
		Cubierto[] cubiertos = new Cubierto[2];
		
		int pos1 = (int) Math.round(Math.random());
		int pos2 = 1 - pos1;
		
		cubiertos[pos1] = izquierdo;
		cubiertos[pos2] = derecho;
		
		return cubiertos;
		
	}
	
	public synchronized void come() {
		
		Cubierto[] cubiertos = OrdenCubiertos();
		
		
		try {
			if(cubiertos[0].cogerCubierto()) {
					Thread.sleep(200);
					if(cubiertos[1].cogerCubierto()) {
						System.out.println(nombre + " está comiendo");
						Thread.sleep(1000);
						System.out.println(nombre + " ha terminado de comer");
						cubiertos[1].soltarCubierto();
						cubiertos[0].soltarCubierto();
					}
					else {
					cubiertos[0].soltarCubierto();
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

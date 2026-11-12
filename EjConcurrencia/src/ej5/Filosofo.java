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
	
	public int come() {
		
		int comidas = 0;
		
		try {
			
			if(izquierdo.libre && derecho.libre) {
				izquierdo.cogerCubierto();
				derecho.cogerCubierto();
				System.out.println(nombre + " procede a comer");
				Thread.sleep(1000);
				System.out.println(nombre + " ha terminado de comer");
				comidas++;
				izquierdo.soltarCubierto();
				derecho.soltarCubierto();
			}
			else {
				izquierdo.soltarCubierto();
				derecho.soltarCubierto();
				System.out.println(nombre + " piensa con hambre");
			}
		} catch(InterruptedException e){
			Thread.currentThread().interrupt();;
		}
		return comidas;
	}
		
	
		
	@Override
	public void run() {
		int comidas = 0;
		
		for (int i = 0; i < 100; i++) {
			comidas += this.come();
		}
		System.out.println(nombre + " ha comido " + comidas + " veces");
	}
	
}
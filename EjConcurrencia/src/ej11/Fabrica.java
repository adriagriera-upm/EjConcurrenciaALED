package ej11;

public class Fabrica {
	
	int rojas;
	int azules;
	final int CAP = 50;
		
	public synchronized void producirRoja() {
		
		try {
			synchronized(this) {
				while(rojas >= CAP) {
					System.out.println();
					wait();
					System.out.println("La línea roja espera porque ya está su cesta llena");
				}
				rojas++;
				System.out.println("<<Producción de la pieza roja realizada!! Número de piezas totales -> Rojas:" + rojas + "; Azules: " + azules);
				}
			Thread.sleep(200);
			notifyAll();
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public synchronized void producirAzul() {
		
		try {
			synchronized(this) {
				while(azules >= CAP) {
					System.out.println();
					wait();
					System.out.println("La línea azul espera porque ya está su cesta llena");
				}
				azules++;
				System.out.println("<<Producción de la pieza azul realizada!! Número de piezas totales -> Rojas:" + rojas + "; Azules: " + azules);
			}
			Thread.sleep(200);
			notifyAll();
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
		
	
	public void generarPedido() {
		
		try {
			int numRojas = (int) (2 + Math.random()*20);
			int numAzules = (int) (2 + Math.random()*20);
			synchronized(this) {
				
				System.out.println(">>Se genera un pedido de ->  Rojas: " + numRojas + "; Azules: " + numAzules);
			
			
				while(numRojas > rojas || numAzules > azules) {
					System.out.println(">>El pedido espera por faltar piezas");
					wait();
				}
				
				rojas -= numRojas;
				azules -= numAzules;
				System.out.println(">>Pedido realizado! Número de piezas totales -> Rojas:" + rojas + "; Azules: " + azules);
				notifyAll();
			}
				
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
		
}
	



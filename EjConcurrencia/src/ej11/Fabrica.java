package ej11;

public class Fabrica {
	
	int rojas;
	int azules;
	final int CAP = 50;
	
	public synchronized void producirRoja() {
		
		try {
			while(rojas >= CAP) {
				System.out.println();
				wait();
			}
			rojas++;
			System.out.println("<<Producción de la pieza roja realizada!! Número de piezas totales -> Rojas:" + rojas + "; Azules: " + azules);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public synchronized void producirAzul() {
		
		try {
			while(azules >= CAP) {
				System.out.println();
				wait();
			}
			azules++;
			System.out.println("<<Producción de la pieza azul realizada!! Número de piezas totales -> Rojas:" + rojas + "; Azules: " + azules);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
		
	
	public synchronized void generarPedido() {
		
		int numRojas = (int) Math.random()*20;
		int numAzules = (int) Math.random()*20;
		
		System.out.println(">>Se genera un pedido de ->  Rojas: " + numRojas + "; Azules: " + numAzules);
		
		try {
			while(numRojas > rojas && numAzules > azules) {
				System.out.println(">>El pedido espera por faltar piezas");
				wait();
			}
			
			rojas -= numRojas;
			azules -= azules;
			System.out.println(">>Pedido realizado! Número de piezas totales -> Rojas:" + rojas + "; Azules: " + azules);
			
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
		
}
	



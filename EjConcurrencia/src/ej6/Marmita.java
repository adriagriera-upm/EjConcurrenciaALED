package ej6;

import java.util.LinkedList;
import java.util.Queue;


public class Marmita { //MONITOR
	
	int raciones;
	Object orden;
	boolean hayOrden;
	Queue colaCanibales = new LinkedList<Canibal>();
	
	public Marmita() {
		this.raciones = 0; 
		this.hayOrden = false;
	}
	
	
	public synchronized void comer(Canibal can) {
		
		try {
			colaCanibales.add(can);
			while(raciones < 1 || colaCanibales.peek() != can) {
				if(!hayOrden) {
					System.out.println("'¡¡COCINERO COCINA  O TE COMO!!': dice el caníbal " + can.nombre);
					hayOrden = true;
					notifyAll();
					Thread.sleep(1000);
				}
				wait();
			}
			System.out.println("El caníbal " + can.nombre + " procede a comer...");
			Thread.sleep(Math.round(1000 + Math.random()*2000)); 
			raciones--;
			System.out.println("El caníbal " + can.nombre + " ha comido el estofado");
			colaCanibales.poll();
			hayOrden = false;
			notifyAll();
			
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
	}
	
	
	public synchronized void rellenar() {
		
		try {
			
			while(!(hayOrden && raciones <= 0)) {
				wait();
			}
			System.out.println("El cocinero cocina temiendo por su vida...");
			Thread.sleep((int) (5000 + Math.random()*2000));
			System.out.println("El cocinero ya ha cocinado un estofado");
			raciones++;
			notifyAll();
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

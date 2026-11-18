package ej9;

import java.util.LinkedList;
import java.util.Queue;

public class Hacienda {
	
	Queue<Ciudadano> fila1;
	Queue<Ciudadano> fila2;
	boolean siesta = false;
	
	
	public Hacienda() {
		this.fila1 = new LinkedList<Ciudadano>();
		this.fila2 = new LinkedList<Ciudadano>();
	}
	
	public void atenderCiudadano(Funcionario f) {
		
		
		try {
			synchronized(this) {
			
				while(fila1.size() == 0 && fila2.size() == 0) {
					System.out.println("Como no hay nadie esperando, " +  f.nombre + " se echa una siesta.");
					siesta = true;
					wait();
				}
				siesta = false;
			
				if(fila1.size() >= fila2.size()) {
					
					System.out.println("Andrés atiende al ciudadano " + fila1.peek().nombre + " de la fila 1");
					fila1.remove();
					
				} else {
					
					System.out.println("Andrés atiende al ciudadano " + fila2.peek().nombre + " de la ventanilla 2");
					fila2.remove();
					
				}
			}
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	
	
	
	public void esperarVentanilla1(Ciudadano c){
		
		synchronized(this) {
			fila1.add(c);
			
			if(siesta) {
				System.out.println("'¡Despierta vago!', grita el ciudadano " + c.nombre + " esperando en la ventanilla 1" );
				notifyAll(); //Llama al vago del funcionario
			}
		}
		
	}
	
	public void esperarVentanilla2(Ciudadano c){
		
		synchronized(this) {
			fila2.add(c);
			
			if(siesta) {
				System.out.println("'¡Despierta vago!', grita el ciudadano " + c.nombre + " esperando en la ventanilla 1" );
				notifyAll(); //Llama al vago del funcionario
			}
		}
		
	}
}

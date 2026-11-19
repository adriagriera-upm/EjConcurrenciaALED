package ej13;

import java.util.LinkedList;
import java.util.Queue;

public class Peluqueria {

	Queue<Cliente> sofas = new LinkedList<Cliente>();
	boolean sillaOcupada = false;
	
	
	void entrarPeluqueria(Cliente c) {
		
		try {
			synchronized(this) {
				
				while(sofas.size() < 5 && sillaOcupada) {
					if(!sofas.contains(c)) {
					sofas.add(c);
					System.out.println(c.nombre + " espera en un sofá");
					}
					wait();
				}
				
				if(sofas.size() >= 5 && sillaOcupada) {
					System.out.println(c.nombre + " se va decepcionado");
					return;
				} if(!sillaOcupada) {
					if(sofas.contains(c)) {
						sofas.remove();
						notifyAll();
					}
					System.out.println(c.nombre + " va a recibir el mejor corte de pelo de su vida");
					sillaOcupada = true;
				}
				
			}
			int random =(int) (Math.random()*400);
			Thread.sleep( random);
			
			synchronized(this) {
			
				System.out.println("A " + c.nombre + " le he encantado!");
				sillaOcupada = false;
				notifyAll();
			
			
			}
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}

	
}

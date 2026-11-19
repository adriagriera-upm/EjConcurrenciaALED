package ej14;

import java.util.LinkedList;
import java.util.Queue;

public class Peluqueria {

	Queue<Cliente> sofas = new LinkedList<Cliente>();
	Queue<Cliente> barra = new LinkedList<Cliente>();
	boolean sillaOcupada = false;
	
	
	void entrarPeluqueria(Cliente c) {
		
		try {
			synchronized(this) {
				
				while((sofas.size() < 5 || barra.size() < 15) && sillaOcupada) {
					if(sofas.size()< 5 && !sofas.contains(c)) {
						sofas.add(c);
						System.out.println(c.nombre + " espera en un sofá");
						if(barra.contains(c)) {
							System.out.println(c.nombre + "estaba en la barra y se ha movido al sofá");
							barra.remove();
						}
					} else if(sofas.size() >= 5 && !sofas.contains(c) && !barra.contains(c)) {
						barra.add(c);
						System.out.println(c.nombre + " espera en la barra");
					}
					wait();
				}
				
				
				if(barra.size() >= 15 && sofas.size() >= 5 && sillaOcupada) {
					System.out.println(c.nombre + " se va decepcionado");
					return;
					
				}
				
				if(!sillaOcupada) {
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
	
	void recibirCorte(Cliente c) {
		
		try {
			synchronized(this) {
				
				
					System.out.println(c.nombre + " va a recibir el mejor corte de pelo de su vida");
					sillaOcupada = true;
			}
				
			int random =(int) (Math.random()*400);
			Thread.sleep(random);
			
			synchronized(this) {
				sillaOcupada = false;
				System.out.println("A " + c.nombre + " le he encantado!");
				notifyAll();
			}
			
				
				
		}catch(InterruptedException e ) {
			Thread.currentThread().interrupt();
		}
	}
			
		
}

	


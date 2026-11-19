package ej12;

import java.util.LinkedList;
import java.util.Queue;

public class GestorMuseo {
	
	Queue<Thread> cola = new LinkedList<Thread>();
	Queue<Thread> colaJubilados = new LinkedList<Thread>();
	int aforo = 50;
	int dentro = 0;
	int temperaturaAnterior;
	
	
	
	// Se invoca cuando una persona quiere entrar en el museo.
	void entrarSala() {
		
		try{
			synchronized(this) {
				Thread yo = Thread.currentThread();
				cola.add(yo);
				while(cola.peek() != yo || dentro >= aforo || colaJubilados.size() > 0) {
					if(!cola.contains(yo)) {
						cola.add(yo);
						System.out.println(yo.getName() + " espera...");
					}
					wait();
				}
				cola.remove();
				dentro++;
				System.out.println(yo.getName() + " entra al museo");	
			}
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	// Se invoca cuando una persona jubilada quiere entrar en el museo.
	void entrarSalaJubilado() {
		
		try{
			synchronized(this) {
				Thread yo = Thread.currentThread();
				colaJubilados.add(yo);
				boolean esperando = false;
				while(dentro >= aforo || colaJubilados.peek() != yo) {
					if(!esperando) {
						esperando = true;
						System.out.println(yo.getName() + " (jubilado) entra al museo");
					}
					wait();
				}
				colaJubilados.remove();
				dentro++;
				System.out.println(yo.getName() + " entra al museo");
				}
			} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}
	
	// Se invoca cuando una persona, jubilada o no, quiere salir del museo.
	void salirSala() {
		
		synchronized(this) {
			Thread yo = Thread.currentThread();
			dentro--;				
			System.out.println(yo.getName() + " sale del museo");
		}
		
	} 
	
	// Lo invoca la hebra que mide la temperatura indicar el último valor medido.
	void notificarTemperatura(int temperatura) {
		
		synchronized(this) {
			
			if(temperatura > 30) {
				aforo = 35;
				if(temperaturaAnterior < temperatura) {
					System.out.println("AFORO REDUCIDO!! (TEMPERATURA: " + temperatura + ")");
				}
				
			} else {
				aforo = 50;
				if(temperaturaAnterior > temperatura) {
					System.out.println("AFORO AMPLIADO!! (TEMPERATURA: " + temperatura + ")");
				}
			}
			temperaturaAnterior = temperatura;
		}
		
		
		
	}
		
	

}
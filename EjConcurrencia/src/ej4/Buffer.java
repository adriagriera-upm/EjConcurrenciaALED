package ej4;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
	Queue<Integer> buffer = new LinkedList<>();
	
	public synchronized void llenarBuffer(String nombreProductora) {
		
		try {
			while(buffer.size() >= 10) {
			
				wait();
				System.out.println("La productora " + nombreProductora + " sigue esperando porque el dato sigue lleno.");
				
			}
		
		int rand = (int) (Math.random()*10000);
		System.out.println("Añadiendo valor " + rand + " al buffer (productora: " + nombreProductora + ")");
		buffer.offer(rand);
		notifyAll();
		} catch (InterruptedException e){
			return;
		}
	}
	
	public synchronized void leerBuffer(String nombreConsumidora) {
		
		try {
		while(buffer.size() == 0) {
			
				wait();
				System.out.println("La consumidora " + nombreConsumidora + " sigue esperando porque el buffer sigue vacío.");
			
			}
			System.out.println(nombreConsumidora + "está vaciando eliminando el valor: " + buffer.peek());
			buffer.poll();
			notifyAll();
		} catch (InterruptedException e) {
			return;
			}
	}
	

}

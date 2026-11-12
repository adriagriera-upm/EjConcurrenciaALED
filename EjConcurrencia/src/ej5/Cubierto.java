package ej5;

public class Cubierto {
	
	boolean libre = true;
	
	public synchronized boolean cogerCubierto() throws InterruptedException {
		
		while(!libre) {
			wait();
		}
		
		libre = false;
		return !libre; 
		
	}

	public synchronized void soltarCubierto() {
		libre = true;
		notifyAll();
	}
	
}

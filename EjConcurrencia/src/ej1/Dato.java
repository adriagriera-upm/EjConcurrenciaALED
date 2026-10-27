package ej1;

public class Dato {
	
	private int dato;
	private boolean busy = false;
	
	public Dato(int dato) {
		this.dato = dato;
	}
	
	
	public synchronized int getDato() {
		if(busy == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				return -1;
			}
		}
		
		notifyAll();
		return dato;
	}
	
	public synchronized void setDato(int dato) {
		busy = false;
		this.dato = dato;
		notifyAll();
		
	}

	
	
}

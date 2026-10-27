package ej1;

public class Lectora extends Thread{
	
	Dato dato;
	
	public Lectora(Dato dato) {
		
		this.dato=dato;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(dato.getDato());
		}
		
	}
	
	

}

package ej1;

public class  Escritora extends Thread {
	
	Dato dato;
	
	public Escritora(Dato dato) {
		this.dato=dato;
	}

	@Override
	public void run() {
		
		for (int i = 0; i <100; i++) {
			dato.setDato((int) Math.random()*10000);
		}
		
	}
	
	
}

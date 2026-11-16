package ej6;

public class Canibal extends Thread{
	
	Marmita m;
	String nombre;
	
	public Canibal(Marmita m,String nombre) {
		
		this.m = m;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			m.comer(this);
		}
	}
	
	

}

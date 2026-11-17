package ej6_2;

public class Cocinero extends Thread{
	
	String nombre;
	Marmita m;
	
	public Cocinero(Marmita m,String nombre) {
		this.m=m;
		this.nombre = nombre;
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			m.rellenar();
		}
	}

}

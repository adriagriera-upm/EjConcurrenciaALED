package ej9;

public class Ciudadano extends Thread{
	
	Hacienda h;
	String nombre;
	
	public Ciudadano(Hacienda h,String nombre) {
		this.h = h;
		this.nombre=nombre;
	}
	
	@Override
	public void run() {
		
		int random = (int) Math.round(Math.random());
				
		if(random <= 0) {
			h.esperarVentanilla1(this);
		} else {
			h.esperarVentanilla2(this);
		}
		
	}

}

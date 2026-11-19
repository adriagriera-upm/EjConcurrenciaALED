package ej13;


public class Cliente extends Thread{
	
	Peluqueria p;
	String nombre;
	
	public Cliente(Peluqueria p, String nombre) {
		
		this.p = p;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		
		
		p.entrarPeluqueria(this);
		
		
	}
	

}

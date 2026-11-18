package ej10;

public class Vehiculo extends Thread{
	
	Seguridad s;
	String nombre;
	int peso;
	boolean ambulancia;
	
	public Vehiculo(Seguridad s, String nombre, int peso, boolean ambulancia) {
		
		this.s = s;
		this.nombre=nombre;
		this.peso = peso;
		this.ambulancia = ambulancia;
	}
	
	@Override
	public void run() {
		
		try {
			s.entrarPuente(this.peso,this.ambulancia);
			Thread.sleep(12000);
			s.salirPuente(this.peso);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}

}

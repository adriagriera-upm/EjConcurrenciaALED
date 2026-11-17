package ej7;

public class Fumeta extends Thread{
	
	MonitorFumeta m;
	int tieneInfinitos; //indica de qué componente tiene infinitos suministros
	String nombre;
	
	
	public Fumeta(MonitorFumeta m, int tieneInfinitos, String nombre) {
		this.m = m;
		this.tieneInfinitos=tieneInfinitos;
		this.nombre=nombre;
	
	}
	
	@Override
	public void run() {
		while(true) {
			m.fumar(this);
		}
	}

}

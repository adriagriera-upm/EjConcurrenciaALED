package ej1;

public class Lectora extends Thread{
	
	Dato dato;
	String nombreLectora;
	
	public Lectora(Dato dato, String nombreLectora) {
		this.nombreLectora=nombreLectora;
		this.dato=dato;
	}
	
	@Override
	public void run() {
		
		try {
			dato.leerDato(nombreLectora);
		} catch (InterruptedException e) {
			
		}
		
	}
	
	

}

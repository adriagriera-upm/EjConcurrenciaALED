package ej2;

public class Lectora extends Thread{
	
	Datos datos;
	String nombreLectora;
	
	public Lectora(Datos datos, String nombreLectora) {
		this.nombreLectora=nombreLectora;
		this.datos=datos;
	}
	
	@Override
	public void run() {
		
		try {
			datos.leerDato(nombreLectora);
		} catch (InterruptedException e) {
			
		}
		
	}
	
	

}

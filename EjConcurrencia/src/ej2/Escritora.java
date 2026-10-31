package ej2;

public class  Escritora extends Thread {
	
	Datos datos;
	String nombreEscritora;
	
	public Escritora(Datos datos, String nombreEscritora) {
		this.datos=datos;
		this.nombreEscritora=nombreEscritora;
	}

	@Override
	public void run() {
		try {
			datos.escribirDato(nombreEscritora);
		} catch (InterruptedException e) {
		}
	}
	
	
}

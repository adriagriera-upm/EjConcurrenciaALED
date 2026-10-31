package ej1;

public class  Escritora extends Thread {
	
	Dato dato;
	String nombreEscritora;
	
	public Escritora(Dato dato, String nombreEscritora) {
		this.dato=dato;
		this.nombreEscritora=nombreEscritora;
	}

	@Override
	public void run() {
		try {
			dato.escribirDato(nombreEscritora);
		} catch (InterruptedException e) {
		}
	}
	
	
}

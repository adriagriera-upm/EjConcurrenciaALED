package ej4;

public class Productora extends Thread{

	
	String nombreProductora;
	Buffer b;
	
	public Productora(String  nombreProductora, Buffer b) {
		this.nombreProductora=nombreProductora;
		this.b=b;
	}
	@Override
	public void run() {
		for(int i=0; i<100;i++) {
		b.llenarBuffer(nombreProductora);
		}
	}
}

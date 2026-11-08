package ej4;

public class Consumidora extends Thread{
	
	String nombreConsumidora;
	Buffer b;
	
	public Consumidora(String  nombreConsumidora, Buffer b) {
		this.nombreConsumidora=nombreConsumidora;
		this.b=b;
	}

	@Override
	public void run() {
		
		b.leerBuffer(nombreConsumidora);
	
	}
}

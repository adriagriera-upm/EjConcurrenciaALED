package ej12;


// Hebra que mide periódicamente la temperatura y se la notifica al gestor del museo.
public class MedidorTemp extends Thread {

	private final GestorMuseo museo;
	private int temperatura = 28;

	public MedidorTemp(GestorMuseo museo) {
		this.museo = museo;
	}

	@Override
	public void run() {
		try {
			while (true) {
				
				temperatura = (int) (20 + Math.random()*20);

				museo.notificarTemperatura(temperatura);

				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
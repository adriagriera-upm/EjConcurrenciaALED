package ej6;



public class Marmita { //MONITOR

	int raciones = 0;
	boolean hayOrden = false;
	Canibal comensal = null;
	
	
	public  void comer(Canibal can) {
		try {
			synchronized(this) {
				while(comensal != can || raciones == 0) { //La hebra se espera si no hay comida o si no es el que ha pedido comer 
					if(raciones == 0 && !hayOrden) {
						//Se crea una orden de un caníbal si no hay una previa y tampoco hay comida
						comensal = can;
						System.out.println("'¡¡COCINERO COCINA  O TE COMO!!': dice el caníbal " + can.nombre);
						hayOrden = true;
						notifyAll();
					}
					wait();
				}
			}
			comensal = null;
			System.out.println("El caníbal " + can.nombre + " procede a comer...");
			Thread.sleep(Math.round(1000 + Math.random()*2000)); 
			synchronized(this) {
			comensal = null;
			raciones--;
			System.out.println("El caníbal " + can.nombre + " ha comido el estofado");
			hayOrden = false;
			notifyAll();
			}
		} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
		}
	}
	
	
	public synchronized void rellenar() {
		
		try {
			while(!(hayOrden && raciones <= 0)) {
				wait();
			}
			System.out.println("El cocinero cocina temiendo por su vida...");
			Thread.sleep((int) (5000 + Math.random()*2000));
			System.out.println("El cocinero ya ha cocinado un estofado (sobrevive por ahora)");
			raciones++;
			notifyAll();
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

package ej6_2;



public class Marmita { //MONITOR

	int raciones = 0;
	boolean hayOrden = false;
	Canibal comensal = null;
	final int CAPACIDAD_MAX = 10;
	
	
	public void comer(Canibal can) {
		try {
			synchronized(this) {
				while((comensal != null && comensal != can) || raciones <= 0) { //La hebra se espera si no hay comida y si no es el que ha pedido comer (antes de que este coma) 
					if(raciones == 0 && !hayOrden) {
						//Se crea una orden de un caníbal si no hay una previa y tampoco hay comida
						comensal = can;
						System.out.println("'¡¡COCINERO COCINA  O TE COMO!!': dice el caníbal " + can.nombre);
						hayOrden = true;
						notifyAll();
					}
					wait();
				}
			//Se elimina al primer comensal para que puedan comer luego los otros caníbales
			}
			synchronized(this) {
				if(comensal == can) {
					comensal = null;
					hayOrden = false;
				}
				raciones--;
				hayOrden = false;
				notifyAll();
			}
			System.out.println("El caníbal " + can.nombre + " procede a comer...");
			Thread.sleep(Math.round(1000 + Math.random()*2000));
			System.out.println("El caníbal " + can.nombre + " ha comido el estofado");
			
		} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
		}
	}
	
	
	public void rellenar() {
		
		try {
			synchronized(this) {
				while(!(hayOrden && raciones <= 0)) {
					wait();
				}
			}
			System.out.println("El cocinero cocina temiendo por su vida...");
			Thread.sleep((int) (5000 + Math.random()*2000));
			System.out.println("El cocinero ya ha cocinado mucho estofado (sobrevive por ahora)");
			synchronized(this) {
				raciones = CAPACIDAD_MAX;
				notifyAll();
			}
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

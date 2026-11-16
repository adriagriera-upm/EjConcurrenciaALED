package ej6;

public class Marmita { //MONITOR
	
	int raciones;
	Object orden;
	
	public Marmita() {
		raciones = (int) Math.round(Math.random()*4); //El número de raciones inicial es entre 0 y 4
	}
	
	
	public synchronized void comer(Canibal can) {
		
		try {
			while(raciones < 1) {
				wait();
				notifyAll(); //Se avisa al cocinero (como no se puede avisar una hebra individual se avisan a todas
				System.out.println("'¡¡COCINERO COCINA  O TE COMO!!': dice el caníbal " + can.nombre);
			}	
			System.out.println("El caníbal " + can.nombre + " procede a comer...");
			Thread.sleep(Math.round(1000 + Math.random()*2000)); 
			raciones--;
			System.out.println("El caníbal " + can.nombre + " ha comido el estofado");
			notifyAll();
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		
	}
	
	
	public  synchronized void rellenar() {
		
		try {
			notifyAll();
			wait();
			if(raciones < 1) {
			System.out.println("El cocinero procede a preparar un nuevo estofado para no acabar siendo él parte del estofado...");
			Thread.sleep(Math.round(5000 + Math.random()*7000));
			raciones++;
			System.out.println("El cocinero ha terminado de cocinar un estofado");
			notify(); 
			
			}
			
		
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

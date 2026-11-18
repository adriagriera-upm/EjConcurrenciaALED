package ej10;





public class Seguridad {
	
	final int LIMITE_PESO=15000;
	final int LIMITE_VEHICULOS=10;
	int pesoActual = 0;
	int vehiculosActual = 0;
	int esperaAmbulancias;
	
	
	void entrarPuente (int peso, boolean ambulancia) {
		
		try {
			synchronized(this) {
				//Mientras el peso o la cantidad total con el vehículo deque quiere pasar supere el límite y haya ambulancias esperando 
				//y este vehículo no es una ambulancia, se espera
				while((peso + pesoActual > LIMITE_PESO || (vehiculosActual+1) > LIMITE_VEHICULOS) && (esperaAmbulancias != 0 && !ambulancia)){
					if(ambulancia) {
						esperaAmbulancias++;
						System.out.println("Una ambulancia está esperando...");
					}
					wait();
				}
				pesoActual += peso;
				vehiculosActual++;
				if(!ambulancia) {
					System.out.println("Pasa un vehículo... -> Peso: " + pesoActual + "; Vehículos: " + vehiculosActual);
				} else if(ambulancia) {
					System.out.println("Pasa una ambulancia... -> Peso: " + pesoActual + "; Vehículos: " + vehiculosActual);
					esperaAmbulancias--;
					notifyAll();
				}
			}
		} catch(InterruptedException e) {
			
		}
	}
	
	
	

	void salirPuente (int peso) {
		
		synchronized(this) {
			
			System.out.println("Un vehículo sale del puente");
			pesoActual -= 	peso;
			vehiculosActual--;
			notifyAll();
		}
	}
	
}

package ej10;

import java.util.LinkedList;
import java.util.Queue;



public class Seguridad {
	
	final int LIMITE_PESO=15000;
	final int LIMITE_VEHICULOS=10;
	int pesoActual = 0;
	int vehiculosActual = 0;
	int esperaAmbulancias;
	
	
	void entrarPuente (int peso, boolean ambulancia) {
		
		try {
			synchronized(this) {
				while(peso + pesoActual > LIMITE_PESO || (vehiculosActual+1) > LIMITE_VEHICULOS || (esperaAmbulancias == 0 && !ambulancia)){
					if(ambulancia) {
						esperaAmbulancias++;
						System.out.println("Una ambulancia está esperando...");
					}
					wait();
				}
				pesoActual += peso;
				vehiculosActual++;
				if(!ambulancia) {
					System.out.println("Pasa un vehículo... -> Peso: " + pesoActual + "; Vehículos ");
				} else {
					System.out.println("Pasa una ambulancia...");
					esperaAmbulancias--;
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

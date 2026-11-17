package ej7;



public class MonitorFumeta {
	
	boolean[] componentes = new boolean[3];
	
	
	public void fumar(Fumeta f) {
		
		try {
			synchronized(this) {
				while(!puedeFumar(f)) {
					wait();
				}
			System.out.println("El fumeta " + f.nombre + " procede a fumar...");
			switch(f.tieneInfinitos) {
				case 0:
					componentes[1] = false;
					componentes[2] = false;
				
				case 1:
					componentes[0] = false;
					componentes[2] = false;
				
				case 2:
					componentes[0] = false;
					componentes[1] = false;
				}
			}	
			Thread.sleep(2000);
			
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	
	public synchronized void darComponentes() {
		
		try {	
			while(sumaComponentes() >= 2) { //mientras haya al menos dos componentes 
					wait();
			}
		
		int primero = (int) Math.round(Math.random()*2);
		int segundo = 0;
		
		switch(primero) {
			
		case 0:
			segundo = (int) (Math.round(Math.random()) + 1);
		
		case 1:
			segundo = (int) (Math.round(Math.random())*2);
		
		case 2:
			segundo = (int) Math.round(Math.random());
		}
		componentes[primero] = true;
		componentes[segundo] = true;
		System.out.println("El del estanco ya ha recargado los suministros->");
		System.out.println("Tabaco: " + componentes[0] + "; Papel: " + componentes[1] + "");
		notifyAll();
		
		
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public int sumaComponentes() {
		
		int hay = 0;
		
		for (int i = 0; i < componentes.length; i++) {
			if(componentes[i]) {
				hay++;
			}
		}
		
		return hay;
	}
	
	public boolean puedeFumar(Fumeta f) {
		boolean puede = true;;
		switch(f.tieneInfinitos) {
		case 0:
			if(!(componentes[1] && componentes[2])){
				puede = false;
			}
		case 1:
			if(!(componentes[0] && componentes[2])){
				return false;
			} 
		case 2:
			if(!(componentes[1] && componentes[0])){
				return false;
			}
		}
		return puede;
	}
}

package ej8;



public class MonitorFumeta {
	
	boolean[] componentes = new boolean[3];
	String[] nombreComponentes = {"Tabaco","Papel","Cerilla"};
	Fumeta solicitante = null;
	boolean yaCogido = false;
	
	public void fumar(Fumeta fumeta) {
		
		try {
			synchronized(this) {
					while(!puedeFumar(fumeta)) {
						int libre = componenteLibre();
						if(libre != -1 && libre != fumeta.tieneInfinitos && !yaCogido) {
							yaCogido = true;
							solicitante = fumeta;
							System.out.println(fumeta.nombre + " ha cogido el componente libre");
							System.out.println(fumeta.nombre + " pide generosidad");
							notifyAll();
						}
						
						if(solicitante != null && solicitante != fumeta && fumeta.tieneInfinitos == componenteSolicitado(solicitante)) {
							System.out.println("El fumeta " + fumeta.nombre + " es muy generoso y le da el componente: " + nombreComponentes[fumeta.tieneInfinitos]);
							componentes[fumeta.tieneInfinitos] = true;
							solicitante = null;
							notifyAll();
						}
						wait();
					}
				System.out.println("El fumeta " + fumeta.nombre + " procede a fumar");
				yaCogido = false;
				switch(fumeta.tieneInfinitos) {
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
				notifyAll();
			}	
			Thread.sleep(2000); //Si está pegando una calada no puede compartir, ya está ocupado con lo suyo
			System.out.println("El fumeta " + fumeta.nombre + " ha parado de fumar");
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public synchronized void darComponentes() {
		
		try {	
			while(sumaComponentes() == 1) { //mientras haya al menos una componentes 
					wait();
			}
		
			int componente = (int) Math.round(Math.random()*2);
			
			componentes[componente] = true;
			System.out.println("El del estanco ya ha recargado los suministros:");
			System.out.println("Tabaco-> " + componentes[0] + "; Papel-> " + componentes[1] + "; Cerilla-> " + componentes[2]);
			notifyAll();
			
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	private int componenteSolicitado(Fumeta f) {
		
		int c = -1;
		for (int i = 0; i < componentes.length; i++) {
			if(!componentes[i] && f.tieneInfinitos != i) {
				c = i;
				break;
			}
		}
		return c;
	}

	private int componenteLibre() {
		
		int pos = -1;
		for (int i = 0; i < componentes.length; i++) {
			if(componentes[i]) {
				pos = i;
				break;
			}
		}
		return pos;
	}
	
	private int sumaComponentes() {
		
		int hay = 0;
		for (int i = 0; i < componentes.length; i++) {
			if(componentes[i]) {
				hay++;
			}
		}
		return hay;
	}
	
	private boolean puedeFumar(Fumeta f) {
	    switch (f.tieneInfinitos) {
	        case 0: return componentes[1] && componentes[2];
	        case 1: return componentes[0] && componentes[2];
	        case 2: return componentes[0] && componentes[1];
	        default: return false;
	    }
	}
	
	
	
	
}

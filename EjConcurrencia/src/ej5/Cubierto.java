package ej5;

public class Cubierto {
	
	boolean libre = true;
	
	public boolean cogerCubierto() {
		
		if(libre) {
			libre = false;
			return true;
		}
		return false;
	}

	public void soltarCubierto() {
		libre = true;
	}
	
}

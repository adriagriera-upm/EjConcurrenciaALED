package ej9;

public class Funcionario extends Thread{
	
	Hacienda h;
	String nombre = "Andrés Trozado";
	
	public Funcionario(Hacienda h) {
		this.h = h;
	}

	@Override
	public void run() {
		
		while(true) {
			h.atenderCiudadano(this);
		}
		
	}
}

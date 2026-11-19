package ej12;

public class Persona extends Thread {

	private final GestorMuseo museo;
	private final boolean jubilado;


	public Persona(GestorMuseo museo, boolean jubilado) {
		this.museo = museo;
		this.jubilado = jubilado;
	}

	@Override
	public void run() {
		try {

			if (jubilado) {
				museo.entrarSalaJubilado();
			} else {
				museo.entrarSala();				
			}
		
			// Tiempo que pasa dentro del museo
			Thread.sleep(5000 + ((int) Math.random()*5000));
			museo.salirSala();
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}


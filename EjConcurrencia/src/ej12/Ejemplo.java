package ej12;


public class Ejemplo {

	public static void main(String[] args) throws InterruptedException {

		GestorMuseo museo = new GestorMuseo();

		MedidorTemp medidor = new MedidorTemp(museo);
		medidor.start();
		
		while(true) {
			
			boolean jubilado = Math.random() <= 0.15 ;
			
			Persona p = new Persona(museo,jubilado);
			p.start();
			
			Thread.sleep(50);
			
		}
		
	}
}

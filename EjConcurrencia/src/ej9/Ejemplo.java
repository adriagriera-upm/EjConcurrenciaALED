package ej9;



public class Ejemplo {
	
	public static void main(String[] args) {
		
		Hacienda h = new Hacienda();
		
		Funcionario f = new Funcionario(h);
		
		f.start();
		
		int i = 0;
		while(true) {
			Ciudadano c = new Ciudadano(h,"c" + i);
			c.start();
			try {
				Thread.sleep(1000 + ((int) Math.random()*3000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			i++;
			
		}
		
	}

}

package ej10;

public class Puente {
	
	public static void main(String[] args) {
		
		Seguridad s = new Seguridad();
		
		int i = 0;
		while(true) {
			
			boolean ambulancia = false;
			if(i % 7 == 0) {
				ambulancia = true;
			}
			Vehiculo v = new Vehiculo(s,"v" + i,(int) (1500 + Math.round(Math.random()*4000)),ambulancia);
			v.start();	
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		
	}

}

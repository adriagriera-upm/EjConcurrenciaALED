package ej4;



public class Ejemplo {
	
	public static void main(String[] args) {
		
		
		Buffer b = new Buffer();
		
		for(int i = 0; i<Integer.parseInt(args[0]);i++) {
			
			Thread tc = new Consumidora("c" + i,b);
			Thread tp = new Productora("p" + i,b);
			tp.start();
			tc.start();
			
			
		}
		
	}

}

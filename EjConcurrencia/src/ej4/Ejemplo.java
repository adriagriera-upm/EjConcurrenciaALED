package ej4;



public class Ejemplo {
	
	public static void main(String[] args) {
		
		for(int i = 0; i<Integer.parseInt(args[0]);i++) {
			
			Buffer b = new Buffer();
			
			Thread tc = new Consumidora("c" + i,b);
			Thread tp = new Productora("p" + i,b);
			tp.start();
			try {
			Thread.sleep(200);
			tc.start();
			Thread.sleep(200);
			} catch(InterruptedException e){
				return;
			}
		}
		
	}

}

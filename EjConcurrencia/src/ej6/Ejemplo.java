package ej6;

public class Ejemplo {
	
	public static void main(String[] args) {
		
		Marmita m = new Marmita();
		System.out.println("Número inicial de estofados en la mesa: " + m.raciones);
		
		for(int i=0; i<Integer.parseInt(args[0]);i++){
			
			Canibal c = new Canibal(m,"c" + i);
			c.start();
			
			
		}
		
		Cocinero co = new Cocinero(m,"Karlos Arguiñano");
		co.start();
		
		
		
	}

}

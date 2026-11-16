package ej6;

public class Ejemplo {
	
	public static void main(String[] args) {
		
		Marmita m = new Marmita();
		
		for(int i=0; i<Integer.parseInt(args[0]);i++){
			
			Canibal ca = new Canibal(m,"c" + i);
			ca.start();
		}
		Cocinero co = new Cocinero(m,"Karlos Arguiñano");
		co.start();
	}

}

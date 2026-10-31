package ej1;

public class Ejemplo {
	
	//args[0]= número de lectoras y escritoras
	
	public static void main(String[] args) {
		
		Dato d = new Dato(4);
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			
			Thread e = new Escritora(d,"e" + i);
			e.start();
			Thread l = new Lectora(d,"l" + i);
			l.start();
			
		}
		
		
	}

}

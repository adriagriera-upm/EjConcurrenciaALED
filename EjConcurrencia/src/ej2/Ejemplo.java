package ej2;


public class Ejemplo {

public static void main(String[] args) {
		
		Datos d = new Datos();
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			
			Thread e = new Escritora(d,"e" + i);
			e.start();
			Thread l = new Lectora(d,"l" + i);
			l.start();
			
		}
		
		
	}

}
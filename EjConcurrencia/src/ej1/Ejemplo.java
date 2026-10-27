package ej1;

public class Ejemplo {
	
	public static void main(String[] args) {
		
		Dato d = new Dato(4);
		Thread e1 = new Escritora(d);
		Thread l1 = new Lectora(d);
		
		e1.start();
		l1.start();
		
	}

}

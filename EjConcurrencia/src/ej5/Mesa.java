package ej5;

public class Mesa {
	
	public static void main(String[] args) {
		
		
		Cubierto c1 = new Cubierto();
		Cubierto c2 = new Cubierto();
		Cubierto c3 = new Cubierto();
		Cubierto c4 = new Cubierto();
		Cubierto c5 = new Cubierto();
		
		
		Filosofo f1 = new Filosofo("Descartes",c1,c2);
		Filosofo f2 = new Filosofo("Heráclito",c2,c3);
		Filosofo f3 = new Filosofo("Hume",c3,c4);
		Filosofo f4 = new Filosofo("Nietzsche",c4,c5);
		Filosofo f5 = new Filosofo("Zizek",c5,c1);
		
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
		
		
	}

}

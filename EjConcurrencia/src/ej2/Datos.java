package ej2;

public class Datos {
	
	private int[] datos;
	private boolean escribiendo = false;
	
	
	public synchronized void leerDato(String nombreLectora) throws InterruptedException {
		//1. Empieza a leer si ninguna hebra está escribiendo el dato, si no se pone en espera
		iniciarLectura(nombreLectora);
		//2. Selecciona qué dato lee primero y cuál el segundo
		int primero = (int) Math.round(Math.random() * 2);
		int segundo = 3 - primero;
		
		//TODO completar que la lectura y escritura de los dos enteros sea independiente (métodos synchronized separados?)
		
		//3. Termina de leer
		notifyAll();
		System.out.println(nombreLectora + " ha terminado de leer.");
		
	}
	
	public synchronized void iniciarLectura(String nombreLectora) throws InterruptedException{
		
		while(escribiendo) {
			System.out.println("Lectora " + nombreLectora + " en espera.");
			wait();
			
		}
		System.out.println("Lectora " + nombreLectora + " inicia lectura");
	}
	
	public synchronized void escribirDato(String nombreEscritora) throws InterruptedException {
		//1. Empieza a escribir si ninguna hebra está leyendo el dato, si no se pone en espera
		iniciarEscritura(nombreEscritora);
		//2. Selecciona cuál de los dos datos va a escribir
		int escrito = (int) Math.round(Math.random() * 2);
		
		escribiendo = false;
		System.out.println(nombreEscritora + " ha terminado de escribir.");
		notifyAll();
	}


	private void iniciarEscritura(String nombreEscritora) throws InterruptedException {
		while(escribiendo) {
			System.out.println("Lectora " + nombreEscritora + " en espera.");
			wait();
		}
		escribiendo = true;
		System.out.println("Escritora " + nombreEscritora + " inicia escritura");
		
		
	}
}

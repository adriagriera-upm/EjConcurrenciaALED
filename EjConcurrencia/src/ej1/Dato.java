package ej1;

public class Dato {
	
	private int dato;
	private boolean escribiendo = false;
	
	public Dato(int dato) {
		this.dato = dato;
	}
	
	
	public void leerDato(String nombreLectora) throws InterruptedException {
		//1. Empieza a leer si ninguna hebra está escribiendo el dato
		iniciarLectura(nombreLectora);
		//2. Lee el dato
		System.out.println("El dato es: " + dato + ", leído por " + nombreLectora + ".");
		//3. Termina de leer
		notifyAll();
		System.out.println(nombreLectora + " ha terminado de leer.");
		
	}
	
	public synchronized void iniciarLectura(String nombreLectora) throws InterruptedException{
		
		while(escribiendo) {
			wait();
			System.out.println("Lectora " + nombreLectora + " en espera.");
		}
		System.out.println("Lectora " + nombreLectora + " inicia lectura");
	}
	
	public void escribirDato(String nombreEscritora) throws InterruptedException {
		//1. Empieza a escribir si ninguna hebra está leyendo el dato
		iniciarEscritura(nombreEscritora);
		//2. Escribe el dato
		this.dato = (int) (Math.random() * 10000);
		System.out.println("Nuevo valor del dato: " + dato);
		//3. Termina de escribir
		escribiendo = false;
		notifyAll();
		System.out.println(nombreEscritora + " ha terminado de escribir.");
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

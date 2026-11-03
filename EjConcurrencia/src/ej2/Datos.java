package ej2;

public class Datos {
	
	private int[] datos = new int[2];
	private boolean[] escribiendo = {false,false};
	
	
	public synchronized void leerDato(String nombreLectora) throws InterruptedException {
		int primero = (int) (Math.round(Math.random()));
		int segundo = (1 - primero);
		//1. Lee el primer dato y libera el cerrojo
		iniciarLectura(nombreLectora,primero);
		System.out.println("El primero dato leído por la hebra " + nombreLectora + " es el de la posición " + primero + ", con valor: " + datos[primero]);
		notifyAll();
		System.out.println(nombreLectora + " ha terminado de leer su primer dato.");
		
		//2. Lee el segundo dato y libera el cerrojo
		iniciarLectura(nombreLectora,segundo);
		System.out.println("El segundo dato leído por la hebra " + nombreLectora + " es el de la posición " + segundo + ", con valor: " + datos[segundo]);
		notifyAll();
		System.out.println(nombreLectora + " ha terminado de leer su segundo dato.");
		
	}
	
	public synchronized void iniciarLectura(String nombreLectora, int index) throws InterruptedException {
		
		while(escribiendo[index]) {
			System.out.println("Lectora " + nombreLectora + " en espera.");
			wait();
		}
		
		System.out.println("Lectora " + nombreLectora + " inicia lectura del dato de la posición " + index);
		
	}
	
	
	public synchronized void escribirDato(String nombreEscritora) throws InterruptedException {
		
		//1. Selecciona cuál de los dos datos va a escribir e inicia la escriptura de este dato
		int index = (int) (Math.round(Math.random()));
		iniciarEscritura(nombreEscritora,index);
		this.datos[index] = (int) (Math.random()*10000);
		System.out.println("Nuevo valor del dato en la posición " + index + ": " +  datos[index]);
		escribiendo[index] = false;
		//2. Termina de escribir y libera el cerrojo
		System.out.println(nombreEscritora + " ha terminado de escribir " + "en la posición " + index);
		notifyAll();
	}

	private void iniciarEscritura(String nombreEscritora, int index) throws InterruptedException {
		while(escribiendo[index]) {
			System.out.println("Lectora " + nombreEscritora + " en espera.");
			wait();
		}
		escribiendo[index] = true;
		System.out.println("Escritora " + nombreEscritora + " inicia escritura del dato número " + (index) + ", con valor: " + datos[index]);
		
		
	}

}

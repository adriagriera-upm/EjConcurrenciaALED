package ej2;

public class Datos {
	
	private int[] datos = new int[2];
	private boolean[] escribiendo = {false,false};
	
	
	public void leerDato(String nombreLectora) throws InterruptedException {
		int primero = (int) (Math.round(Math.random()));
		int segundo = (1 - primero);
		//1. Lee el primer dato y libera el cerrojo
		iniciarLectura(nombreLectora,primero);
		primeraLectura(nombreLectora,primero);
		//2. Lee el segundo dato y libera el cerrojo
		iniciarLectura(nombreLectora,segundo);
		segundaLectura(nombreLectora,segundo);
		
		
	}
	
	public void iniciarLectura(String nombreLectora, int index) throws InterruptedException {
		
		while(escribiendo[index]) {
			System.out.println("Lectora " + nombreLectora + " en espera.");
			wait();
		}
	}
	
	public synchronized void segundaLectura(String nombreLectora, int segundo) throws InterruptedException{
		System.out.println("Lectora " + nombreLectora + " inicia la segunda lectura del dato en la posición " + segundo);
		System.out.println("El segundo dato leído por la hebra " + nombreLectora + " es el de la posición " + segundo + ", con valor: " + datos[segundo]);
		notifyAll();
		System.out.println(nombreLectora + " ha terminado de leer todos sus datos.");
	}
	
	public synchronized  void primeraLectura(String nombreLectora, int primero) throws InterruptedException{
		System.out.println("Lectora " + nombreLectora + " inicia la primera lectura del dato en la posición " + primero);
		System.out.println("El primero dato leído por la hebra " + nombreLectora + " es el de la posición " + primero + ", con valor: " + datos[primero]);
		notifyAll();
		System.out.println(nombreLectora + " ha terminado de leer su primer dato.");
	}
	
	
	public synchronized void escribirDato(String nombreEscritora) throws InterruptedException {
		
		//1. Selecciona cuál de los dos datos va a escribir e inicia la escriptura de este dato
		int index = (int) (Math.round(Math.random()));
		iniciarEscritura(nombreEscritora,index);
		escribiendo[index] = true;
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
		System.out.println("Escritora " + nombreEscritora + " inicia escritura del dato en la posición " + (index) + ", con valor: " + datos[index]);
		
		
	}

}

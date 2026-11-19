package ej13;

public class Main {
	
	public static void main(String[] args) {
		
		Peluqueria p = new Peluqueria();
		
		int i = 0;
		while(i < 50) {
			try {
				Thread.sleep(200); //Buen valor, los logs son legibles y se ven a hebras yéndose
			} catch (InterruptedException e) {
			}
			Cliente c = new Cliente(p,"c" + i);
			c.start();
			i++;
		}
		
		
	}

}

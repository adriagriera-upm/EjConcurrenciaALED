package ej1;

public class Lectora extends Thread{
	
	Dato d;
	
	
	@Override
	public void run() {
		System.out.println(d.getDato());
	}
	
	

}

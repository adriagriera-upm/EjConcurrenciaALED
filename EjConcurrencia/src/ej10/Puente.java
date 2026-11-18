package ej10;

public class Puente {
	
	public static void main(String[] args) {
		
		Seguridad s = new Seguridad();
		
		int i = 0;
		while(true) {
			
			int random = (int) Math.round(Math.random());
			boolean ambulancia = false;
			if(random == 0) {
				ambulancia = true;
			}
			Vehiculo v = new Vehiculo(s,"v" + i,(int) Math.round(Math.random()*3000),ambulancia);
			v.start();
			i++;
		}
		
		
	}

}

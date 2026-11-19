package ej11;

public class Ejemplo {

	public static void main(String[] args) {
	    Fabrica f = new Fabrica();
	    
	    for (int i = 0; i < 4; i++) {
	        new Thread(() -> {
	            while (true) {
	               
	                    f.producirRoja();
	                
	            } 
	        }).start();
	    }
	   

	    for (int i = 0; i < 4; i++) {
	        new Thread(() -> {
	            while (true) {
	               
	                    f.producirAzul();
	                
	            } 
	        }).start();
	    }

	    Thread pedidos = new Thread(() -> {
	        while (true) {
	            try {
	                Thread.sleep(2000);
	                f.generarPedido();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    });
	    pedidos.start();
	    
	    
	}
	
}


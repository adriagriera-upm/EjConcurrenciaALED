package ej7;

public class SituacionEstanco {
	
	public static void main(String[] args) {
		
		MonitorFumeta m = new MonitorFumeta();
		
		new Thread(() -> {
                while (true) {
                    m.darComponentes();
                }
            
        }).start();
		
		for (int i = 0; i < 3; i++) {
			Fumeta f = new Fumeta(m,i,"f" + i);
			f.start();
		}
	}

}

package mod10.ex03;

import java.util.Random;

public class FaxServer implements Runnable {
	private FaxQueue queue;
	private Random r = new Random();
	
	public FaxServer(FaxQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true){
			Fax fax = queue.retrieveFax();
			try {
				Thread.sleep(r.nextInt(60));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(fax + "sent;");
		}
	}

}

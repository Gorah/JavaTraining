package mod10.ex03;

import java.util.Random;

public class FaxClient implements Runnable {
	private FaxQueue queue;
	private Random r = new Random();

	public FaxClient(FaxQueue queue) {
		this.queue = queue;
	}


	@Override
	public void run() {
		for(int i=0; i<10; i++){
			try {
				Thread.sleep(r.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			queue.addFax(new Fax("Fax #" +i +"; Sender: " 
					+ Thread.currentThread().getName()));
		}
	}

}

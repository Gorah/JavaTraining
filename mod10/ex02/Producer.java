package mod10.ex02;

import java.util.Random;

public class Producer implements Runnable {
	private Storage storage;
	
	public Producer(Storage s) {
		storage = s;
	}

	public void run() {
		Random r = new Random();
		for (int i=0; i<40; i++) {
			char c = (char)(r.nextInt(80)+40);
			System.out.println("-> Produced: "+c);
			System.out.println("-> Storing...");
			storage.push(c);
			System.out.println("-> Stored: "+c);
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

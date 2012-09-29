package mod10.ex02;

public class Consumer implements Runnable {
	private Storage storage;
	
	public Consumer(Storage s) {
		storage = s;
	}

	public void run() {
		for (int i=0; i<20; i++) {
			System.out.println("<- Consuming... ");
			char c = storage.pop();
			System.out.println("<- Consumed "+c);
			try {
				Thread.sleep(810);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

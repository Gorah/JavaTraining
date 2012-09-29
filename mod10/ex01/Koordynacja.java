package mod10.ex01;

public class Koordynacja implements Runnable {

	private int x;
	
	public Koordynacja(){
		x = 0;
	}
	
	public static void main(String[] args) {
		Koordynacja k = new Koordynacja();
		Thread t = new Thread(k);
		t.start();
		System.out.println("x= " + k.x);
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("x= " + k.x);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		x = 7;
	}

}

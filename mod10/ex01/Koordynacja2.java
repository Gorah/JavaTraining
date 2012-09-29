package mod10.ex01;

public class Koordynacja2 {

	private int x = 0;
	
	public static void main(String[] args) {
		final Koordynacja2 k = new Koordynacja2();
		
		//klasa anonimowa
		Thread t = new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				k.x=7;
			}
		});
		t.start();
		System.out.println("x= " +k.x);
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("x= " +k.x);
	}

}

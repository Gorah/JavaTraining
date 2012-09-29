package mod10.ex02;

public class Storage {
	private static final int LIMIT = 5;

	private int indx = 0;
	private char tab[] = new char[LIMIT];

	synchronized void push(char c) {
		while (indx == LIMIT) {
			try {
			    System.out.println("Nadmiar towaru !! ("+Thread.currentThread().getName()+")");
				wait();
				 System.out.println("Nadmiar towaru !! ("+Thread.currentThread().getName()+")");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Przed notyfikacja (push) ("+Thread.currentThread().getName()+")");
		notify();
		System.out.println("Po notyfikacji (push) ("+Thread.currentThread().getName()+")");
		tab[indx] = c;
		indx++;
	}

	synchronized char pop() {
		while (indx == 0) {
		    System.out.println("brak towaru ("+Thread.currentThread().getName()+")");
			try {
				wait();
				System.out.println("brak towaru (po wait) ("+Thread.currentThread().getName()+")");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Przed notyfikacja (pop) ("+Thread.currentThread().getName()+")");
		notify();
		System.out.println("Po notyfikacji (pop) ("+Thread.currentThread().getName()+")");
		indx--;
		return tab[indx];
	}
	
	public static void main(String[] args) {
		Storage s = new Storage();
		Producer p = new Producer(s);
		Consumer c = new Consumer(s);
		Consumer c1 = new Consumer(s);
		
		(new Thread(c)).start();
		(new Thread(c1)).start();
		(new Thread(p)).start();
	}

}
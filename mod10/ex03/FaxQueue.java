package mod10.ex03;

import java.util.ArrayList;
import java.util.List;

public class FaxQueue {
	private List<Fax> queue = new ArrayList<Fax>();
	
	public void addFax(Fax fax){
		synchronized (this){
			queue.add(fax);
			notify();
			System.out.println("Queue accepted new fax: " + fax);
		}
	}
	
	public Fax retrieveFax(){
		synchronized (this){
			while(0==queue.size()){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Fax fax = queue.remove(0);
			return fax;
		}
	}
}

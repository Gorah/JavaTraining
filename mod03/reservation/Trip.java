package mod03.reservation;

public class Trip {
	private Date start;
	private Date end;
	private String destination;
	private int price;

	public Trip(Date start, Date end, String destination) {
		this.start = start;
		this.end = end;
		this.destination = destination;
	}

	public int getPrice(){
		return this.price;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public String getInfo() {
		return destination + " from " + start.getInfo() + " to "
				+ end.getInfo() + "; trip price: " + getPrice();
	}
}

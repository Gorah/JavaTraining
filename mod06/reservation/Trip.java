package mod04.reservation;

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

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getDestination() {
		return destination;
	}

	public Date getEnd() {
		return end;
	}

	public Date getStart() {
		return start;
	}

	public String getInfo() {
		return destination + ", " + getPrice() + "PLN,\n\tfrom "
				+ start.getInfo() + " to " + end.getInfo();
	}
}

package mod03.ex4.reservation;

public class Trip {
	Date start;
	Date end;
	String destination;

	public Trip(Date start, Date end, String destination) {
		this.start = start;
		this.end = end;
		this.destination = destination;
	}

	public String getInfo() {
		return destination + " from " + start.getInfo() + " to "
				+ end.getInfo();
	}
}

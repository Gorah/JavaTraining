package mod04.reservation;

public class Customer {
	private String name;
	private String address;
	private Trip trip;

	public Customer(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void assignTrip(Trip trip) {
		this.trip = trip;
	}

	public String getInfo() {
		return "Name: " + name + "\nAddress: " + address
				+ "\nHas the following trip: " + trip.getInfo() + "\n";
	}
}

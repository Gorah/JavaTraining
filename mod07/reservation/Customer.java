package mod07.reservation;

import java.io.Serializable;

public class Customer  implements Serializable{
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
		return "Name: " + name + "\nAddress: " + address ;
//		+ "\nHas a following trip: " + trip.getInfo() + "\n";
	}
}


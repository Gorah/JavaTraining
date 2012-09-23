package mod02.ex03;

public class Customer {
	String name;
	String address;
	Trip trip;
	
	public Customer (String name){
		this.name = name;
	}
	
	public void setAddress (String address){
		this.address = address;
	}
	
	public void assignTrip (Trip trip){
		this.trip = trip;
	}
	
	public String getInfo(){
		return "Name: " + name + "; Address: " + address + ".\nTrip details: "
				+ trip.getInfo();
	}
}

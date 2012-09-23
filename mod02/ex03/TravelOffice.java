package mod02.ex03;
import mod02.ex02.*;


public class TravelOffice {
	
	public static void main (String[] args){
		Date start = new Date(2012, 6, 07);
		Date end = new Date(2012, 8, 01);
		
		Customer customer = new Customer("Kowalski, Jan");
		Trip trip = new Trip(start, end, "Karaiby");
		
		customer.assignTrip(trip);
		customer.setAddress("Dluga 5, Wroclaw");
		System.out.println(customer.getInfo());
	}
}

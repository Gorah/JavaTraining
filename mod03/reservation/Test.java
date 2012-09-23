package mod03.reservation;

public class Test {

	public static void main(String[] args) {
		// utworz biuro podrozy
		TravelOffice to = new TravelOffice();

		// budujemy wycieczke
		Trip trip = new Trip(new Date(2004, 8, 1), new Date(2004, 8, 14), "Egipt");
		
		// budujemy pierwszego klienta
		Customer customer = new Customer("Jan Kowalski");
		customer.setAddress("Marszalkowska 10, Warszawa");
		customer.assignTrip(trip);
		trip.setPrice(1000);
		to.addCustomer(customer);  //dodajemy go do biura
		
		
		trip = new AbroadTrip(new Date(2004, 8, 1), new Date(2004, 8, 14), "Paris"); 
		((AbroadTrip) trip).setInsurance(200);
		trip.setPrice(1000);
		customer = new Customer("Jozef Nowak");
		customer.setAddress("Al. Jerozolimskie 120, Warszawa");
		customer.assignTrip(trip);
		to.addCustomer(customer);  //dodajemy go do biura

		trip = new DomesticTrip(new Date(2004, 8, 1), new Date(2004, 8, 14), "Chalupy");
		((DomesticTrip) trip).setOwnArrivalDiscount(200);
		trip.setPrice(1000);
		customer = new Customer("Jaroslaw Lis");
		customer.setAddress("Swietokrzyska 14, Warszawa");
		customer.assignTrip(trip);
		to.addCustomer(customer);  //dodajemy go do biura

		System.out.println(to.getInfo());
	}
	
}

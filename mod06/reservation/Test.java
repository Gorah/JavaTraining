package mod04.reservation;

public class Test {
	public static void main(String[] args) {
		// utworz biuro podrozy
		TravelOffice to = TravelOffice.getInstance();

		// budujemy trzy wycieczki
		Trip trip = new Trip(new Date(2004, 8, 1), new Date(2004, 8, 14),
				"Greece");
		trip.setPrice(1000);
		to.addTrip("grecja", trip);

		DomesticTrip dtrip = new DomesticTrip(new Date(2004, 8, 1), new Date(
				2004, 8, 14), "Jurata");
		dtrip.setPrice(800);
		dtrip.setOwnArrivalDiscount(100);
		to.addTrip("jurata", dtrip);

		AbroadTrip atrip = new AbroadTrip(new Date(2004, 8, 1), new Date(2004,
				8, 14), "Egipt");
		atrip.setPrice(1200);
		atrip.setInsurance(200);
		to.addTrip("egipt", atrip);

		// budujemy pierwszego klienta
		Customer customer = new Customer("Jan Kowalski");
		customer.setAddress("Marszalkowska 10, Warszawa");
		customer.assignTrip(to.getTrips().get("grecja"));
		to.addCustomer(customer); // dodajemy go do biura

		customer = new Customer("Jozef Nowak");
		customer.setAddress("Al. Jerozolimskie 120, Warszawa");
		customer.assignTrip(to.getTrips().get("jurata"));
		to.addCustomer(customer); // dodajemy go do biura

		customer = new Customer("Jaroslaw Lis");
		customer.setAddress("Swietokrzyska 14, Warszawa");
		customer.assignTrip(to.getTrips().get("egipt"));
		to.addCustomer(customer); // dodajemy go do biura

		System.out.println(to.getInfo());

	}
}

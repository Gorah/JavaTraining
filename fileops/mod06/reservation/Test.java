package mod06.reservation;

public class Test {
	public static void main(String[] args) {
		// utworz biuro podrozy
		TravelOffice to = TravelOffice.getInstance();

		// budujemy trzy wycieczki
		Date start = new Date(2004, 8, 1);
		Date end = new Date(2004, 8, 1);

		Trip trip = new Trip(start, end, "Greece");
		trip.setPrice(1000);

		DomesticTrip dtrip = new DomesticTrip(start, end, "Jurata");
		dtrip.setPrice(800);
		dtrip.setOwnArrivalDiscount(100);

		AbroadTrip atrip = new AbroadTrip(start, end, "Egipt");
		atrip.setPrice(1200);
		atrip.setInsurance(200);

		// dodajemy utworzone wycieczki do biura podrozy
		to.addTrip("0001", trip);
		to.addTrip("0002", dtrip);
		to.addTrip("0003", atrip);

		// budujemy pierwszego klienta
		Customer customer = new Customer("Jan Kowalski");
		customer.setAddress("Marszalkowska 10, Warszawa");
		customer.assignTrip(to.getTrips().get("0001"));
		to.addCustomer(customer); // dodajemy go do biura

		customer = new Customer("Jozef Nowak");
		customer.setAddress("Al. Jerozolimskie 120, Warszawa");
		customer.assignTrip(to.getTrips().get("0002"));
		to.addCustomer(customer); // dodajemy go do biura

		customer = new Customer("Jaroslaw Lis");
		customer.setAddress("Swietokrzyska 14, Warszawa");
		customer.assignTrip(to.getTrips().get("0003"));
		to.addCustomer(customer); // dodajemy go do biura

		System.out.println(to.getInfo());
		
		to.saveToFile("to.txt");
		System.out.println(to.printFromFile("to.txt"));

	}
}

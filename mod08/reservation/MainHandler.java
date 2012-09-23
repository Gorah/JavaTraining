package mod08.reservation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class MainHandler implements UserInterface {
	private TravelOffice to;
	private Scanner scanner = null;
	private static Logger logger = Logger.getLogger("pl.altkom.jpr");
	private CitiesWebReader citiesWebReader = new CitiesWebReader();
	
	MainHandler(TravelOffice to) {
		this.to = to;
		scanner = new Scanner(System.in);
		scanner.useDelimiter("\r\n");
	}
	
	public Customer addCustomer() {
		logger.info("Adding customer started");
		
		System.out.print("Enter first name: ");
		String name = scanner.next();
		System.out.print("Enter surname: ");
		String surname = scanner.next();
		
		System.out.print("Enter address: ");
		Customer customer = new Customer(name + " " + surname);
		customer.setAddress(scanner.next());
		to.addCustomer(customer);
	
		System.out.println("New customer was added");
		
		logger.fine( "New customer: " + customer.getInfo() );
		logger.info( "Adding customer finished" );
		return customer;
	}

	public Trip addTrip() {
		logger.info( "Adding trip started" );
		
		Trip trip = null;
		System.out.print("Enter trip id: ");
		String name = scanner.next();
		System.out.print("Enter destination: ");
		String dest = scanner.next();
		System.out.print("Enter start date (dd-mm-yy): ");
		String start_date = scanner.next();
		System.out.println("Enter end date (dd-mm-yy): ");
		String end_date = scanner.next();
		
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yy");
		Date start = data.parse(start_date, new ParsePosition(0));
		if (start == null) {
			String message = "Wrong start date format";
			System.out.println(message);
			logger.warning(message);
			return null;
		}
		
		Date end = data.parse(end_date, new ParsePosition(0));
		if (end == null) {
			String message = "Wrong end date format";
			System.out.println(message);
			logger.warning(message);
			return null;
		} 
		
		System.out.print("Enter price:");
		int price = scanner.nextInt();
		
		System.out.println("local/abroad (l/a) ");
		String type = scanner.next();
		if (type.equals("a")) {
			System.out.print("Enter insurance: ");
			int insurance = scanner.nextInt();
			trip = new AbroadTrip(start, end, dest);
			trip.setPrice(price);
			((AbroadTrip) trip).setInsurance(insurance);
			to.addTrip(name, trip);
			logger.fine("New trip: " + trip.getInfo());
		} else {
			System.out.print("Enter own arrival discount: ");
			int discount = scanner.nextInt();
			trip = new DomesticTrip(start, end, dest);
			trip.setPrice(price);
			((DomesticTrip) trip).setOwnArrivalDiscount(discount);
			to.addTrip(name, trip);
			logger.fine("New trip: " + trip.getInfo());
		}
		
		System.out.println("New trip was created");
		logger.info("Adding trip finished");
		return trip;
	}
	
	public void assign() {
		logger.info("Assigning trip to customer started");
		
		System.out.print("Enter customer name: ");
		String name = scanner.next();
		System.out.print("Enter trip id: ");
		String id = scanner.next();
		logger.fine("Trip id '" + id + "'");
		
		Trip trip = to.getTrips().get(id);
		if ( trip == null ) {
			System.out.println( "No trip under id '" + id + "'" );
			logger.warning( "No trip under id '" + id + "'" );
			return;
		}
		
		try {
			to.setCustomerTrip(name, trip);
		} catch (NoSuchCustomerException e) {
			System.out.println(e.getMessage());
			logger.warning(e.getMessage());
			return;
		}
		
		logger.fine("Trip: " + trip.getInfo() + " added to customer: " + name );
		logger.info("Assigning trip to customer finished");
	}

	public boolean removeCustomer() {
		logger.info("Removing customer started");
		
		System.out.print("Enter name: ");
		String customerName = scanner.next();
		
		
		try {
			to.removeCustomer(customerName);
		} catch (NoSuchCustomerException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getMessage());
			return false;
		}
		
		System.out.println("Customer was removed");
		
		logger.fine("Customer name: " + customerName);
		logger.info("Removing customer finished");
		return true;
	}

	public boolean removeTrip() {
		logger.info("Removing trip started");
		System.out.print("Enter trip id: ");
		String id = scanner.next();
		try {
			to.removeTrip(id);
		} catch (NoSuchTripException e) {
			System.out.println(e.getMessage());
			logger.warning(e.getMessage());
			return false;
		}
		System.out.println("Trip was removed");
		logger.fine("Trip id: " + id);
		logger.info("Removing trip finished");
		return true;
	}

	public void showTrips() {
		logger.info("Showing trips ...");
		Map<String, Trip> t = to.getTrips();
		for ( Entry<String, Trip> entry : t.entrySet())
			System.out.println(entry.getKey() + ": " + entry.getValue().getInfo() );
	}

	public void showCustomers() {
		logger.info("Showing customers ...");
		for (Customer c : to.getCustomers())
			System.out.println(c.getInfo());
	} 

	public boolean saveTravelOffice() {
		logger.info("Saving travel office started");

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("to.ser"));
			// zapisze w katalogu g³ównym projektu, 
			// chyba ¿e podamy np.: "bin/mod07/reservation/to.ser"
			oos.writeObject(to);
			oos.close();
			System.out.println("Data was saved to disk successfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.severe("Saving travel office problem: " + e.getMessage());
			return false;
		}
		logger.info( "Saving travel office finished" );
		return true;
	}

	public boolean loadTravelOffice() {
		logger.info("Loading travel office started ...");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("to.ser"));
			to = (TravelOffice) ois.readObject();
			ois.close();
			System.out.println("Data was read from disk succesfully");
			logger.info("Loading travel office finished ...");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.severe("Loading travel office problem: " + e.getMessage());
			return false;
		}
	}

	public void showCities() {
		logger.info("Showing cities ...");
		try {
			String readCities = citiesWebReader.readCities();
			System.out.println(readCities);
			logger.fine("Cities list: " + readCities);
		} catch (IOException e) {
			String message = "Cities list cannot be read";
			System.out.println(message);
			logger.severe(message + e.getMessage());
		}
	}
}

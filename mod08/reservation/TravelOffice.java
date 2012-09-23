package mod08.reservation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelOffice implements Serializable {
	private static TravelOffice instance;
	private TravelOffice() {
	}
	public static TravelOffice getInstance() {
		if (instance == null) {
			instance = new TravelOffice();
		}
		return instance;
	}
	
	private Set<Customer> customers = new HashSet<Customer>();
	private Map<String, Trip> trips = new HashMap<String, Trip>();
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void addTrip(String name, Trip trip) {
		trips.put(name, trip);
	}
	
	public void removeCustomer(String name) throws NoSuchCustomerException {
		Customer c = findCustomerByName(name);
		customers.remove(c);
	}
	
	public void removeTrip(String name) throws NoSuchTripException {
		if (trips.containsKey(name) == false) {
			throw new NoSuchTripException( "No trip named '" + name + "' found." );
		}
		trips.remove(name);
	}
	
	public int getCustomerCount() {
		return customers.size();
	}
	
	public Set<Customer> getCustomers() {
		return customers;
	}
	
	public Map<String, Trip> getTrips() {
		return trips;
	}
	
	public String getInfo() {
		String report = "";
		for (Customer c : customers) {
			report += c.getInfo() + "\n";
		}
		return report;
	}
	
	public void setCustomerTrip(String name, Trip trip) throws NoSuchCustomerException {
		Customer c = findCustomerByName(name);
		c.assignTrip(trip);
	}
	
	private Customer findCustomerByName(String name) throws NoSuchCustomerException {
		
		if (name.trim().equals("") == false) {
			for (Customer c : customers) {
				if (c.getInfo().startsWith("Name: " + name)) {
					return c;
				}
			}
		}
		throw new NoSuchCustomerException( "Customer named '" + name + "' doesn't exist." );
	}
}

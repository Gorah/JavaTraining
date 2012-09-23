package mod07.reservation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelOffice implements Serializable{
	private static TravelOffice instance;
	private TravelOffice() {
		//
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
	
	public void removeCustomer(String name) {
		for (Customer c : customers) {
			if (c.getInfo().startsWith("Name: " + name)) {
				customers.remove(c);
				break;
			}
		}
	}
	
	public void removeTrip(String name) {
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
			report += c.getInfo()+"\n";
		}
		
		return report;
	}
	
	public void saveToFile(String filename) throws IOException {
		File file = new File(filename);
		FileWriter fileWriter = new FileWriter(file);
		
		fileWriter.write("Trips: " + System.getProperty("line.separator"));
		for (Trip trip : trips.values()) {
			fileWriter.write(trip.getInfo() + System.getProperty("line.separator"));
		}
		
		fileWriter.close();
	}
	
	public String readFromFile(String filename) throws IOException {
		File file = new File(filename);
		FileReader fileReader = new FileReader(file);
		
		char [] buffer = new char[(int)file.length()];
		fileReader.read(buffer);
		fileReader.close();
		
		String contents = new String(buffer);
		return contents;
	}
}
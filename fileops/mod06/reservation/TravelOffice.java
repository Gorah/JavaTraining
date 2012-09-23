package mod06.reservation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TravelOffice {
	private static TravelOffice instance = new TravelOffice();

	private TravelOffice() {
	}

	public static TravelOffice getInstance() {
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
			if (c.getInfo().startsWith("Name: " + name + "\n")) {
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
			report += c.getInfo() + "\n";
		}
		return report;
	}
	
	
	public void saveToFile(String filename){
		File file = new File(filename);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			for (Trip t: trips.values()){
				fw.write(t.getInfo() + System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public String printFromFile(String filename){
		File file = new File(filename);
		FileReader fr = null;
		char[] buffer = new char[(int) file.length()];
		
		try {
			fr = new FileReader(file);
			fr.read(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return new String(buffer);
	}
}

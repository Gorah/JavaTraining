package mod04.reservation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelOffice {
	private static TravelOffice instance = new TravelOffice();

	private TravelOffice() {
	}

	public static TravelOffice getInstance() {
		return instance;
	}

//	int customerCount = 0;
//	private Customer customers[] = new Customer[2];
	private Set<Customer> customers = new HashSet<Customer>();
	private Map<String, Trip> trips = new HashMap<String, Trip>();
	
	public void addCustomer(Customer customer) {
//		if (customerCount == customers.length) {
//			Customer temp[] = new Customer[customers.length + 2];
//			System.arraycopy(customers, 0, temp, 0, customers.length);
//			customers = temp;
//		}
//		customers[customerCount++] = customer;
		
		customers.add(customer);
	}


	
	
	public Set<Customer> getCustomers() {
		return customers;
	}

	public Map<String, Trip> getTrips() {
		return trips;
	}

	public void addTrip (String id, Trip trip){
		trips.put(id, trip);
	}
	
	public void removeTrip (String id){
		trips.remove(id);
	}
	
	public void removeCustomer(String name){
		for (Customer c: customers){
				if (c.getInfo().startsWith("Name: "+name+"\n")){
						customers.remove(c);
				}
		}
	}
	
	public int getCustomerCount() {
		return customers.size();
	}

	public String getInfo() {
		String report = "";
//		for (int i = 0; i < customerCount; i++) {
//			report += customers[i].getInfo() + "\n";
//		}
		
		for (Customer c:customers){
			report += c.getInfo() + "\n";
		}
		return report;
	}
}

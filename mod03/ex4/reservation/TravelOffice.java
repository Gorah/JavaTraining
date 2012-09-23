package mod03.ex4.reservation;

public class TravelOffice {
	
	Customer [] customers = new Customer[2];
	int customerCount = 0;
	

	public void addCustomer(Customer customer){
		
		if (customerCount == customers.length) {
			Customer [] c2 = new Customer[customerCount+2];
			System.arraycopy(customers, 0, c2, 0, customerCount);
			
			customers = c2;
			
		}
		
		customers[customerCount++] = customer;
	}
	
	public int getCustomerCount() {
		return customerCount;
	}
	
	public String getInfo(){
		String report = "";
		
		for (int i=0; i<customerCount; i++){
			report +=customers[i].getInfo() + "\n";
		}
		
		return report;
	}
	
	public static void main(String[] args) {
		TravelOffice office = new TravelOffice();
		
		Trip trip = new Trip(new Date(2004, 8, 1), new Date(2004, 8, 14),
				"Egipt");
		
		
		Customer customer = new Customer("Jan Kowalski");
		customer.setAddress("Marszalkowska 10, Warszawa");
		customer.assignTrip(trip);
		office.addCustomer(customer);

		customer = new Customer("Jan Kowalski");
		customer.setAddress("Marszalkowska 10, Warszawa");
		customer.assignTrip(trip);
		office.addCustomer(customer);

		customer = new Customer("Jan Kowalski");
		customer.setAddress("Marszalkowska 10, Warszawa");
		customer.assignTrip(trip);
		office.addCustomer(customer);

		
		
		
		System.out.println(office.getInfo());

	}
}

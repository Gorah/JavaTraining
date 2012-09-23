package mod03.reservation;

public class TravelOffice {
	private int customerCount = 0;
	private Customer customers [] = new Customer[2];
	
	public void addCustomer(Customer customer) {
		if (customerCount == customers.length) {
			Customer temp[] = new Customer[customers.length+2];
			System.arraycopy(customers, 0, temp, 0, customers.length);
			customers = temp;
		}
		customers[customerCount++] = customer;
	}
	
	public int getCustomerCount() {
		return customerCount;
	}
	
	public String getInfo() {
		String report = "";
		for (int i = 0; i<customerCount; i++) {
			report += customers[i].getInfo();
		}
		
		return report;
	}
}

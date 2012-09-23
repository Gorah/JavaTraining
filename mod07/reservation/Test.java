package mod07.reservation;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		// utworz biuro podrozy
		TravelOffice to = TravelOffice.getInstance();
		MainHandler mh = new MainHandler(to);

		Scanner scan = new Scanner(System.in);
		top:
		while(true) {
			System.out.println("Options:\n1 - Add Customer");
			System.out.print("2 - Add trip\n");
			System.out.print("3 - Assign trip to customer\n");
			System.out.print("4 - Remove Customer\n");
			System.out.print("5 - Remove Trip\n");
			System.out.print("6 - Show Customers\n");
			System.out.print("7 - Show Trips\n");
			System.out.print("8 - Load\n");
			System.out.print("9 - Save\n");
			System.out.print("0 - Exit\n");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: mh.addCustomer();
				break;
			case 2: mh.addTrip();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6: mh.showCustomers();
				break;
			case 7: mh.showTrips();
				break;
			case 8: mh.loadTravelOffice();
				break;
			case 9: mh.saveTravelOffice();
				break;
			case 0:
				break top;
			default:
				break;
			}
		}
		scan.close();
	}
}

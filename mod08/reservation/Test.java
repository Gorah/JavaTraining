package mod08.reservation;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test {
	public static void main(String[] args) throws SecurityException, IOException {

		setupLoggers();
		TravelOffice to = TravelOffice.getInstance();
		MainHandler mh = new MainHandler(to);

		Scanner scan = new Scanner(System.in);
		top: while (true) {
			System.out.println("Options:\n1 - Add Customer");
			System.out.print("2 - Add trip\n");
			System.out.print("3 - Assign trip to customer\n");
			System.out.print("4 - Remove Customer\n");
			System.out.print("5 - Remove Trip\n");
			System.out.print("6 - Show Customers\n");
			System.out.print("7 - Show Trips\n");
			System.out.print("8 - Load\n");
			System.out.print("9 - Save\n");
			System.out.print("10 - Show cities\n");
			System.out.print("0 - Exit\n");
			int choice;
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				scan.next(); // przeczytanie blednej danej z bufora
				continue;
			}
			switch (choice) {
			case 1:
				mh.addCustomer();
				break;
			case 2:
				mh.addTrip();
				break;
			case 3:
				mh.assign();
				break;
			case 4:
				mh.removeCustomer();
				break;
			case 5:
				mh.removeTrip();
				break;
			case 6:
				mh.showCustomers();
				break;
			case 7:
				mh.showTrips();
				break;
			case 8:
				mh.loadTravelOffice();
				break;
			case 9:
				mh.saveTravelOffice();
				break;
			case 10:
				mh.showCities();
				break;
			case 0:
				break top;
			default:
				break;
			}
		}
		scan.close();
	}

	private static void setupLoggers() throws IOException {
		Logger rootLogger = Logger.getLogger("");
		rootLogger.removeHandler(rootLogger.getHandlers()[0]);
		
		Logger logger = Logger.getLogger("pl.altkom.jpr");
		FileHandler fileHandler = new FileHandler("log.txt");
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
		logger.setLevel(Level.FINE);
	}
}

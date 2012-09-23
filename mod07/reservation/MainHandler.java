package mod07.reservation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainHandler implements UserInterface {
	private TravelOffice to;
	private Scanner sc;
	
	public MainHandler(TravelOffice to) {
		this.to = to;
		sc = new Scanner(System.in);
		sc.useDelimiter("\r\n");
	}

	@Override
	public Customer addCustomer() {
		System.out.print("Enter first line: ");
		String name = sc.next();
		System.out.print("Enter surname: ");
		String surname = sc.next();
		System.out.print("Enter address: ");
		String address = sc.next();
		
		Customer c = new Customer(name + " " + surname);
		c.setAddress(address);
		to.addCustomer(c);
		System.out.println("New customer added.");
		return c;
	}

	@Override
	public Trip addTrip() {
		System.out.print("Enter trip id: ");
		String id = sc.next();
		System.out.print("Enter destination: ");
		String dest = sc.next();
		System.out.print("Enter start date (yyyy-mm-dd): ");
		String start = sc.next();
		System.out.print("Enter end date (yyyy-mm-dd): ");
		String end = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date startD = sdf.parse(start, new ParsePosition(0));
		Date endD = sdf.parse(end, new ParsePosition(0));
		System.out.print("Enter price: ");
		int price = sc.nextInt();
		System.out.print("Enter trip type (a/d): ");
		String type = sc.next();
		
		Trip trip;
		
		if ("a".equals(type)){
			System.out.print("Enter insurance: ");
			int insurance = sc.nextInt();
			trip = new AbroadTrip(startD, endD, dest);
			((AbroadTrip)trip).setInsurance(insurance);
			
		} else {
			System.out.print("Enter own arrival discount: ");
			int discount = sc.nextInt();
			trip = new DomesticTrip(startD, endD, dest);
			((DomesticTrip)trip).setOwnArrivalDiscount(discount);
		}
		trip.setPrice(price);
		to.addTrip(id, trip);
		return null;
	}

	@Override
	public void assign() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeCustomer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTrip() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showTrips() {
		Map<String, Trip> map = to.getTrips();
		for (Entry<String, Trip> entry :map.entrySet()){
			System.out.println(entry.getKey()+": "+entry.getValue().getInfo() +"\n");
		}
	}

	@Override
	public void showCustomers() {
		for (Customer c: to.getCustomers()){
			System.out.println(c.getInfo() + "\n");
		}
	}

	@Override
	public boolean saveTravelOffice() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("to.ser"));
			oos.writeObject(to);
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			if (oos !=null){
				try {
					oos.close();
				} catch (IOException e) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean loadTravelOffice() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("to.ser"));
			to = (TravelOffice) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(ois != null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

}

package mod08.reservation;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Trip implements Serializable {
	private Date start;
	private Date end;
	private String destination;
	private int price;
	
	public Trip(Date start, Date end, String destination) {
		this.start = start;
		this.end = end;
		this.destination = destination;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	public String getDestination() {
		return destination;
	}

	public Date getEnd() {
		return end;
	}
	
	public Date getStart() {
		return start;
	}

	public String getInfo() {
		return destination + ", " + getPrice() + "PLN, \n\tfrom " +
				format(start) + " to " + format(end);
	}
	
	protected String format(Date date) {
		return DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH).format(date);
	}
}

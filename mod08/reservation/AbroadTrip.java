package mod08.reservation;

import java.util.Date;

public class AbroadTrip extends Trip {
	private int insurance;

	public AbroadTrip (Date start, Date end, String destination) {
		super(start, end, destination);
	}

	public int getPrice() {
		return super.getPrice() + insurance;
	}

	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}
}

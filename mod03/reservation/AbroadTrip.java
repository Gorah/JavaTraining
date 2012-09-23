package mod03.reservation;

public class AbroadTrip extends Trip {

	private int insurance;
	
	public AbroadTrip(Date start, Date end, String destination) {
		super(start, end, destination);
	}

	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}

	@Override
	public int getPrice() {
		
		return super.getPrice()+ insurance;
	}
	
	
}

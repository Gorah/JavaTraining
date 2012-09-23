package mod03.reservation;

public class DomesticTrip extends Trip{
	
	public DomesticTrip(Date start, Date end, String destination) {
		super(start, end, destination);
	}

	private int ownArrivalDiscount;

	@Override
	public int getPrice() {
		return super.getPrice() - ownArrivalDiscount;
	}

	public void setOwnArrivalDiscount(int ownArrivalDiscount) {
		this.ownArrivalDiscount = ownArrivalDiscount;
	}
}

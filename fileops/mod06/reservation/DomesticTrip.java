package mod06.reservation;

public class DomesticTrip extends Trip {
	private int ownArrivalDiscount;

	public DomesticTrip(Date start, Date end, String destination) {
		super(start, end, destination);
	}

	public int getPrice() {
		return super.getPrice() - ownArrivalDiscount;
	}

	public void setOwnArrivalDiscount(int ownArrivalDiscount) {
		this.ownArrivalDiscount = ownArrivalDiscount;
	}
}

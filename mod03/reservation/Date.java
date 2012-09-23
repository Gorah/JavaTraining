package mod03.reservation;

public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date(int y, int m, int d) {
		this.year = y;
		this.month = m;
		this.day = d;
	}
	
	public String getInfo() {
		return year + "/" + month + "/" + day;
	}
}

package mod03.ex4.reservation;

public class Date {
	int year;
	int month;
	int day;
	
	public Date(int y, int m, int d) {
		this.year = y;
		this.month = m;
		this.day = d;
	}
	
	public String getInfo() {
		return year + "/" + month + "/" + day;
	}

}

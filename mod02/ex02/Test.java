package mod02.ex02;

public class Test {

	public static void main(String[] args) {
		Date start = new Date(1990, 10, 12);
		Date end = new Date(2005, 10, 24);

		start.getDate();
		end.getDate();

		Date today = start;
		today.getDate();

		today.rok = 1999;
		today.dzien = 24;

		System.out.println("today: " + today);
//		today.getDate();
		System.out.println("start: " + start);
//		start.getDate();

		end = today;
		System.out.println("end: " + end);
//		end.getDate();
	}
}

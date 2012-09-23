package mod02.ex03;

import mod02.ex02.*;

public class Trip {
	Date start;
	Date end;
	String destination;
	
	public Trip (Date start, Date end, String destination){
		this.start = start;
		this.end = end;
		this.destination = destination;
	}
	
	public String getInfo(){
		return "destination: " + destination + ";\nstart date: " 
				+ start.getInfo() + "; end date: " + end.getInfo() + ";";
	}
}

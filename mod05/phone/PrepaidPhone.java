package mod05.phone;

public class PrepaidPhone {
	private int limit;

	public PrepaidPhone(int startLimit) {
		limit = startLimit;
	}
	
	public void makeCall(int min) throws PrepaidException {
		
		if (limit < min) throw new PrepaidException("**** Limit exceeded! You have " + limit 
				+ " minutes left and you neeed " + min);
		
		limit -= min;
		System.out.println("\tNice talk...");
	}
	
	public int getLimit() {
		return limit;
	}

	public void addToLimit(int min) {
		limit += min;
	}
}

package mod10.ex03;

public class Fax {
	private String message;
	
	public Fax(String m){
		message = m;
	}
	
	@Override
	public String toString() {
		return message;
	}
}

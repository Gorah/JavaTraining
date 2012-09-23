package mod04.ex04;

public abstract class Vehicle {

	private String name; 
	
	
	public Vehicle(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public abstract double getFuelNeeds();
	public abstract double getDistance();
	
	public double calcFuelEfficiency(){
		
		return (getFuelNeeds()/getDistance()) *100;
	}

	public void go(){
		System.out.println(getClass().getSimpleName() + ": " + this + " has started");
	}
	
	public void stop(){
		System.out.println(getClass().getSimpleName() + ": " + this + " has stopped");
	}
}

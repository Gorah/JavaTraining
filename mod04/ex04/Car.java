package mod04.ex04;

public class Car extends Vehicle {

	public Car(String name) {
		super(name);
	}
	
	@Override
	public double getFuelNeeds(){
		return 16;
	}
	
	@Override
	public double getDistance(){
		return 200;
	}
}

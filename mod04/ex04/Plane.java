package mod04.ex04;

public class Plane extends Vehicle implements Flying {

	public Plane(String name) {
		super(name);
	}

	@Override
	public void takeOff() {
		System.out.println("Plane is taking off...");

	}

	@Override
	public void land() {
		System.out.println("Plane is landing...");

	}

	@Override
	public void callAirControl() {
		System.out.println("Calling air control...");

	}

	@Override
	public double getFuelNeeds() {
		return 300;
	}

	@Override
	public double getDistance() {
		return 2000;
	}

	@Override
	public void go() {
		takeOff();
		super.go();
	}

	@Override
	public void stop() {
		land();
		super.stop();
	}

	
}

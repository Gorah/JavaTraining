package mod04.ex04;

public class Ship extends Vehicle implements Sailing{

	public Ship(String name) {
		super(name);
	}

	@Override
	public double getFuelNeeds() {
		return 600000;
	}
	
	@Override
	public double getDistance() {
		return 6000;
	}

	@Override
	public void dock(){
		System.out.println("Ship has docked in the port");
	}

	@Override
	public void stop() {
		dock();
	}
}

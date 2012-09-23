package mod04.ex04;

public class Test {
	
	public static void main(String[] args) {
		Vehicle vehicles[] = new Vehicle[5];
		
		vehicles[0]= new Car("Audi");
		vehicles[1]= new Truck("Kamaz");
		vehicles[2]= new RaceCar("Williams");
		vehicles[3]= new Ship("Tanker");
		vehicles[4]= new Plane("F-16");
		
		for(Vehicle item : vehicles){
			item.go();
			if(item instanceof Flying){
				((Flying) item).callAirControl();
			}
			item.stop();
			System.out.println("Fuel efficiency: " + item.calcFuelEfficiency() + "\n");
		}
		
		
	}

}

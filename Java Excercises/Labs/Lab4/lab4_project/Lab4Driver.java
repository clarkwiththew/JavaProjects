package lab4_project;

public class Lab4Driver {

	public static void main(String[] args) {
		// Run this to test Car and Plane simulations
		
		
		// Run car simulation
		System.out.println("CAR SIMULATION");
		Car c = new Car();
		c.startCar();
		c.driveCar();
		c.stopCar();
		System.out.println("------------------------");
		
		// Run plane simulation
		System.out.println("PLANE SIMULATION");
		Plane p = new Plane();
		p.startPlane();
		p.flyPlane();
		p.stopPlane();
	}

}

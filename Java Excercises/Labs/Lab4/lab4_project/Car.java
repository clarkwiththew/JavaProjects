package lab4_project;

// by "extending" Vehicle, we define Car as a subclass of Vehicle
	// ie. Car inherits from Vehicle
public class Car extends Vehicle{
	
	// 1. Create method called "startCar"
	public void startCar() {
		// 1.1 print "Starting car..."
		System.out.println("Starting car...");
		// 1.2 start vehicle using method inherited from "Vehicle" class
		this.startVehicle();
	}
	
	// 2. Create method called "driveCar"
	public void driveCar() {
		// 2.1 print "Driving car..."
		System.out.println("Driving car...");

		// 2.2 move car using method inherited from "Vehicle" class
		this.moveVehicle();
	}
	
	// 3. Create method called "stopCar"
	public void stopCar() {
		// 3.1 print "Stopping car..."
		System.out.println("Stopping car...");

		// 3.2 stop vehicle using method inherited from "Vehicle" class
		this.stopVehicle();
	}
}

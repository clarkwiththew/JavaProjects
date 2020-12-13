package lab4_project;

public class Plane extends Vehicle{
	// 1. define collaborators (Wings) as private variables 
		// eg. private CollaboratingClass c;
	private Wings c ;
	
	public Plane() {
		// 2. initialize objects of collaborating classes in constructor
			// eg. c = new CollaboratingClass();
		c = new Wings();
		 
	}
	
	// 3. create method called "startPlane"
	public void startPlane(){
		// 3.1 print "Starting plane..."
		System.out.println("Starting plane...");
		// 3.2 activate wings using method from "Wings" class
		c.activateWings();
		// 3.3 start plane using method inherited from "Vehicle" class
		this.startVehicle();
	}
	
	// 4. create method called "flyPlane"
	public void flyPlane() {
		// 4.1 print "Flying plane..."
		System.out.println("Flying plane...");

		// 4.2 move plane using method inherited from "Vehicle" class
		this.moveVehicle();
	}
	
	// 5. create method called "stopPlane"
	public void stopPlane() {
		// 5.1 print "Stopping plane..."
		System.out.println("Stopping plane...");

		// 5.2 stop plane using method inherited from "Vehicle" class
		this.stopVehicle();
		// 5.3 deactivate wings using method from "Wings" class
		c.deactivateWings();
	}
	
}

package lab4_project;

public class Vehicle {
	
	// 1. define collaborators as private variables (Engine, Brake, Accelerate)
		// eg. private CollaboratingClass c;
	private Engine engine;
	private Brake brake;
	private Accelerate accelerate;

	public Vehicle(){
		// 2. initialize objects of collaborating classes in constructor
			// eg. c = new CollaboratingClass();
		brake = new Brake();
		accelerate = new Accelerate();
		engine = new Engine();

	}
	public void startVehicle() {

	// 3. create method called "startVehicle"
		// 3.1 start engine using "Engine" class
		engine.startEngine();
		// 3.2 accelerate from 0mph to 60mph using "Accelerate" class
		 accelerate.accelerate();
	}
	public void moveVehicle() {

	// 4. create method called "moveVehicle"

		// 4.1 maintain 60mph using "Accelerate" class
		accelerate.maintainSpeed();
	}
	
	// 5. create method called "stopVehicle"
public void stopVehicle() {
		// 5.1 activate brake using "Brake" class
		brake.activateBrake();
		// 5.2 deaccelerate from 60mph to 0 mph using "Accelerate" class
		accelerate.deaccelerate();
		// 5.3 stop engine using "Engine" class
		engine.stopEngine();
	}
}

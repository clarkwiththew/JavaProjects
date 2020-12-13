package lab5_project;

public class Vehicle {
	protected double speed;
	protected int wheels;
//	public double getSpeed() {
//		return this.speed;
//	}
	public void setSpeed(double speed) {
		this.speed=speed;
	}
	public void setNumberOfWheels(int wheels) {
		this.wheels=wheels;
	}
	public int getNumberofWheels() {
		return this.wheels;
	}
	public String toString() {
		return "Vehicle with " + String.valueOf(wheels)+
				" wheels, travelling at speed "+String.valueOf(speed)+
				" km/h";
		
		}
}

package lab5_project;

public class Motorcycle extends Vehicle{
	protected double size;
	public double getEngineSize() {
		return this.size;
	}
	public void setEngineSize(double size) {
		this.size=size;
	}
	public String toString() {
		return "The motorcycle has a big engine, it’s "+String.valueOf(this.size)+" L cubed";
	}
}

import iiitb.ess201a7.a7base.Car;
import iiitb.ess201a7.a7base.Location;

public class TextDisplay extends Display {

	public TextDisplay() {
		
	}
	
	public void init() {
		System.out.println("Starting new simulation");
		
	}
	public void draw(Car car) {
		
		System.out.println("Car"+car.getId() + " at " + car.getLocation());
		
	}

	public void drawLine(Location a, Location b) {
		System.out.println("Line from " + a + " to " + b);
	}
}

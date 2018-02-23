import iiitb.ess201a7.a7base.*;


public abstract class Display {

	// needed for 2-way communication between App and Display
	
	App app;
	
	public Display() {
		
	}
	
	public void setApp(App a) {
		app = a;
	}
	
	// Will be called by app at init time - and before call to any other display method
	// Derived call can override this and do any initialization needed
	public void init() {
		
	}
	
	// v4 - added
	// Can be used by app to make any updates needed by the derived classes
	public void update() {
		
		
	}
	
	public void requestTrip(Location start, Location dest) {
		app.handleTripRequest(start, dest);
	}
	
	public abstract void draw(Car car);

	public abstract void drawLine(Location a, Location b);
}

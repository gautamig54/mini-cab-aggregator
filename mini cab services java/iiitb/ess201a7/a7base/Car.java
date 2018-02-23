package iiitb.ess201a7.a7base;

public abstract class Car {
	private int id;

	protected int maxSpeed;  // v3

	//v3
	public static final int Idle = 1;
	public static final int Booked = 2;
	public static final int OnTrip = 3;

	// should only be called by the derived classes, passing in the id of the car
	// and the max speed of the car
	protected Car(int fid, int speed) {
		id = fid;
		maxSpeed = speed;
	}

	public int getId() {
		return id;
	}

	public int getSpeed() {
		return maxSpeed;
	}

	// v3 - convenience function - override in derived class
	// returns the square of the distance from the current position of the car to loc
	// Don't change this - override in derived class
	public int distSqrd(Location loc) {
		return 0;
	}

	public abstract void setLocation(Location l);

	public abstract Location getLocation();

	public abstract void setStatus(int s);

	public abstract int getStatus();

	public abstract void assignTrip(Trip trip);

	public abstract Trip getTrip();

	// return location of start of trip (where customer is to be picked up)
	// null if idle
	public abstract Location getStart();

	// return location of end of trip (where customer is to be dropped off)
	// null if idle

	public abstract Location getDest();

	// v3 - parameter is now double instead of int
	public abstract void updateLocation(double deltaT);

}

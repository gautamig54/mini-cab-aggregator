package iiitb.ess201a7.a7base;

public class Trip {
	private Location startLoc;
	private Location destLoc;
	
	public Trip(Location start, Location dest) {
		startLoc = start;
		destLoc = dest;
	}
	
	public Location getStart() {
		return startLoc;
	}
	
	public Location getDest() {
		return destLoc;
	}
}

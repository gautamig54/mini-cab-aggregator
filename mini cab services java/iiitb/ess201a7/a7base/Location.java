package iiitb.ess201a7.a7base;

public class Location {

	private int x;
	private int y;

	public Location() {
		x=0;
		y=0;
	}
	
	public Location(int a, int b) {
		x=a;
		y=b;
	}
	
	public void set(int a, int b) {
		x = a;
		y = b;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
		
	}
}

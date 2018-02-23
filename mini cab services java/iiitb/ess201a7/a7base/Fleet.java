package iiitb.ess201a7.a7base;

import java.util.ArrayList;

public abstract class Fleet {

	private int id;
	private String colour;

	protected Fleet(int fid, String col){
		id = fid;
		colour = col;
	}

	public int getId() {
		return id;
	}

	public String getColour() {
		return colour;
	}

	// creates a new car (consistent with its derived type) and adds it to its list of cars
	public abstract void addCar(int speed);

	public abstract Car findNearestCar(Location loc);

	// v3 - added
	public abstract ArrayList<? extends Car> getCars();
}

import java.util.*;

import iiitb.ess201a7.a7base.*;
import iiitb.ess201a7.r16069.*;

public class Platform {

	private ArrayList<Fleet> flt=new ArrayList<Fleet>();


	public Platform () {
		
	}
	
	public void addFleet(Fleet f) {
		flt.add(f);
	}
	
	// for a request defined as a Trip, find the best car by checking each of its fleets
	// and assigns the car to this trip

	public Car assignCar(Trip trip) {
		ArrayList<Car> best_cars = new ArrayList<Car>();
		for(int i=0;i<flt.size();i++){
			best_cars.add(flt.get(i).findNearestCar(trip.getStart()));
		}

		int j=0, curr_dist;
		int min_dist = Integer.MAX_VALUE;
		for(int i=0;i<best_cars.size();i++){
			if(best_cars.get(i)!=null){
			curr_dist = best_cars.get(i).distSqrd(trip.getStart());
			if(best_cars.get(i).getStatus()==1){
				if(curr_dist<min_dist){
					min_dist = curr_dist;
					j=i;
				}
			}
			}
		}
		if(best_cars.get(j)!=null)
		{	
			best_cars.get(j).assignTrip(trip);
			return best_cars.get(j);
		}
		else
			return null;
	}
	
	// returns list of all cars (in all the fleets) managed by this platform 
	public ArrayList<Car> findCars() {

		ArrayList<Car> cr=new ArrayList<Car>();
		for(int i=0;i<flt.size();i++){
				ArrayList<? extends Car> ff=flt.get(i).getCars();
				for(int j=0;j<ff.size();j++)
					cr.add(ff.get(j));
		}
		return cr; // replace with implementation.
	}
}

package iiitb.ess201a7.r16069;
import iiitb.ess201a7.a7base.*;
import java.util.*;

public class Fleet16069 extends Fleet {

	private ArrayList<Car> arr=new ArrayList<Car>();
	private int ctr=1;

	public Fleet16069(String colour) {
		super(16069,colour);
		System.out.println();
	}

	@Override
	public void addCar(int speed) {
		arr.add(new Car16069(Integer.parseInt("16069"+ctr++),speed));
	}

	@Override
	public Car findNearestCar(Location loc) {
		
		int l=arr.size();
		Car assign_car=null;
		double min=Double.MAX_VALUE;
		for(int i=0;i<l;i++){
			Car cr=arr.get(i);
			Location lc=cr.getLocation();
			
			double dist= Math.sqrt(Math.pow(lc.getX()-loc.getX(),2)+Math.pow(lc.getY()-loc.getY(),2));
			if(dist<min && cr.getStatus()==1){
				min=dist;
				assign_car=cr;
			}
		}
		
		return assign_car;
	}

	@Override
	public ArrayList<? extends Car> getCars(){
		return arr;
	}
}

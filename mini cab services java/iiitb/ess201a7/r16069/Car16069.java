package iiitb.ess201a7.r16069;
import iiitb.ess201a7.a7base.*;
import java.lang.*;

public class Car16069 extends Car {

	private Location loc;
	private int status=1;
	private Trip trip;

	public Car16069(int cid,int speed) {
		super(cid,speed);
	}

	@Override
	public void setLocation(Location l) {
		// TODO Auto-generated method stub
		loc=l;
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return loc;
	}

	@Override
	public void setStatus(int s) {
		// TODO Auto-generated method stub
		status=s;
	}

	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public void assignTrip(Trip trip) {
		// TODO Auto-generated method stub
		if(status==1){
			this.trip=trip;
			setStatus(2);
		}
	}

	@Override
	public Trip getTrip(){

		return trip;
	}

	@Override
	public int distSqrd(Location l){
		int dist=1; dist*=Math.pow(l.getX()-loc.getX(),2)+Math.pow(l.getY()-loc.getY(),2);
		return dist;
	}

	@Override
	public Location getStart() {
		// TODO Auto-generated method stub
		if(status!=1)
			return trip.getStart();
		else
			return null;
	}

	@Override
	public Location getDest() {
		// TODO Auto-generated method stub
		if(status!=1)
			return trip.getDest();
		else
			return null;
	}

	@Override
	public void updateLocation(double deltaT) {
		// TODO Auto-generated method stub
		if(getStatus()==2){
			if(loc.getX()==getStart().getX() && loc.getY()==getStart().getY())
				setStatus(3);
		}

		if(getStatus()==3){
			if(loc.getX()==getDest().getX() && loc.getY()==getDest().getY())
				setStatus(1);
		}

		
		double d=deltaT * getSpeed();
		double d1=0.0;
		Location l=new Location();
		if(getStatus()==2){
			d1=Math.sqrt(distSqrd(getStart()));
			if(d<d1){
				
				double sin = (getStart().getY()-loc.getY())/d1;
				double cos = (getStart().getX()-loc.getX())/d1;
				l.set((int)(loc.getX()+(cos*d)),(int)(loc.getY()+(sin*d)));
				setLocation(l);
			}

			else
				setLocation(getStart());
		}

		if(getStatus()==3){
			d1=Math.sqrt(distSqrd(getDest()));
			if(d<d1){
				double sin = (getDest().getY()-loc.getY())/d1;
				double cos = (getDest().getX()-loc.getX())/d1;
				l.set((int)(loc.getX()+(cos*d)),(int)(loc.getY()+(sin*d)));
				setLocation(l);
			}

			else
				setLocation(getDest());
		}


	}

	

	}

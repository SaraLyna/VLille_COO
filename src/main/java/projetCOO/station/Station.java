package projetCOO.station;

import java.util.*;

import projetCOO.control.repairer.Repairer;
import projetCOO.state.State;
import projetCOO.twoWheeledVehicle.bike.Bike;
import projetCOO.twoWheeledVehicle.*;

/**
*this is the Station class representing the station
*where are the bikes located
*/
public class Station {
	protected int id;
	protected int capacityMax;
	protected Map<TwoWheeledVehicle,State> bikes;
	protected Repairer repairer ;

	/**
	* Constructor of the class Station
	*/
	public Station(int id){
			this.id = id;
        	this.initCapacityMax();;
        	this.initBikeInStation();
        	this.repairer = null;

	}
	
	/**
	 * @return the station's id
	 */
	public int getId(){
		return this.id;
	}

	
	/**
	 * give the station list and the state for each bike
	 * @return the station's bikes
	 */
	public Map<TwoWheeledVehicle, State> getBikes() {
		return bikes;
	}

	/**
	 * give the repairer if he is present otherwise null
	 * @return the repairer
	 */
	public Repairer getRepairer() {
		return repairer;
	}

	/**
	 * @param repairer the repairer to set
	 */
	public void setRepairer(Repairer r) {
		this.repairer = r;
	}

	/**
	 * @return the capacityMax
	 */
	public int getCapacityMax() {
		return capacityMax;
	}

	/**
	 * Add a bike to the station.
	 * @param bike
	 */
	public void addBike(Bike bike) {
		if (bikes.size() < capacityMax) {
            		bikes.put(bike, State.AVAILABLE); 
            		bike.setStation(this);
        	} else {
            		System.out.println("The station is at maximum capacity. Cannot add more bikes.");
        	}
		
	}
	
	/**
	 * 
	 */
	
	/**
	 * Init the max bike capacity of the station.
	 * The capacity is choosed between 10 and 20.
	 */
	public void initCapacityMax() {
		int min = 10;
		int max = 20;
		int range = max - min + 1;
		this.capacityMax = (int)(Math.random() * range) + min;
	}
	
	/**
	 * Init bikes in the station
	 */
	public void initBikeInStation() {
		this.bikes = new  HashMap<>();
		for (int i = 0; i < this.getCapacityMax(); i++) {
			Bike b = new Bike("default", this);
			this.addBike(b);
		}
	}
	
	public String toString() {
		return "Station n° "+ this.id  + " capacity max is "+ this.capacityMax ;
	}

}

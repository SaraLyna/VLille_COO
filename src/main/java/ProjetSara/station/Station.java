package ProjetSara.station;

import java.util.Map;

import ProjetSara.bike.Bike;
import ProjetSara.state.State;

/**
*this is the Station class representing the station
*where are the bikes located
*/
public class Station {
	protected String id;
	protected int capacityMax;
	protected Map<Bike,State> bikes;

	/**
	* Constructor of the class Station
	*/
	public Station(int capacityMax, String id){
		this.id = id;
        	this.capacityMax = capacityMax;
        	this.bikes = new HashMap<>();

	}

	public String getId(){
		return this.id;
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

}

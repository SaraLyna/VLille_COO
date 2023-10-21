package projetCOO.station;

import java.util.*;

import projetCOO.control.repairer.Repairer;
import projetCOO.state.State;
import projetCOO.twoWheeledVehicle.*;

/**
*this is the Station class representing the station
*where are the bikes located
*/
public class Station {
	protected int id;
	protected int capacityMax;
	protected Map<TwoWheeledVehicle,State> vehicles;
	protected Repairer repairer ;

	/**
	* Constructor of the class Station
	*/
	public Station(int id){
			this.id = id;
        	this.initCapacityMax();;
        	this.vehicles = new HashMap<>();
        	this.repairer = null;

	}
	
	/**
	 * @return the station's id
	 */
	public int getId(){
		return id;
	}

	
	/**
	 * give the station list and the state for each bike
	 * @return the vehicles
	 */
	public Map<TwoWheeledVehicle, State> getVehicles() {
		return vehicles;
	}
	
	/**
	 * rajouter une exception ici
	 * @param Index
	 * @return
	 */
	public TwoWheeledVehicle getOneVehicle(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > this.capacityMax) {
			throw new ArrayIndexOutOfBoundsException("invalid index");
		}
		Iterator<TwoWheeledVehicle> i = this.vehicles.keySet().iterator();
		int cpt = 0;
		while (i.hasNext()) {
			TwoWheeledVehicle v = i.next();
			if (cpt == index) {
				return v;
			}
			cpt++;
		}
		return null;
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
	public void addVehicle(TwoWheeledVehicle v) {
		if (vehicles.size() < capacityMax) {
            		vehicles.put(v, State.AVAILABLE); 
            		v.setStation(this);
        } 
		else {
            		System.out.println("The station is at maximum capacity. Cannot add more bikes.");
		}
		
	}
	
	public void setStateVehicle(TwoWheeledVehicle v, State s) {
		vehicles.replace(v, s);
	}
	
	public void removeVehicle(TwoWheeledVehicle vehicle) {
	        vehicles.remove(vehicle);
	}
	
	public int getAvailableVehicleCount() {
        int count = 0;
        for (State state : vehicles.values()) {
        	if (state == State.AVAILABLE) {
        		count++;
	        }
	    }
	    return count;
	 }
	    
	/**
	 * Init the max vehicle capacity of the station.
	 * The capacity is choosed between 10 and 20.
	 */
	public void initCapacityMax() {
		int min = 10;
		int max = 20;
		int range = max - min + 1;
		this.capacityMax = (int)(Math.random() * range) + min;
	}
	
	public String toString() {
		return "Station n° "+ this.id  + " capacity max is "+ this.capacityMax ;
	}

}

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
	protected Map<TwoWheeledVehicle,State> vehicles;
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
	public void addVehicle(TwoWheeledVehicle vehicle) {
		if (vehicles.size() < capacityMax) {
            		vehicles.put(vehicle, State.AVAILABLE); 
            		if (vehicle instanceof Bike) {
                        ((Bike) vehicle).setStation(this);
                    }
        	} else {
            		System.out.println("The station is at maximum capacity. Cannot add more bikes.");
        	}
		
	}
	
	
	
	
	 public void removeVehicle(TwoWheeledVehicle vehicle) {
	        vehicles.remove(vehicle);
	    }

	    public void markVehicleAsStolen(TwoWheeledVehicle vehicle) {
	        vehicles.put(vehicle, State.STOLEN);
	    }

	    public void markVehicleAsDamaged(TwoWheeledVehicle vehicle) {
	        vehicles.put(vehicle, State.DAMAGED);
	    }

	    public void repairVehicle(TwoWheeledVehicle vehicle) {
	    	vehicles.put(vehicle, State.AVAILABLE);
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
	
	
	
	
	/**
	 * Init vehicles in the station
	 */
	public void initBikeInStation() {
		this.vehicles = new  HashMap<>();
		for (int i = 0; i < this.getCapacityMax(); i++) {
			Bike b = new Bike("default", this);
			this.addVehicle(b);
		}
	}
	
	public String toString() {
		return "Station n° "+ this.id  + " capacity max is "+ this.capacityMax ;
	}

}

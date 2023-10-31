package projetCOO.station;

import java.util.*;
import projetCOO.control.repairer.Repairer;
import projetCOO.state.State;
import projetCOO.twoWheeledVehicle.*;


/**
*this is the Station class representing the station
*where are the vehicles located
*/
public class Station {
	protected int id;
	protected int capacityMax;
	protected Map<TwoWheeledVehicle,State> vehicles;
	protected Repairer repairer ;
	protected int availableVehicleNB;

	/**
	* Constructor of the class Station
	*/
	public Station(int id){
			this.id = id;
        	this.initCapacityMax();;
        	this.vehicles = new HashMap<>();
        	this.repairer = null;
        	this.availableVehicleNB = this.capacityMax;
	}
	
	/**
	 * @return the station's id
	 */
	public int getId(){
		return id;
	}
	
	
	/**
	 * @return the capacityMax
	 */
	public int getCapacityMax() {
		return capacityMax;
	}

	
	/**
	 * give the station list and the state for each bike
	 * @return the vehicles
	 */
	public Map<TwoWheeledVehicle, State> getVehicles() {
		return vehicles;
	}
	
	
	
	/**
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
	 * gives the repairer if he is present otherwise null
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
	 * @return the number of vehicles which are available
	 */
	public int getAvailableVehicleCount() {
        return this.availableVehicleNB;
	 }
	
	
	/**
	 * Add a vehicle to the station.
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
	
	/**
	 * mettre une exception here
	 * @param vehicle
	 */
	public void removeVehicle(TwoWheeledVehicle v) {
		v.setStation(null);
		vehicles.remove(v);
	}
	
	/**
	 * @param v the vehicle that we want change the state.
	 * @param s thes new vehicle's state
	 */
	public void setStateVehicle(TwoWheeledVehicle v, State s) {
		vehicles.replace(v, s);
	}
	
	/**
	 * increase the available vehicle number
	 */
	public void increaseAvailableVehicleNB() {
		if (this.availableVehicleNB < this.capacityMax) {
			this.availableVehicleNB = this.availableVehicleNB + 1;
		}
	}
	
	/**
	 * decrease the available vehicle number
	 */
	public void decreaseAvailableVehicleNB() {
		if (this.availableVehicleNB > 0) {
			this.availableVehicleNB = this.availableVehicleNB - 1;
		}
	}
	
	/**
	 * 
	 */
	public void stoleAVehicle() {
		if (this.getAvailableVehicleCount() == 1) {
			for (Map.Entry<TwoWheeledVehicle, State> vs : this.vehicles.entrySet()) {
				if (vs.getValue().equals(State.AVAILABLE)) {
					TwoWheeledVehicle v = vs.getKey();
					v.stole();
					System.out.println("Warning a vehicle has been stolen");
					break;
				}
			}
		}
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
	
	
	public void displayVehicles() {
		for (Map.Entry<TwoWheeledVehicle, State> set : this.vehicles.entrySet()) {
			System.out.println(set.getKey().toString() + " : " + set.getValue().name());
		}
	}
	
	/**
	 *ToString()
	 */
	public String toString() {
		return "Station "+ this.id ;
	}

}

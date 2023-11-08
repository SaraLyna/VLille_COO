package projetCOO.station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import projetCOO.control.ControlCenter;
import projetCOO.control.repairer.Repairer;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;


/**
*Station class representing the station
*where are the vehicles located
*/
public class Station {
	protected int id;
	protected int capacityMax;
	protected List<TwoWheeledVehicle> vehicles;
	// à modifier
	protected Map<Repairer,TwoWheeledVehicle> repairers ;
	protected int availableVehicleNB;
	protected ControlCenter controlCenter;

	/**
	* Constructor of the class Station
	*/
	public Station(int id, ControlCenter c){
			this.id = id;
			this.controlCenter = c;
        	this.initCapacityMax();;
        	this.vehicles = new ArrayList<>();
        	this.repairers = new HashMap<>();
        	this.availableVehicleNB = this.capacityMax;
	}
	
	/**
	 * give the the station's id
	 * @return Int
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * give the ControlCenter that manages this station
	 * @return ControlCenter
	 */
	public ControlCenter getControlCenter() {
		return this.controlCenter;
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
	public List<TwoWheeledVehicle> getVehicles() {
		return vehicles;
	}
	
	/**
	 * gives the repairer if he is present otherwise null
	 * @return the repairer
	 */
	public Map<Repairer, TwoWheeledVehicle> getRepairer() {
		return repairers;
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
            		vehicles.add(v); 
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
	 * mettre une exception ici 
	 * add a Repairer for a vehicle in this station
	 */
	public void addRepairer(Repairer r, TwoWheeledVehicle v) {
		this.repairers.put(r, v);
	}
	
	/**
	 * mettre une exception ici
	 * remove a Repairer of this sation
	 */
	public void removeRepairer(Repairer r) {
		this.repairers.remove(r);
	}	
	
	/*
	 * ask a Repairer for this station
	 */
	public void needRepairer(TwoWheeledVehicle v) {
		this.controlCenter.sendRepairer(this , v, v.askRepairer());
	}
	    
	/**
     * -------------------------------------------------------------
     * ----------------------- Inits Methods ------------------------
     * -------------------------------------------------------------      
     */
	
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
     * -------------------------------------------------------------
     * ----------------------- Display Methods ------------------------
     * -------------------------------------------------------------      
     */
	
	
	public void displayVehicles() {
		Iterator<TwoWheeledVehicle> i = this.vehicles.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}
		System.out.println("");
	}
	
	
	
	/**
	 *ToString() method
	 */
	public String toString() {
		return "Station "+ this.id ;
	}

}

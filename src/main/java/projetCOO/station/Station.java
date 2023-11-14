package projetCOO.station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import projetCOO.Exception.OutOfLimit;
import projetCOO.control.ControlCenter;
import projetCOO.control.worker.repairer.Repairer;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;


/**
*Station class representing the station
*where are the vehicles located
*/
public class Station {
	protected int id;
	protected int capacityMax;
	protected List<TwoWheeledVehicle> vehicles;
	protected List<TwoWheeledVehicle> outService;
	// à modifier
	protected Map<Repairer,TwoWheeledVehicle> repairers ;
	protected ControlCenter controlCenter;

	/**
	* Constructor of the class Station
	*/
	public Station(int id, ControlCenter c){
			this.id = id;
			this.controlCenter = c;
        	this.initCapacityMax();;
        	this.vehicles = new ArrayList<>();
        	this.outService = new ArrayList<>();
        	this.repairers = new HashMap<>();
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
	 * gives the capacity max in this station
	 * @return int
	 */
	public int getCapacityMax() {
		return capacityMax;
	}

	
	/**
	 * gives the vehicles available list in this station
	 * @return List<TwoWheeledVehicle>
	 */
	public List<TwoWheeledVehicle> getVehicles() {
		return vehicles;
	}
	
	/**
	 * gives the vehicles list that are out of service in this station
	 * @return List<TwoWheeledVehicle>
	 */
	public List<TwoWheeledVehicle> getOutService() {
		return this.outService;
	}
	
	/**
	 * gives the repairer if he is present otherwise null
	 * @return Map<Repairer, TwoWheeledVehicle>
	 */
	public Map<Repairer, TwoWheeledVehicle> getRepairer() {
		return repairers;
	}
	
	/**
	 * Add a vehicle in this station.
	 * @param TwoWheeledVehicle
	 */
	public void addVehicle(TwoWheeledVehicle v) throws OutOfLimit{
		if (vehicles.size() + outService.size() < capacityMax) {
            vehicles.add(v); 
            v.setStation(this);
            		
        } 
		else {
            throw new OutOfLimit("The station is at maximum capacity. Cannot add more bikes.");
		}
		
	}
	
	
	
	/**
	 * removes a vehicles of this station
	 * @param TwoWheeledVehicle
	 */
	public void removeVehicle(TwoWheeledVehicle v) {
		v.setStation(null);
		vehicles.remove(v);
	}
	
	/**
	 * add a vehicle out of service in this station
	 * @param TwoWheeledVehicle
	 */
	public void addVehicleOutService(TwoWheeledVehicle v) {
		this.outService.add(v);
		v.setStation(this);
	}
	
	/**
	 * removes a vehicles who was considered as out of service of this station
	 * @param TwoWheeledVehicle
	 */
	public void removeVehicleOutService(TwoWheeledVehicle v) {
		this.outService.remove(v);
		this.vehicles.add(v);
	}
	
	/**
	 * add a Repairer for a vehicle in this Station
	 * @param r, a Repairer who come in this Station
	 * @param v, a Vehicle that has need a Repairer
	 */
	public void addRepairers(Repairer r, TwoWheeledVehicle v) {
		this.repairers.put(r, v);
	}
	
	/**
	 * 
	 * remove a Repairer of this Station
	 * @param r, a Repairer who leaves the Station
	 */
	public void removeRepairers(Repairer r) {
		this.repairers.remove(r);
	}	
	
	/**
	 * ask to the control center an list of Repairers and assigned a Repairer to a Vehicle in this Station
	 * @param v, a vehicle that has need a reparation or a technique control
	 */
	public void needRepairer(TwoWheeledVehicle v) {
		for (Map.Entry<Repairer, TwoWheeledVehicle> set : this.getRepairer().entrySet()) {
			if (v.isGoodRepairer(set.getKey())) {
				this.controlCenter.sendRepairer(this , v, set.getKey());
				break;
			}
		}
		this.controlCenter.sendRepairer(this , v, v.askRepairer(this.controlCenter.getRepairersList()));
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

package projetCOO.station;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projetCOO.Exception.NotExisting;
import projetCOO.Exception.OutOfLimit;
import projetCOO.control.ControlCenter;
import projetCOO.control.worker.Worker;
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
	protected List<Worker> workers ;
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
        	this.workers = new ArrayList<>();
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
	 * gives Workers in this station
	 * @return Map<Worker, TwoWheeledVehicle>
	 */
	public List<Worker> getWorker() {
		return this.workers;
	}
	
	/**
	 * Add a vehicle in this station.
	 * @param TwoWheeledVehicle
	 */
	public void addVehicle(TwoWheeledVehicle v) throws OutOfLimit{
		if (vehicles.size() + outService.size() < capacityMax) {
            vehicles.add(v); 
            v.setStation(this);
            this.controlCenter.addVehicle(v);
            		
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
		this.controlCenter.removeVehicle(v);
		this.controlCenter.addVehicleOnRoad(v);
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
	 * @param w, a Worker who come in this Station
	 * @param v, a Vehicle that has need a Repairer
	 */
	public void addWorker(Worker w) {
		this.workers.add(w);
	}
	
	/**
	 * 
	 * remove a Repairer of this Station
	 * @param w, a Worker who leaves the Station
	 */
	public void removeWorker(Worker w) {
		this.workers.remove(w);
	}	
	
	/**
	 * ask to the control center an list of Repairers and assigned a Repairer to a Vehicle in this Station
	 * @param v, a vehicle that has need a reparation or a technique control
	 */
	public void needRepairer(TwoWheeledVehicle v) {
		try {
			for (Worker w : this.workers) {
				if (v.isGoodRepairer(w)) {
					this.controlCenter.sendWorker(this , v, w);
					break;
				}
			}
			this.controlCenter.sendWorker(this , v, v.askRepairer(this.controlCenter.getWorkerList()));
		}catch (NotExisting e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * stole a vehicle in this Station if the number of vehicle in the Station is equal to 1.
	 * @param v, a vehicle 
	 */
	public void stole(TwoWheeledVehicle v) {
		if (this.vehicles.size() == 1) {
			this.removeVehicle(v);
		}
		
		
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

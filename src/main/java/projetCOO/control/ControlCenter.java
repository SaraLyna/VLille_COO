package projetCOO.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import projetCOO.Exception.OutOfLimit;
import projetCOO.control.worker.Worker;
import projetCOO.control.worker.repairer.Repairer;
import projetCOO.planning.Planning;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;


/**
*The class that represent the control center
*/
public class ControlCenter{
	private Map<Integer,Station> stationList;
	private List<Repairer> repairersList; 
	private List<Station> stationsNeedsToBeverify;
	private Map<TwoWheeledVehicle, Integer> vehiclesList;
	private Map<TwoWheeledVehicle, Integer> vehiclesOnRoad;
	private int nbStation;
	 private Planning planning;
	

	/**
	* Constructor of the class
	*/
	public ControlCenter(int n){
		this.nbStation = n;
		this.initStation();
		this.stationsNeedsToBeverify = new ArrayList<>();
		this.repairersList = new ArrayList<>();
		this.vehiclesList = new HashMap<>();
		this.vehiclesOnRoad = new HashMap<>();
	}
	
	
	
	/**
	 * gives the stations list linked to this ControlCenter
	 * @return Map<Integer,Station>
	 */
	public Map<Integer,Station> getStationList() {
		return stationList;
	}
	
	/**
	 * gives the repairers list who work in this ControlCenter
	 * @return Map<Repairer, Boolean>
	 */
	public List<Repairer> getRepairersList() {
		return this.repairersList;	
	}
	
	
	
	/**
	 * @return station with bike to verify
	 */
	public List<Station> getStationWithBikeToverify() {
		return this.stationsNeedsToBeverify;
	}
	
	/**
	 * @return the list of all the vehicles in all stations (the available vehicles)
	 */
	public Map<TwoWheeledVehicle, Integer> getVehiclesList() {
		return this.vehiclesList;
	}
	
	/** 
	 * @return the vehicles which are not available (in the road, taken)
	 */
	public Map<TwoWheeledVehicle, Integer> getVehiclesOnRoad() {
		return this.vehiclesOnRoad;
	}
	
	/**
     * Set the Planning instance.
     * @param planning 
     */
    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

	
	
	
	
	/**
	 * adds a station to the control center
	 * @param station
	 */
	public void addStation(Station station) {
		stationList.put(station.getId(), station);
		
	}
	
	/**
	 * removes a station to the ControlCenter
	 * @param station
	 */
	public void removeStation(Station s) {
		this.stationList.remove(s.getId());
	}
	
	/**
	 * adds a worker to the ControlCenter
	 * @param Worker 
	 */
	public void addRepairers(Repairer r) {
		this.repairersList.add(r);
	}
	
	/**
	 * removes a worker of the ControlCenter
	 * @param Worker
	 */
	public void removeRepairers(Repairer r) {
		this.repairersList.remove(r);
	}
	
	/**
	 * add a vehicle which is now available in the vehicle list (inventory).
	 */
	public void addVehicle(TwoWheeledVehicle v) {
		this.vehiclesList.put(v, this.vehiclesList.size());
	}
	
	/**
	 * removes a vehicle in the vehicle list if it's not available anymore, taken by someone.
	 * @param v
	 */
	public void removeVehicle(TwoWheeledVehicle v) {
		this.vehiclesList.remove(v);
	}
	
	/**
	 * add a vehicle which is not available in a station to the inventory of the taken vehicles.
	 * @param v
	 */
	public void addVehicleOnRoad(TwoWheeledVehicle v) {
		this.vehiclesOnRoad.put(v, this.vehiclesOnRoad.size());
	}
	
	/**
	 * removes a vehicle in the list of taken vehicles if it available.
	 * @param v
	 */
	public void removeVehicleOnRoad(TwoWheeledVehicle v) {
		this.addVehicle(v);
		this.vehiclesOnRoad.remove(v);
	}

	
	
	/**
	 * initialize stations
	 */
	public void initStation() {
		this.stationList = new HashMap<>(); 
		for (int i = 0;i<this.nbStation; i++) {
			Station s = new Station(i, this);
			this.addStation(s);
		}
		
	}
	
	
	
	
	/**
	 * verification method 
	 */
	public void verification() {

	}

	
	/**
	 * send a repairer in a Station
	 * @param station
	 * @param v
	 * @param worker
	 */
	public void sendRepairer(Station station, TwoWheeledVehicle v, Worker worker) {
		station.addWorker(worker,v);
		worker.setStation(station);
	}
	
	
	
	/**
	 * @return the collection of the different vehicles in a station
	 */
	public Map<Integer, TwoWheeledVehicle> collectVehicles() {
		Map<Integer, TwoWheeledVehicle> vs = new HashMap<>();
		for (Map.Entry<Integer, Station> s : this.stationList.entrySet()) {
			Iterator<TwoWheeledVehicle> iterator = s.getValue().getVehicles().iterator();

	        while (iterator.hasNext()) {
				vs.put(vs.size(), iterator.next());
	        }
		}
		return vs;
	}
	
	
	
	
	/**
	 * redistribution of the different vehicles in the stations in a random way
	 */
	public void redistribution() {
		Map<Integer, TwoWheeledVehicle> vs = this.collectVehicles();
		while (!vs.isEmpty()) {
			for (Map.Entry<Integer, Station> s : this.stationList.entrySet()) {
				if (s.getValue().getVehicles().size() < s.getValue().getCapacityMax()) {
					int randomNB = (int) (Math.random() * (vs.size() + 1));
					TwoWheeledVehicle b = vs.get(randomNB);
					try {
						s.getValue().addVehicle(b);
					} catch (OutOfLimit e) {
						e.printStackTrace();
					}
					vs.remove(randomNB);
				}
			}
		}
	}
	
	
	
	/**
	 * just show the stations
	 */
	public void show() {
		for (Map.Entry<Integer, Station> set : this.stationList.entrySet()) {
				System.out.println(set.getValue().toString());
		}
	}



}

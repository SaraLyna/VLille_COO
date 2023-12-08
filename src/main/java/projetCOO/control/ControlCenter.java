package projetCOO.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import projetCOO.Exception.AlreadyExisting;
import projetCOO.Exception.NotExisting;
import projetCOO.Exception.OutOfLimit;
import projetCOO.control.worker.Worker;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;


/**
*The class that represent the control center
*/
public class ControlCenter{
	private Map<Integer,Station> stationList;
	private List<Worker> workerList; 
	private Map<TwoWheeledVehicle, Integer> vehiclesList;
	private Map<TwoWheeledVehicle, Integer> vehiclesOnRoad;
	private int nbStation;
	

	/**
	* Constructor of the class
	*/
	public ControlCenter(int n){
		this.nbStation = n;
		this.initStation();
		this.workerList = new ArrayList<>();
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
	public List<Worker> getWorkerList() {
		return this.workerList;	
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
	 * adds a station to the control center
	 * @param station
	 * @exception AlreadyExisting
	 */
	public void addStation(Station station) throws AlreadyExisting{
		if (this.stationList.containsKey(station.getId()) || this.stationList.containsValue(station) ) {
			throw new AlreadyExisting("the Station already exists or the a Station has the same ID");
		}
		else {
			stationList.put(station.getId(), station);
		}
		
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
	public void addWorker(Worker w) {
		this.workerList.add(w);
	}
	
	/**
	 * removes a worker of the ControlCenter
	 * @param Worker
	 */
	public void removeWorker(Worker w) {
		this.workerList.remove(w);
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
			try {
				this.addStation(s);
			} catch (AlreadyExisting e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	/**
	 * send a repairer in a Station
	 * @param station
	 * @param v
	 * @param worker
	 */
	public void sendWorker(Station station, TwoWheeledVehicle v, Worker worker) throws NotExisting{
		if (!this.stationList.containsValue(station)) {
			throw new NotExisting("The Station doesn't exists");
		}
		else if (!this.workerList.contains(worker)) {
			throw new NotExisting("The Worker doesn't exists");
		}
		else if (!this.vehiclesList.containsKey(v)) {
			throw new NotExisting("The Vehicle doesn't exists");
		}
		else {
			station.addWorker(worker);
			worker.addTask(v);
		}
	}
	
	
	
	/**- jar:
	 * @return the collection of the different vehicles in a station
	 */
	public Map<Integer, TwoWheeledVehicle> collectVehicles() {
		Map<Integer, TwoWheeledVehicle> vs = new HashMap<>();
		for (Map.Entry<Integer, Station> s : this.stationList.entrySet()) {
			Iterator<TwoWheeledVehicle> iterator = s.getValue().getVehicles().iterator();

	        while (iterator.hasNext()) {
	        	TwoWheeledVehicle b = iterator.next();
	        	b.setStation(null);
				vs.put(vs.size(), b);
				iterator.remove();
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
			for (int i = 0; i < this.stationList.size(); i++) {
				if (this.stationList.get(i).getVehicles().size() < this.stationList.get(i).getCapacityMax()) {
					Optional<Integer> n = vs.keySet().stream().findAny();
					TwoWheeledVehicle b = vs.get(n.get());
					try {
						this.stationList.get(i).addVehicle(b);
					} catch (OutOfLimit e) {
						e.printStackTrace();
					}
					vs.remove(n.get());
				}
			}
		}
	}
	
	/**
	 * the method who does the action
	 */
	public void run() {
		for (Worker w : this.workerList) {
			w.action();
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

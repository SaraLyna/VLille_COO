package projetCOO.control;

import projetCOO.control.repairer.Repairer;
import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import java.util.*;
import java.util.Map.Entry;


/**
*The class that represent the control center
*/
public class ControlCenter{
	private Map<Integer,Station> stationList;
	private Map<Repairer, Boolean> repairersList; 
	private List<Station> stationsNeedsToBeverify;
	private int nbStation;
	

	/**
	* Constructor of the class
	*/
	public ControlCenter(int n){
		this.nbStation = n;
		this.initStation();
		this.stationsNeedsToBeverify = new ArrayList<>();
		this.repairersList = new HashMap<>();
	}
	
	
	
	/**
	 * gives the stations list linked to this ControlCenter
	 * @return Map<Integer,Station>
	 */
	public Map<Integer,Station> getStationList() {
		return stationList;
	}
	
	/*
	 * gives the repairers list who work in this ControlCenter
	 * @return Map<Repairer, Boolean>
	 */
	public Map<Repairer, Boolean> getRepairersList() {
		return this.repairersList;	
	}
	
	
	
	/**
	 * @return station with bike to verify
	 */
	public List<Station> getStationWithBikeToverify() {
		return this.stationsNeedsToBeverify;
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
		this.repairersList.put(r, true);
	}
	
	/*
	 * removes a worker of the ControlCenter
	 * @param Worker
	 */
	public void removeRepairers(Repairer r) {
		this.repairersList.remove(r);
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
	 */
	public void sendRepairer(Station station, TwoWheeledVehicle v, Repairer r) {
		station.addRepairer(r,v);
		r.setStation(station);
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
					s.getValue().addVehicle(b);
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

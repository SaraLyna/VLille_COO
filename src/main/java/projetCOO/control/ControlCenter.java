package projetCOO.control;

import projetCOO.control.repairer.Repairer;
import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.Bike;

import java.util.*;
import java.util.Map.Entry;

/**
*The class that represent the control center
*/
public class ControlCenter{
	private Map<Integer,Station> stationList;
	private List<Station> stationWithBikeToverify;
	private Map<Repairer, Integer> repairerList;
	private int nbStation;
	

	/**
	* Constructor of the class
	*/
	public ControlCenter(int n){
		this.nbStation = n;
		this.initStation();
		this.initRepairer();
		this.stationWithBikeToverify = new ArrayList<>();
	}
	
	
	
	/**
	 * @return stationList
	 */
	public Map<Integer,Station> getStationList() {
		
		return stationList;
	}
	
	
	
	/**
	 * @return repairerList
	 */
	public Map<Repairer, Integer> getRepairerList() {
		return repairerList;
	}
	
	/**
	 * @return 
	 */
	public List<Station> getStationWithBikeToverify() {
		return this.stationWithBikeToverify;
	}
	
	
	/**
	 * @param station
	 */
	public void addStation(Station station) {
		stationList.put(station.getId(), station);
		
	}
	
	public void addRepairer(Repairer repairer, int i) {
		repairerList.put(repairer, i);
		
	}
	
	public void initStation() {
		this.stationList = new HashMap<>(); 
		for (int i = 0;i<this.nbStation; i++) {
			Station s = new Station(i);
			this.addStation(s);
		}
		
	}
	
	
	public void initRepairer() {
		this.repairerList = new HashMap<>(); 
		for (int i = 0;i<this.nbStation; i++) {
			Repairer s = new Repairer(this);
			this.addRepairer(s,i);
		}
		
	}
	
	public void verification() {
		for (Map.Entry<Integer, Station> s : this.stationList.entrySet()) {
			for (Entry<TwoWheeledVehicle, State> b : s.getValue().getBikes().entrySet()) {
				if (b.getValue().equals(State.OUTOFSERVICE) || b.getKey().isDamaged()) {
					this.stationWithBikeToverify.add(s.getValue());
				}
			}
		}
	}
	
	
	
	/**
	 * @param station
	 */
	public void sendRepairer() {
		Repairer r;
		for (int i = 0; i<this.stationWithBikeToverify.size(); i++) {
			r = (Repairer) this.repairerList.keySet().toArray()[i];
			this.stationWithBikeToverify.get(i).setRepairer(r);
			r.setStation(this.stationWithBikeToverify.get(i));
		}
	}
	
	public void show() {
		for (Map.Entry<Integer, Station> set : this.stationList.entrySet()) {
				System.out.println(set.getValue().toString());
		}
	}



}

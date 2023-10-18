package projetCOO.control;

import java.util.Map;
import java.util.HashMap;

import state.State;
import station.Station;

/**
*The class that represent the control center
*/
public class ControlCenter{
	private Map<Integer,Station> stationList;
	private Map<State, Repairer> repairerList;
	private int nbStation;
	

	/**
	* Constructor of the class
	*/
	public ControlCenter(int n){
		this.nbStation = n;
		this.initStation();
		this.initRepairer();
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
	public Map<State, Repairer> getRepairerList() {
		return repairerList;
	}
	
	
	/**
	 * @param station
	 */
	public void addStation(Station station) {
		stationList.put(station.getId(), station);
		
	}
	
	public void addRepairer(Repairer repairer) {
		repairerList.put(State.AVAILABLE, repairer);
		
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
			Repairer s = new Repairer(i);
			this.addRepairer(s);
		}
		
	}
	
	
	
	/**
	 * @param station
	 */
	public void sendRepairer(Station station) {
		
		
	}
	
	public void show() {
		for (Map.Entry<Integer, Station> set :
            this.stationList.entrySet()) {
				System.out.println(set.getValue().toString());
		}
	}



}

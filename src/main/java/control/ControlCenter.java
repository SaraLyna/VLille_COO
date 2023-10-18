package control;

import java.util.Map;
import java.util.HashMap;

import state.State;
import station.Station;

/**
*The class that represent the control center
*/
public abstract class ControlCenter{
	private Map<Integer,Station> stationList;
	private Map<Integer, State> repairerList;
	

	/**
	* Constructor of the class
	*/
	public ControlCenter(){
		stationList = new HashMap<>();
        repairerList = new HashMap<>();

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
	public Map<Integer,State> getRepairerList() {
		return repairerList;
	}
	
	
	/**
	 * @param station
	 */
	public void addStation(Station station) {
		stationList.put(station.getId(), station);
		
	}
	
	
	
	/**
	 * @param station
	 */
	public void sendRepairer(Station station) {
		
		
	}



}

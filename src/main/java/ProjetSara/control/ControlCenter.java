package ProjetSara.control;

import java.util.Map;
import java.util.HashMap;
import ProjetSara.state.State;
import ProjetSara.station.Station;

/**
*The class that represent the control center
*/
public abstract class ControlCenter{
	private Map<String,Station> stationList;
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
	public Map<String,Station> getStationList() {
		
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

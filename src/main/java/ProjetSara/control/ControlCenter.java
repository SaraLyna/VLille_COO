package ProjetSara.control;

import java.util.Map;

import ProjetSara.state.State;
import ProjetSara.station.Station;

/**
*
*/
public abstract class ControlCenter{
	private Map<String,Station> stationList;
	private Map<Integer, State> repairerList;
	

	/**
	*
	*/
	public ControlCenter(){

	}
	
	
	
	/**
	 * @return
	 */
	public Map<String,Station> getStationList() {
		
		return null;
	}
	
	
	
	/**
	 * @return
	 */
	public Map<Integer,State> getRepairerList() {
		return null;
	}
	
	
	/**
	 * @param station
	 */
	public void addStation(Station station) {
		
		
	}
	
	
	
	/**
	 * @param station
	 */
	public void sendRepairer(Station station) {
		
		
	}



}

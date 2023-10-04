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
	
	public Map<String,Station> getStationList() {
		
		return null;
	}
	
	public Map<Integer,State> getRepairerList() {
		return null;
	}
	public void addStation(Station station) {
		
		
	}
	
	public void sendRepairer(Station station) {
		
		
	}



}

package projetCOO.control.repairer;

import java.util.Map;

import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;



/**
 * the class that represent the repairer
 */
public class Repairer{
	
	protected Station station;

	
	/**
	 * Constructor of the class
	 */
	public Repairer(){
	  this.station = null;
	}
	
	
	
	/**
	 * @return station
	 */
	public Station getStation() {
		return this.station;
	}
	
	
	

	/**
	 * @param s
	 */
	public void setStation(Station s) {
		this.station = s;
	}
	
	
	
	
	/**
	 * when a vehicle leaves the station
	 */
	public void leaveStation() {
		this.getStation().setRepairer(null);
		this.setStation(null);
	}
	
	
 
   /**
    * repair the bike
    */
	public void action() {
		for (Map.Entry<TwoWheeledVehicle, State> v : this.station.getVehicles().entrySet()) {
			if (v.getValue().equals(State.OUTOFSERVICE) || v.getKey().isDamaged()) {
				v.getKey().repair();
			}
		}
	  
	}
	
	
}

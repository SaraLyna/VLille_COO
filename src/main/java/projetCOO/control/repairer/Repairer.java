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
	 * Set a station
	 * @param s
	 */
	public void setStation(Station s) {
		this.station = s;
	}
	
	
	
	
	/**
	 *Telling  when a vehicle leaves the station
	 */
	public void leaveStation() {
		this.getStation().removeRepairer(this);
		this.setStation(null);
	}
	
	
 
   /**
    * repair the bike
    */
	public void action(TwoWheeledVehicle v) {
		v.repair();
		v.resetNBUse();
		this.leaveStation();
	}
	
	
}

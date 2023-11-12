package projetCOO.control.repairer;

import java.util.HashMap;
import java.util.Map;

import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;



/**
 * the class that represent the repairer
 */
public class Repairer{
	
	protected Station station;
	protected int nbTask;
	protected Map<Integer, TwoWheeledVehicle> tasks;

	
	/**
	 * Constructor of the class
	 */
	public Repairer(){
	  this.station = null;
	  this.nbTask = 0;
	  this.tasks = new HashMap<>();
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
	 * gives the task's numbers of this repairer
	 * @return int
	 */
	public int getNBTask() {
		return this.nbTask;
	}
	
	
	/**
	 *Telling  when a vehicle leaves the station
	 */
	public void leaveStation() {
		this.getStation().removeRepairers(this);
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

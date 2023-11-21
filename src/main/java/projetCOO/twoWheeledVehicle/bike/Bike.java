package projetCOO.twoWheeledVehicle.bike;

import java.util.Iterator;
import java.util.List;

import projetCOO.Exception.OutOfLimit;
import projetCOO.Exception.OutOfService;
import projetCOO.control.worker.Worker;
import projetCOO.control.worker.repairer.Repairer;
import projetCOO.control.worker.repairer.RepairerElectric;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;



/**
*this is the Bike class representing the bikes
*in the station
*/
public class Bike implements TwoWheeledVehicle {

	protected Station currentStation;
	protected Station station;
	protected String skin; 
	protected boolean isDamaged;
	protected int nbUse;
	private int useLimit;

	
	/**
	* Constructor of the class Bike
	*/
	public Bike(String skin,Station station, int ul) {
		this.station = station;
		this.skin=skin;
		this.isDamaged= false;
		this.nbUse = 0;
		this.useLimit = ul;
	}

	
	
	/**
	 * give the station 
	 * @return Station
	 */
	public Station getStation() {
		return this.station;
	}
	
	
	
	/**
	 * Set a station
	 * @param Station, the station where the bike is
	 */
	public void setStation(Station s) {
		this.station = s;
	}
	
	/**
	 * return the use number of this bike.
	 * @return int
	 */
	public int getNBUse() {
		return this.nbUse;
	}
	
	/**
	 * resets the use number of this bike/
	 */
	public void resetNBUse() {
		this.nbUse =0;
	}
	
	/**
	 * return the use limit of this vehicle.
	 * @return int
	 */
	public int getUseLimit() {
		return this.useLimit;
	}
	
	/**
	 * defines the use limit of this vehicle.
	 * @param n the new number of use limit of this vehicle.
	 */
	public void setUseLimit(int n) {
		this.useLimit = n;
	}
	
	 
	/**
	 * applying a skin to the bike (color)
	 * @param s
	 */
	public void applySkin(String s) {
		this.skin = s;
	}
	
	
	
	/**
	 *tells if a bike is damaged or not
	 *@return boolean
	 */
	public boolean isDamaged() {
        return isDamaged;
    }

	
	
   	/**
   	 *the bike here is damaged
   	 */
   	public void takeDamage() {
        this.isDamaged= true;
    }
   	
   	/**
   	 * says if the bike is available or not 
   	 * @return boolean
   	 */
	@Override
	public boolean isAvailable() {
		return this.station != null;
	}
   	/**
   	 * use a bike in the station where the bike is and increase the use's number of this bike.
   	 * If the bike is already used or the use's number is out of limit so throw an exception.
   	 * @throws OutOfService
   	 */
	@Override
	public void startRental() throws OutOfService{
		if (this.station != null && this.nbUse < this.useLimit) {
	        this.getStation().removeVehicle(this);
	        this.nbUse++;
	    }
		else {
			throw new OutOfService("this Bike is Out Of Service");
		}
	}
	
	/**
	 * hand over the bike in a station
	 * @param s, the new Station where the Bike is
	 * @throws OutOfLimit 
	 */
	@Override
	public void stopRental(Station s) throws OutOfLimit {
		this.setStation(s);
		if (this.nbUse >= this.useLimit) {
			s.addVehicleOutService(this);
			s.needRepairer(this);
		}
		else {
			s.addVehicle(this);
		}
	}
   	
   	/**
   	 * asks a Repairer for this bike
   	 * @return Repairer
   	 */
   	public Worker askRepairer(List<Worker> repairersList) {
   		Iterator<Worker> i = repairersList.iterator();
   		int min = 1000000;
   		Worker save = null;
   		while (i.hasNext()) {
   			Worker r = i.next();
   			if (this.isGoodRepairer(r) && min > r.getNBTask()) {
   				save = r;
   				min = r.getNBTask();
   			}
   		}
   		return save;
   	}
   	
   	/**
   	 * says if is the right type of Repairer
   	 * @param Worker
   	 * @return boolean
   	 */
   	public boolean isGoodRepairer(Worker w) {
   		return w instanceof Repairer && !(w instanceof RepairerElectric);
   	}
   	
   	
   	
   	/**
   	 * Stole the bike.
   	 */
   	public void stole() {
   		this.station.stole(this);;
   	}
   	
	/**
	 *if the bike is not damaged he is repaired
	 */
	public void repair() {
		this.isDamaged = false;		
	}

	/**
	 * ToString() method
	 */
	public String toString() {
		return this.skin + " ClassicBike";
	}

	
}

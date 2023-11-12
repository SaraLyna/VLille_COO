package projetCOO.twoWheeledVehicle.bike;

import java.util.Map;

import projetCOO.Exception.OutOfService;
import projetCOO.control.repairer.Repairer;
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
	 * return the use number of this bike.
	 * @return int
	 */
	public int getNBUse() {
		return this.nbUse;
	}
	
	/**
	 * reset the use number of this bike/
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
	 * define the use limit of this vehicle.
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
   	
   	
	@Override
	public boolean isAvailable() {
		return this.getStation().getVehicles().contains(this);
	}
   	/**
   	 * mettre une exception
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
	 * mettre une exception ici
	 */
	@Override
	public void stopRental(Station s) {
		this.setStation(s);
		if (this.nbUse >= this.useLimit) {
			s.addVehicleOutService(this);
		}
		else {
			s.addVehicle(this);
		}
	}
   	
   	/**
   	 * ask a Repairer for this bike
   	 * @return Repairer
   	 */
   	public Repairer askRepairer(Map<Repairer, Boolean> repairersList) {
   		for (Map.Entry<Repairer, Boolean> set : repairersList.entrySet()) {
   			if (set.getKey() instanceof Repairer && repairersList.get(set.getKey()).equals(true)) {
   				return set.getKey();
   			}
   		}
   		return null;
   	}
   	
   	
   	
   	/**
   	 * Stole the bike.
   	 */
   	public void stole() {
   		this.getStation().removeVehicle(this);
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

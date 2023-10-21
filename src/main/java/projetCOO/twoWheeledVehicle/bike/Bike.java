package projetCOO.twoWheeledVehicle.bike;

import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;



/**
*this is the Bike class representing the bikes
*in the station
*/
public class Bike implements TwoWheeledVehicle {

	protected Station station;
	protected String skin; 
	protected boolean isDamaged;

	/**
	* Constructor of the class Bike
	*/
	public Bike(String skin,Station station) {
		this.station = station;
		this.skin=skin;
		this.isDamaged= false;
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
   	 *
   	 */
   	public void takeDamage() {
        this.isDamaged= true;
    }
   	
   	
   	
   	
   	/**
   	 *
   	 */
   	public void use() {
   		if (this.getStation().getVehicles().get(this).equals(State.AVAILABLE)) {
   			this.getStation().getVehicles().replace(this, State.UNAVAILABLE);
   		}
   		else {
   			this.getStation().getVehicles().replace(this, State.AVAILABLE);
   		}
   	}


   	
   	
	/**
	 *
	 */
	public void repair() {
		this.isDamaged = false;		
	}

	
	
	
	/**
	 *
	 */
	public String toString() {
		return "a " + this.skin + " bike";
	}




	@Override
	public String getType() {
		
		return null;
	}





	@Override
	public void startRental() {
	
		
	}





	@Override
	public void stopRental() {
		
		
	}





	@Override
	public boolean isAvailable() {
			return false;
	}





	@Override
	public void markForRepair() {
		
		
	}





	@Override
	public void performRepair() {
		
	}





	@Override
	public void markAsStolen() {
		
		
	}





	@Override
	public boolean isStolen() {
		
		return false;
	}





	@Override
	public void attachToStation(String stationId) {
		
		
	}





	@Override
	public String getCurrentStation() {
		
		return null;
	}
}

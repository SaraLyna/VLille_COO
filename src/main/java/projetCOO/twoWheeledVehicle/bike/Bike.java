package projetCOO.twoWheeledVehicle.bike;

import projetCOO.state.State;
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
		if (this instanceof ElectricBike) {
	        return "Electric";
	    } else {
	        return "Classic";
	    }
	}





	@Override
	public void startRental() {
		if (isAvailable()) {
	        this.getStation().getVehicles().replace(this, State.UNAVAILABLE);
	    }
		
	}





	@Override
	public void stopRental() {
		if (!isAvailable()) {
	        this.getStation().getVehicles().replace(this, State.AVAILABLE);
	    }
		
	}





	@Override
	public boolean isAvailable() {
		return this.getStation().getVehicles().get(this) == State.AVAILABLE;
	}





	@Override
	public void markForRepair() {
		if (!isDamaged()) {
	        takeDamage();
	    }
		
	}





	@Override
	public void performRepair() {
		if (isDamaged()) {
	        repair();
	    }
	}





	@Override
	public void markAsStolen() {
		 if (isAvailable()) {
		        this.getStation().getVehicles().replace(this, State.STOLEN);
		    }
		
	}





	@Override
	public boolean isStolen() {
		return this.getStation().getVehicles().get(this) == State.STOLEN;
	}

	@Override
	public Station getCurrentStation(Station s) {
		return currentStation;
	}

	@Override
	public void attachToStation(Station s) {
		currentStation = s;
		
	}





	



	
}

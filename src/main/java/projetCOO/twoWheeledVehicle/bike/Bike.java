package projetCOO.twoWheeledVehicle.bike;

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
	 * @return
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
	
	
	

	
	public boolean isDamaged() {
        return isDamaged;
    	}

   	public void takeDamage() {
        this.isDamaged= true;
    	}

	
	
	public String toString() {
		return "a " + this.skin + " bike";
	}





	public void repair() {
		this.isDamaged = false;		
	}





	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public void startRental() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void stopRental() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public void markForRepair() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void performRepair() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void markAsStolen() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public boolean isStolen() {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public void attachToStation(String stationId) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public String getCurrentStation() {
		// TODO Auto-generated method stub
		return null;
	}
}

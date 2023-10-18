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

	/**
	 *
	 */
	public String toString() {
		return "Bike{" +
                "station=" + station +
                ", skin='" + skin + '\'' +
                ", isDamaged=" + isDamaged +
                '}';
		
	}





	public void repair() {
		this.isDamaged=false;		
	}
}

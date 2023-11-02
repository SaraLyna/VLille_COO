package projetCOO.twoWheeledVehicle;

import projetCOO.station.Station;


/**
 * The class that represents all the vehicles having two wheels ! 
 * bikes, scooters...
 */
public interface TwoWheeledVehicle {

	/**
	 * applying a skin (color) to the vehicle concerned
	 * @param s
	 */
	public void applySkin(String s);
	
	
	/**
	 * Saying that a vehicle is damaged
	 */
	public void takeDamage();
	
	
	/**
	 * Saying that a vehicle is not damaged
	 */
	public void repair();
	
	
	/**
	 * Set a station
	 * @param station
	 */
	public void setStation(Station station);
	
	
	
	/**
	 * Saying if a vehicle is in use
	 */
	public void use();
	
	
	
	/**
	 * Saying that a vehicle is stolen
	 */
	public void stole();
	
	
	
	/**
	 * toString() method
	 * @return String
	 */
	public String toString();	
	
	
	
	/**
	 * Getting the type of a vehicle
	 * @return String
	 */
	public String getType();
	
	
	
	/**
	 * Starting rental
	 */
	public void startRental();
	
	
	
	/**
	 * Stoping rental
	 */
	public void stopRental();
	
	
	
	/**
	 * Saying if a vehicle is damaged or not
	 * @return bool
	 */
	public boolean isDamaged();	
	
	
	/**
	 * Saying if a vehicle is available or not
	 * @return bool
	 */
	public boolean isAvailable();
	
	
	
	/**
	 * mark the vehicle for repair
	 */
	public void markForRepair();
	
	
	
	/**
	 * repair the vehicle by a repairer
	 */
	public void performRepair();
	
	
	
	/**
	 * mark the vehicle as stolen
	 */
	public void markAsStolen();
	
	
	
	/**
	 * Saying if a vehicle is stolen or not
	 * @return bool
	 */
	public boolean isStolen();
    
    
    /**
     * @param s
     * @return the current station where is the vehicle
     */
    public Station getCurrentStation(Station s);

    
    
	/**
	 * attaching a vehicle to a specific station
	 * @param stationId
	 */
	void attachToStation(Station stationId);


}

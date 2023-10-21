 package projetCOO.twoWheeledVehicle;

import projetCOO.station.Station;

/**
 * The class that represent all the things having two wheeled ! 
 * bikes, trotinettes....
 */
public interface TwoWheeledVehicle {

	boolean isDamaged();
	
    void applySkin(String s);
	void takeDamage();
	void repair();
	void setStation(Station station);
	void use();
	
	String toString();
	
	String getType();
	
	void startRental();
	void stopRental();
	
	boolean isAvailable();
	
	void markForRepair();
	void performRepair();
	
	void markAsStolen();
    boolean isStolen();
    
    void attachToStation(String stationId);
    String getCurrentStation();

}

package projetCOO.twoWheeledVehicle;

import projetCOO.station.Station;


/**
 * The class that represent all the vehicles having two wheeled ! 
 * bikes, trotinettes....
 */
public interface TwoWheeledVehicle {

    void applySkin(String s);
    
	void takeDamage();
	
	void repair();
	
	void setStation(Station station);
	
	void use();
	
	String toString();	
	
	String getType();
	
	void startRental();
	
	void stopRental();
	
	boolean isDamaged();	
	
	boolean isAvailable();
	
	void markForRepair();
	
	void performRepair();
	
	void markAsStolen();
	
    boolean isStolen();
    
    
    Station getCurrentStation(Station s);

	void attachToStation(Station stationId);


}

package projetCOO.twoWheeledVehicle;

import projetCOO.station.Station;


/**
 * The class that represent all the vehicles having two wheeled ! 
 * bikes, trotinettes....
 */
public interface TwoWheeledVehicle {

	public void applySkin(String s);
	public void takeDamage();
	public void repair();
	public void setStation(Station station);
	public void use();
	public void stole();
	public String toString();	
	
	public String getType();
	
	public void startRental();
	
	public void stopRental();
	
	public boolean isDamaged();	
	
	public boolean isAvailable();
	
	public void markForRepair();
	
	public void performRepair();
	
	public void markAsStolen();
	
	public boolean isStolen();
    
    
    Station getCurrentStation(Station s);

	void attachToStation(Station stationId);


}

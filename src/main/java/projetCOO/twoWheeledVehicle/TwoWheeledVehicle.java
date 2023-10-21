 package projetCOO.twoWheeledVehicle;

/**
 * The class that represent all the things having two wheeled ! 
 * bikes, trotinettes....
 */
public interface TwoWheeledVehicle {

	/**
	 * @param s
	 */
    void applySkin(String s);
	
	
	boolean isDamaged();
	void takeDamage();
	void repair();
	
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

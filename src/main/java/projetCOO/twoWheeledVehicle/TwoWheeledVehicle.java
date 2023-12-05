package projetCOO.twoWheeledVehicle;

import java.util.List;

import projetCOO.Exception.OutOfLimit;
import projetCOO.Exception.OutOfService;
import projetCOO.control.worker.Worker;
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
	 * give the TwoWheeledVehicle's Station 
	 * @return Station
	 */
	public Station getStation();
	
	/**
	 * Set a station
	 * @param station
	 */
	public void setStation(Station station);
	
	/**
	 * return the use number of this vehicle.
	 * @return int
	 */
	public int getNBUse();
	
	/**
	 * sets the nb uses of this vehicle
	 * @param int
	 */
	public void setNBUse(int n);
	
	/**
	 * reset the use number of this bike/
	 */
	public void resetNBUse();
	
	/**
	 * return the use limit of this vehicle.
	 * @return int
	 */
	public int getUseLimit();
	
	/**
	 * define the use limit of this vehicle.
	 * @param n the new number of use limit of this vehicle.
	 */
	public void setUseLimit(int n);
	
	/**
	 * Saying that a vehicle is damaged
	 */
	public void takeDamage();
	
	
	/**
	 * Saying that a vehicle is not damaged
	 */
	public void repair();
	
	/**
	 * Saying that a vehicle is stolen
	 */
	public void stole();
	
	/*
	 * ask a repairer for this vehicle.
	 * @return Repairer
	 */
	public Worker askRepairer(List<Worker> list);
	
	/**
   	 * says if is the right type of Repairer
   	 * @param Worker
   	 * @return boolean
   	 */
   	public boolean isGoodRepairer(Worker worker);
	
	
	/**
	 * toString() method
	 * @return String
	 */
	public String toString();	
	
	
	/**
	 * Starting rental
	 * @throws OutOfService 
	 */
	public void startRental() throws OutOfService;

	/**
	 * Stoping rental
	 * @throws OutOfLimit 
	 */
	public void stopRental(Station s) throws OutOfLimit;
	
	
	
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
	
}

package projetCOO.control.worker.repairer;

import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.ElectricBike;

/**
 *the class that represents the repairer of the electrical vehicles
 */
/**
 * @author Sara Lyna
 *
 */
public class RepairerElectric extends Repairer{

	/**
	 * Constructor of the class
	 */
	public RepairerElectric() {
		super();
	}
	
	/**
	 * Display the Repairer Electric
	 * @return String
	 */
	@Override
	public String toString() {
		return " I'm a RepairerElectric";
	}
	
	
	
	
	//we can also add these methods to make the electric repairer more interesting
	public void performElectricRepair() {
	    // Add code to perform electric repairs
	}
	
	public void setElectricSpecialty(String specialty) {
	    // Set the electric specialty
	}

	public String getElectricSpecialty() {
	    // Get the electric specialty
	    return null;
	}
	
	
	/**
	 * control a vehicle.
	 * @param v
	 */
	public void controlVehicle(ElectricBike v) {
		super.controlVehicle(v);
		v.BatterieRecharge(100);
	}
	
	
}

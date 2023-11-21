package projetCOO.control.worker.repairer;

import java.util.Iterator;

import projetCOO.control.worker.Worker;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;



/**
 * the class that represent the repairer
 */
public class Repairer extends Worker{
	
	/**
	 * Constructor of the class
	 */
	public Repairer(){
		super();
	}
	
	/**
	 * control a vehicle.
	 * @param v
	 */
	public void controlVehicle(TwoWheeledVehicle v) {
		v.repair();
		v.resetNBUse();
	}
	
	/**
	 * verifies the other vehicles of the Station
	 */
	public void verifyOtherVehicle() {
		for (TwoWheeledVehicle v : this.getStation().getVehicles()) {
			if (v.isDamaged()) {
				this.addTask(v);
			}
		}
	}
 
   /**
    * repair the vehicle
    */
	@Override
	public void action() {
		this.verifyOtherVehicle();
		Iterator<TwoWheeledVehicle> i = this.tasks.get(super.getStation()).iterator();
		while (i.hasNext()) {
			this.controlVehicle(i.next());
		}
		this.leaveStation();
	}
	
	/**
	 * Display the Repairer
	 * @return String
	 */
	@Override
	public String toString() {
		return " I'm a Repairer";
	}
	
	
}

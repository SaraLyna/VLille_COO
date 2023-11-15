package projetCOO.control.worker.repairer;

import java.util.HashMap;
import java.util.Map;

import projetCOO.control.worker.Worker;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;



/**
 * the class that represent the repairer
 */
public class Repairer extends Worker{
	
	protected Station station;
	protected int nbTask;
	protected Map<Integer, TwoWheeledVehicle> tasks;

	
	/**
	 * Constructor of the class
	 */
	public Repairer(){
	  this.station = null;
	  this.nbTask = 0;
	  this.tasks = new HashMap<>();
	}
	
	/**
	 * gives the task's numbers of this repairer
	 * @return int
	 */
	public int getNBTask() {
		return this.nbTask;
	}
	
	/**
	 * add a task in the tasks list of this Repairer
	 * @param task
	 */
	public void addTask(TwoWheeledVehicle task) {
		this.tasks.put(task.getSerieNumero(), task);
	}
	
	/**
	 * remove a task in the tasks list of this Repairer
	 * @param task
	 */
	public void removeTask(TwoWheeledVehicle task) {
		this.tasks.remove(task.getSerieNumero());
	}
	
	
	/**
	 * increase the number of tasks of this repairer
	 * @param n, the number of tasks in addition
	 */
	public void increaseTasks(int n) {
		this.nbTask = this.nbTask + n;
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
		for (Map.Entry<Integer, TwoWheeledVehicle> set : this.tasks.entrySet()) {
			if(set.getValue().getStation().equals(this.station)) {
				this.controlVehicle(set.getValue());
			}
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

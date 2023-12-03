package projetCOO.control.worker;

import projetCOO.planning.Planning;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;

public abstract class Worker {
	
	protected int nbTask;
	protected Planning planning;
	
	public Worker() {
		this.nbTask = 0;
		this.planning = new Planning();
	}
	
	/**
	 * gives the task's numbers of this repairer
	 * @return int
	 */
	public int getNBTask() {
		return this.nbTask;
	}
	
	/**
	 * gives the planning of this Worker
	 * @return Planning
	 */
	public Planning getPlanning() {
		return this.planning;
	}
	
	public void setPlanning(Planning p) {
		this.planning = p;
	}
	
	/**
	 * increase the number of tasks of this repairer
	 * @param n, the number of tasks in addition
	 */
	public void increaseTasks(int n) {
		this.nbTask = this.nbTask + n;
	}
	
	public void addTask(TwoWheeledVehicle v) {
		this.planning.addTask(v);
	}
	
	/**
	 * make the action to manage in the station
	 */
	public abstract void action();

	public abstract String toString();
}

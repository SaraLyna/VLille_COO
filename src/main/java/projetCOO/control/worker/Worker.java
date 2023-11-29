package projetCOO.control.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;

public abstract class Worker {
	
	private Station station;
	protected int nbTask;
	protected Map<Station, List<TwoWheeledVehicle>> tasks;
	
	public Worker() {
		this.station = null;
		this.nbTask = 0;
		this.tasks = new HashMap<>();
	}
	
	
	/**
	 * @return station
	 */
	public Station getStation() {
		return this.station;
	}
	
	
	/**
	 * Set a station
	 * @param s
	 */
	public void setStation(Station s) {
		this.station = s;
	}
	
	/**
	 * gives the task's numbers of this repairer
	 * @return int
	 */
	public int getNBTask() {
		return this.nbTask;
	}
	
	/**
	 * gives taks of the worker
	 * @return Map<Station, List<TwoWheeledVehicle>>
	 */
	public Map<Station, List<TwoWheeledVehicle>> getTasks() {
		return this.tasks;
	}
	
	/**
	 * leaves the station
	 */
	public void leaveStation() {
		this.getStation().removeWorker(this);
		this.setStation(null);
	}
	
	
	/**
	 * increase the number of tasks of this repairer
	 * @param n, the number of tasks in addition
	 */
	public void increaseTasks(int n) {
		this.nbTask = this.nbTask + n;
	}
	
	/**
	 * add a task in the tasks list of this Repairer
	 * @param task
	 */
	public void addTask(TwoWheeledVehicle task) {
		if (this.tasks.containsKey(task.getStation())) {
			this.tasks.get(task.getStation()).add(task);
			this.increaseTasks(1);
		}
		else {
			this.tasks.put(task.getStation(), new ArrayList<>());
			this.addTask(task);
		}
	}
	
	
	/**
	 * remove a task in the tasks list of this Repairer
	 * @param task
	 */
	public void removeTask(TwoWheeledVehicle task) {
		this.tasks.remove(task.getStation());
	}
	
	/**
	 * make the action to manage in the station
	 */
	public abstract void action();

	public abstract String toString();
}

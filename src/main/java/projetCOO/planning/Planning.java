package projetCOO.planning;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import projetCOO.Exception.NotExisting;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.util.Pair;
import projetCOO.util.Time;

public class Planning {

	protected Map<Station, Pair<Time,  List<TwoWheeledVehicle>>> planning;
	protected List<Station> stationToVisit;
	
	public Planning() {
		this.planning = new HashMap<>();
		this.stationToVisit = new ArrayList<>();
	}
	
	/**
	 * gives the planning
	 * @return Map<Time, Pair<Station,  List<TwoWheeledVehicle>>>
	 */
	public Map<Station, Pair<Time,  List<TwoWheeledVehicle>>> getPlanning() {
		return this.planning;
	}
	
	/**
	 * gives stations to visit
	 * @return List<Station>
	 */
	public List<Station> getStationToVisit(){
		return this.stationToVisit;
	}
	
	/**
	 * add a station to visit
	 * @param s
	 */
	public void addStationToVisit(Station s) {
		this.stationToVisit.add(s);
	}
	
	public void removeStationToVisit(Station s) {
		this.stationToVisit.remove(s);
	}
	
	/**
	 * add a task in the tasks list of this Repairer
	 * @param task
	 */
	public void addTask(TwoWheeledVehicle task) {
		if (!this.planning.containsKey(task.getStation())) {
			this.addPlanning(task.getStation(), task);
			this.addStationToVisit(task.getStation());
		}
		else {
			this.planning.get(task.getStation()).getSecond().add(task);
		}
		
	}
	
	/**
	 * removes task in this planning
	 * @param task
	 * @throws NotExisting
	 */
	public void removeTask(TwoWheeledVehicle task) throws NotExisting {
		if (!this.planning.containsKey(task.getStation())) {
			throw new NotExisting("Not task existing");
		}
		if (this.planning.get(task.getStation()).getSecond().size() <= 1) {
			this.removePlanningAndStationToVisit(task.getStation());
		}
		else {
			this.planning.get(task.getStation()).getSecond().remove(task);
		}
	}
	
	/**
	 * add a new planning to this Planning 
	 * @param s
	 * @param v
	 */
	public void addPlanning(Station s, TwoWheeledVehicle v) {
		List<TwoWheeledVehicle> l = new ArrayList<>();
		l.add(v);
		Pair<Time, List<TwoWheeledVehicle>> p = new Pair<Time, List<TwoWheeledVehicle>>(new Time(LocalDateTime.now().getDayOfWeek().plus(1),14),l);
		this.planning.put(s, p);
	}
	
	/**
	 * removes a planning in this Planning
	 * @param s
	 */
	public void removePlanningAndStationToVisit(Station s) throws NotExisting {
		if (!this.planning.containsKey(s)) {
			throw new NotExisting("Not task existing");
		}
		else {
			this.planning.remove(s);
			this.removeStationToVisit(s);
		}
	}

}

package projetCOO.control.worker.repairer;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import projetCOO.Exception.NotExisting;
import projetCOO.control.worker.Worker;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.util.Pair;
import projetCOO.util.Time;



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
	public void verifyOtherVehicle(Station s) {
		for (TwoWheeledVehicle v : s.getVehicles()) {
			if (v.isDamaged()) {
				this.addTask(v);
			}
		}
	}
 
   /**
    * if it's time for the repairer to worker, the repairer will verifies vehicles in the station then repairs vehicles that need to be repair
    */
	@Override
	public void action() {
		for (Map.Entry<Station, Pair<Time,  List<TwoWheeledVehicle>>> set : this.planning.getPlanning().entrySet()) {
			Time t = set.getValue().getFirst();
			Station s = set.getKey();
			List<TwoWheeledVehicle> vs = set.getValue().getSecond();
			DayOfWeek d = t.getDay();
			int h = t.getHour();
			if (LocalDateTime.now().getDayOfWeek().equals(d) && (LocalDateTime.now().getHour() >= h) ) {
				this.verifyOtherVehicle(s);
				Iterator<TwoWheeledVehicle> i = vs.iterator();
				while (i.hasNext()) {
					this.controlVehicle(i.next());
					i.remove();
					this.increaseTasks(-1);
				}
				try {
					this.planning.removePlanningAndStationToVisit(s);
				} catch (NotExisting e) {
					e.printStackTrace();
				}
			}
		}
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

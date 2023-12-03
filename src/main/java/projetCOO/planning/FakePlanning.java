package projetCOO.planning;

import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.util.Pair;
import projetCOO.util.Time;


public class FakePlanning extends Planning{

	public FakePlanning() {
		super();
	}
	
	/**
	 * add a new planning to This Planning 
	 * @param s
	 * @param v
	 */
	@Override
	public void addPlanning(Station s, TwoWheeledVehicle v) {
		List<TwoWheeledVehicle> l = new ArrayList<>();
		l.add(v);
		DayOfWeek d = LocalDateTime.now().getDayOfWeek();
		int h = LocalDateTime.now().getHour();
		Pair<Time, List<TwoWheeledVehicle>> p = new Pair<Time,List<TwoWheeledVehicle>>(new Time(d,h),l);
		this.planning.put(s,p);
	}

}

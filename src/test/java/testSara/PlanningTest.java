package testSara;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.planning.Planning;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.Bike;
import projetCOO.util.Pair;
import projetCOO.util.Time;

public class PlanningTest {

	private Planning p;
	private DayOfWeek d;
	private int h;
	private Time t;
	
	@BeforeEach
	public void init() {
		this.p = new Planning();
		this.d = LocalDateTime.now().getDayOfWeek().plus(1);
		this.h = LocalDateTime.now().getHour();
		this.t = new Time(d,h);
	}
	
	@Test
	public void WeHaveOneStationToVisit() {
		p.addStationToVisit(new Station(0, null));
		assertEquals(1,p.getStationToVisit().size());
	}
	
	@Test
	public void WeHaveZeroTaskInThePlanning() {
		assertEquals(0,p.getPlanning().size());
	}
	
	@Test 
	public void WeHaveNewTaskInNewStation() {
		Station s = new Station(0,null);
		Bike b = new Bike(null, s, 0);
		Pair<Time,List<TwoWheeledVehicle>> pair = new Pair<Time, List<TwoWheeledVehicle>>(this.t, new ArrayList<TwoWheeledVehicle>());
		pair.getSecond().add(b);
		p.addTask(b);
		assertEquals(1,p.getPlanning().size());
		assertTrue(p.getPlanning().containsKey(s));
		assertEquals(14, p.getPlanning().get(s).getFirst().getHour());
		assertEquals(this.d, p.getPlanning().get(s).getFirst().getDay());
		assertEquals(1, p.getPlanning().get(s).getSecond().size());
	}

}

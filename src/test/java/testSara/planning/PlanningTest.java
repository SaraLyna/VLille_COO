package testSara.planning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.Exception.NotExisting;
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
	
	/**
	 * revoir certaine chose
	 */
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
	
	@Test 
	public void WeRemoveTask() {
		Station s = new Station(0,null);
		Bike b = new Bike(null, s, 0);
		Pair<Time,List<TwoWheeledVehicle>> pair = new Pair<Time, List<TwoWheeledVehicle>>(this.t, new ArrayList<TwoWheeledVehicle>());
		pair.getSecond().add(b);
		p.addTask(b);
		try {
			p.removeTask(b);
		} catch (NotExisting e) {
			e.printStackTrace();
		}
		assertEquals(0,p.getPlanning().size());
		assertFalse(p.getPlanning().containsKey(s));
		assertFalse(p.getPlanning().containsValue(pair));
	}
	
	@Test 
	public void WeWantRemoveTaskButNotStationExisting() throws NotExisting {
		Station s = new Station(0,null);
		Bike b = new Bike(null, s, 0);
		NotExisting exception = assertThrows(NotExisting.class, () -> {
			p.removeTask(b);
		});
		assertEquals("Not task existing", exception.getMessage());
	}
	
	@Test 
	public void WeAddNewPlanning() {
		Station s = new Station(0,null);
		Bike b = new Bike(null, s, 0);
		this.p.addPlanning(s, b);
		assertEquals(1,this.p.getPlanning().size());
		assertTrue(this.p.getPlanning().get(s).getSecond().contains(b));
		assertTrue(this.p.getPlanning().containsKey(s));
	}
	
	@Test
	public void WeRemovePlanning() throws NotExisting {
		Station s = new Station(0,null);
		Bike b = new Bike(null, s, 0);
		p.addPlanning(s, b);
		p.removePlanningAndStationToVisit(s);
		assertEquals(0,p.getPlanning().size());
		assertFalse(this.p.getPlanning().containsKey(s));
	}
	
	@Test
	public void WeRemovePlanningButStationNotExisting() {
		Station s = new Station(0,null);
		NotExisting exception = assertThrows(NotExisting.class, () -> {
			p.removePlanningAndStationToVisit(s);
		});
		assertEquals("Not task existing", exception.getMessage());
	}

}

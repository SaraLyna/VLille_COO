package testSara;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.planning.FakePlanning;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;

public class FakePlanningTest {

	protected FakePlanning fp;
	protected DayOfWeek d;
	protected int h;
	protected Bike b;
	protected Station s;
	
	@BeforeEach
	public void init() {
		this.fp = new FakePlanning();
		this.d = LocalDateTime.now().getDayOfWeek();
		this.h = LocalDateTime.now().getHour();
		this.s = new Station(0,null);
		this.b = new Bike(null,s,3);
	}
	
	@Test
	public void WeAddNewPlanning() {
		fp.addPlanning(s, b);
		assertEquals(1,fp.getPlanning().size());
		assertTrue(fp.getPlanning().containsKey(s));
		assertTrue(this.fp.getPlanning().get(s).getSecond().contains(b));
		assertEquals(this.h, fp.getPlanning().get(s).getFirst().getHour());
		assertEquals(this.d, fp.getPlanning().get(s).getFirst().getDay());
	}
}

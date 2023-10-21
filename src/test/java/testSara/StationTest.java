package testSara;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.station.Station;



public class StationTest {

	private Station s;

	@BeforeEach
	public void init() {
		this.s = new Station(1);
	}

	@Test
	public void TheCapacityMaxBetween10And20() {
		assertTrue(s.getCapacityMax()>10 && s.getCapacityMax() < 20);
	}
	
	@Test
	public void TheNumberOfBikeEqualCapacityMax() {
		assertEquals(s.getCapacityMax(), s.getVehicles().size());
	}

}

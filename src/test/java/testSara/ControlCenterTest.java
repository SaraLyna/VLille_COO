package testSara;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.control.ControlCenter;
import projetCOO.station.Station;

public class ControlCenterTest {
	
	private ControlCenter c;
	private Station stationTest;
	
	@BeforeEach
	public void init() {
		this.c = new ControlCenter(1);
		this.stationTest = (Station) c.getStationList().keySet().toArray()[0];
	}
	
	@Test
	public void RepairerHasSent() {
		assertEquals(this.stationTest, (Station) c.getStationList().keySet().toArray()[0]);
	}

}

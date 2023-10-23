package testSara;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.control.repairer.Repairer;
import projetCOO.station.Station;

class RepairerTest {
	
	private Repairer r;
	private Station s;

	@BeforeEach
	public void init() {
		this.s =  new Station(0);
		this.r = new Repairer();
		this.r.setStation(s);
		this.s.setRepairer(r);
	}

	@Test
	public void RepairerLeaveTheStation() {
		this.r.leaveStation();
		assertEquals(this.r.getStation(), null);
		assertEquals(this.s.getRepairer(), null);
	}
	
	@Test
	public void RepairerRepairABike() {
		
	}

}

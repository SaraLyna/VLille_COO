package testSara;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.control.worker.repairer.Repairer;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;

class RepairerTest {
	
	private Repairer r;
	private Station s;

	@BeforeEach
	public void init() {
		this.s =  new Station(0, null);
		this.r = new Repairer();
		this.r.setStation(s);
		this.s.addWorker(r, null);
	}

	@Test
	public void RepairerLeaveTheStation() {
		this.r.leaveStation();
		assertEquals(this.r.getStation(), null);
		assertEquals(this.s.getWorker(), new HashMap<Repairer, TwoWheeledVehicle>());
	}
	
	@Test
	public void RepairerRepairABike() {
		
	}

}

package testSara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.control.worker.repairer.Repairer;
import projetCOO.station.Station;

class RepairerTest {
	
	private Repairer r;
	private Station s;

	@BeforeEach
	public void init() {
		this.s =  new Station(0, null);
		this.r = new Repairer();
		this.s.addWorker(r);
	}
	
	@Test
	public void RepairerRepairABike() {
		
	}

}

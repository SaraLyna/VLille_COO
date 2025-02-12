package testSara;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.Exception.AlreadyExisting;
import projetCOO.Exception.OutOfLimit;
import projetCOO.Exception.OutOfService;
import projetCOO.control.ControlCenter;
import projetCOO.control.worker.repairer.Repairer;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;



public class StationTest {

	private Station s;
	private ControlCenter c;

	@BeforeEach
	public void init() {
		this.c = new ControlCenter(0);
		this.s = new Station(1, this.c);
		try {
			this.c.addStation(s);
			for (int i = 0; i < s.getCapacityMax();i++) {
				s.addVehicle(new Bike("default", s, 3));
			}
		} catch (AlreadyExisting e1) {
			e1.printStackTrace();
		} catch (OutOfLimit e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TheCapacityMaxBetween10And20() {
		assertTrue(s.getCapacityMax()>=10 && s.getCapacityMax() <= 20);
	}
	
	@Test
	public void TheNumberOfVehicleEqualCapacityMax() {
		assertEquals(s.getCapacityMax(), s.getVehicles().size());
	}
	
	@Test
	public void WeAddAVehiculeWhileTheSationIsFull() throws OutOfLimit {
		OutOfLimit exception = assertThrows(OutOfLimit.class, () -> {
			this.s.addVehicle(new Bike("Red",this.s,3));
		});
		assertEquals("The station is at maximum capacity. Cannot add more bikes.", exception.getMessage());
	}
	
	@Test
	public void WeRemoveVehiculeInThisStation() {
		Bike b = (Bike) this.s.getVehicles().get(0);
		this.s.removeVehicle(b);
		assertFalse(this.s.getVehicles().contains(b));
	}
	
	@Test
	public void WeAddWorkerInStation() {
		Repairer r = new Repairer();
		this.s.addWorker(r);
		assertEquals(this.s.getWorker().size(), 1);
	}

	
	@Test 
	public void AVehicleIsUse() throws OutOfService {
		Bike b = (Bike) this.s.getVehicles().get(0);
		b.startRental();
		assertFalse(s.getVehicles().contains(b));
		assertEquals(s.getVehicles().size(), s.getCapacityMax() - 1);
	}
	
	@Test
	public void AvehicleIsHandedOver() throws OutOfService, OutOfLimit {
		Bike b = (Bike) this.s.getVehicles().get(0);
		b.startRental();
		b.stopRental(this.s);
		assertTrue(s.getVehicles().contains(b));
		assertEquals(s.getVehicles().size(), s.getCapacityMax());
	}
	
	@Test 
	public void TwoVehicleArentAvailable() throws OutOfService, OutOfLimit {
		this.c.addWorker(new Repairer());
		Bike b1 = (Bike) this.s.getVehicles().get(0);
		Bike b2 = (Bike) this.s.getVehicles().get(1);
		for (int i = 0; i < 3; i++) {
			b1.startRental();
			b1.stopRental(s);
			b2.startRental();
			b2.stopRental(s);
		}
		assertEquals(s.getVehicles().size(),s.getCapacityMax() - 2);
		assertEquals(s.getOutService().size(), 2);
	}

	@Test
	public void WeNeedRepairerInTheStation() {
		Repairer r = new Repairer();
		this.c.addWorker(r);
		this.s.needRepairer(this.s.getVehicles().get(0));
		assertEquals(this.s.getWorker().size(), 1);
		assertTrue(this.s.getWorker().contains(r));
	}
	
	@Test 
	public void WeNeedRepairerAndTheRepairerIsStillInTheStation() {
		Repairer r = new Repairer();
		Bike b2 = (Bike) this.s.getVehicles().get(1);
		this.s.addWorker(r);
		this.s.needRepairer(b2);
		assertEquals(this.s.getWorker().get(0), r);
	}
	
	@Test
	public void AVehicleIsStolen() throws OutOfLimit {
		Station station = new Station(2, this.c);
		try {
			this.c.addStation(station);
		} catch (AlreadyExisting e) {
			e.printStackTrace();
		}
		Bike b = new Bike(null, station, 3);
		station.addVehicle(b);
		station.stole(b);
		assertEquals(station.getVehicles().size(), 0);
	}
	

}

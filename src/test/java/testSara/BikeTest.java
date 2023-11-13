package testSara;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.Exception.OutOfLimit;
import projetCOO.Exception.OutOfService;
import projetCOO.control.ControlCenter;
import projetCOO.control.repairer.Repairer;
import projetCOO.control.repairer.RepairerElectric;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;


public class BikeTest {

	private Station s;
	private Bike bike;
	private ControlCenter c;

	@BeforeEach
	public void init() throws OutOfLimit {
		this.c = new ControlCenter(0);
		this.s = new Station(1,c);
		this.c.addStation(s);
		this.c.addRepairers(new Repairer());
		this.bike = new Bike("Red",this.s,3);
		this.s.addVehicle(bike);
	}
	
	@Test
	public void VehiculeAvailable() {
		assertTrue(this.bike.isAvailable());
	}
	
	@Test
	public void VehiculeNotAvailable() {
		this.s.removeVehicle(bike);
		assertFalse(this.bike.isAvailable());
	}
	
	@Test 
	public void WeUseTheBike() throws OutOfService {
		this.bike.startRental();
		assertFalse(this.s.getVehicles().contains(bike));
	}
	
	@Test
	public void WeHandOverTheBike() throws OutOfService, OutOfLimit {
		this.bike.startRental();
		assertFalse(this.s.getVehicles().contains(bike));
		this.bike.stopRental(s);
		assertTrue(this.s.getVehicles().contains(bike));
	}
	
	@Test 
	public void TheVehicleIsOutOfService() throws OutOfService, OutOfLimit {
		for (int i = 0; i < 3; i++) {
			this.bike.startRental();
			this.bike.stopRental(s);
		}
		assertEquals(this.s.getVehicles().size(), 0);
		OutOfService exception = assertThrows(OutOfService.class, () -> {
			this.bike.startRental();
		});
		assertEquals("this Bike is Out Of Service", exception.getMessage());
	}
	
	@Test
	public void WeAskRepairerForTheBike() {
		List<Repairer> repairerList = new ArrayList<>();
		Repairer r = new Repairer();
		RepairerElectric rE = new RepairerElectric();
		repairerList.add(rE);
		repairerList.add(new RepairerElectric());
		repairerList.add(r);
		Repairer test = this.bike.askRepairer(repairerList);
		assertEquals(r, test);
		assertFalse(test.equals(rE));
	}
	
	@Test
	public void WeAskRepairerForTheBikeWithTheLessNumberOfTasks() {
		List<Repairer> repairerList = new ArrayList<>();
		Repairer r1 = new Repairer();
		Repairer r2 = new Repairer();
		Repairer r3 = new Repairer();
		r1.increaseTasks(3);
		r2.increaseTasks(10);
		r3.increaseTasks(1);
		repairerList.add(r1);
		repairerList.add(r2);
		repairerList.add(r3);
		Repairer test = this.bike.askRepairer(repairerList);
		assertEquals(test, r3);
	}
	
	@Test
	public void isTheGoodRepairer() {
		assertTrue(this.bike.isGoodRepairer(new Repairer()));
		assertFalse(this.bike.isGoodRepairer(new RepairerElectric()));
	}
	
	@Test 
	public void VehiculeIsStolen() {
		this.bike.stole();
		assertEquals(this.bike.getStation(), null);
		assertFalse(this.s.getVehicles().contains(bike));
	}
	

}

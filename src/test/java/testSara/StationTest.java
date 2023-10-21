package testSara;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.Bike;



public class StationTest {

	private Station s;

	@BeforeEach
	public void init() {
		this.s = new Station(1);
		for (int i = 0; i < s.getCapacityMax();i++) {
			s.addVehicle(new Bike("default", s));
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
	public void VehicleIsTake() {
		TwoWheeledVehicle v = this.s.getOneVehicle(0);
		assertTrue(s.getVehicles().containsKey(v));
	}
	
	@Test 
	public void AVehicleIsUse() {
		Bike b = (Bike) this.s.getOneVehicle(0);
		b.use();
		assertTrue(s.getVehicles().containsValue(State.UNAVAILABLE));
	}
	
	@Test
	public void AvehicleIsHandedOver() {
		Bike b = (Bike) this.s.getOneVehicle(0);
		b.use();
		b.use();
		assertFalse(s.getVehicles().containsValue(State.UNAVAILABLE));
	}
	
	@Test 
	public void AllVehicleAreAvailable() {
		assertEquals(s.getAvailableVehicleCount(),s.getVehicles().size());
	}
	
	@Test 
	public void TwoVehicleArentAvailable() {
		Bike b1 = (Bike) this.s.getOneVehicle(0);
		Bike b2 = (Bike) this.s.getOneVehicle(1);
		b1.use();
		b2.use();
		assertEquals(s.getAvailableVehicleCount(),s.getVehicles().size() - 2);
	}

}

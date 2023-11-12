package testSara;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.Exception.OutOfService;
import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.Bike;



public class StationTest {

	private Station s;

	@BeforeEach
	public void init() {
		this.s = new Station(1, null);
		for (int i = 0; i < s.getCapacityMax();i++) {
			s.addVehicle(new Bike("default", s, 3));
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
	public void AVehicleIsUse() throws OutOfService {
		Bike b = (Bike) this.s.getVehicles().get(0);
		b.startRental();
		assertFalse(s.getVehicles().contains(b));
		assertEquals(s.getVehicles().size(), s.getCapacityMax() - 1);
	}
	
	@Test
	public void AvehicleIsHandedOver() throws OutOfService {
		Bike b = (Bike) this.s.getVehicles().get(0);
		b.startRental();
		b.stopRental(this.s);
		assertTrue(s.getVehicles().contains(b));
		assertEquals(s.getVehicles().size(), s.getCapacityMax());
	}
	
	@Test 
	public void TwoVehicleArentAvailable() throws OutOfService {
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
	
//	@Test
//	public void VehicleIsStolen() {
//		int count = this.s.getCapacityMax() - 1;
//		for (Map.Entry<TwoWheeledVehicle, State> v : this.s.getVehicles().entrySet()) {
//			if (count != 0) {
//				v.getKey().use();
//				count--;
//			}
//		}
//		this.s.stoleAVehicle();
//		assertEquals(this.s.getVehicles().size(), this.s.getCapacityMax() - 1);
//	}
	
//	@Test 
//	public void NoVehiclesAreStolen() {
//		this.s.stoleAVehicle();
//		assertEquals(this.s.getVehicles().size(), this.s.getCapacityMax());
//	}

}

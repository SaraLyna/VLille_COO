package testSara;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.control.ControlCenter;
import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.Bike;

public class ControlCenterTest {
	
	private ControlCenter c;
	private Station stationTest;
	
	@BeforeEach
	public void init() {
		this.c = new ControlCenter(1);
		this.stationTest = c.getStationList().get(0);
		for (int i = 0; i < stationTest.getCapacityMax();i++) {
			stationTest.addVehicle(new Bike("default", stationTest, 3));
		}
	}
	
	@Test
	public void WeTakeStation() {
		assertTrue(c.getStationList().containsValue(this.stationTest));
	}
	
//	@Test 
//	public void StationNeedsToBeVerify() {
//		Bike b = (Bike) this.stationTest.getOneVehicle(0);
//		this.stationTest.setStateVehicle(b, State.OUTOFSERVICE);
//		this.c.verification();
//		assertEquals(this.c.getStationWithBikeToverify().size(), 1);
//	}
	
	@Test 
	public void NoStationNeedsToBEVerify() {
		this.c.verification();
		assertEquals(this.c.getStationWithBikeToverify().size(), 0);
	}
	
//	@Test
//	public void RepairerHasSent() {
//		Bike b = (Bike) this.stationTest.getOneVehicle(0);
//		this.stationTest.setStateVehicle(b, State.OUTOFSERVICE);
//		this.c.verification();
//		this.c.sendRepairer(stationTest, b, b.askRepairer());
//		assertEquals(this.stationTest.getRepairer().size(), 1);
//	}
	
//	@Test 
//	public void AllVehiclesAreCollect() {
//		int tailleInit = this.stationTest.getVehicles().size();
//		Map<Integer, TwoWheeledVehicle> vehiclesCollected = this.c.collectVehicles();
//		assertEquals(vehiclesCollected.size(),tailleInit);
//		assertEquals(this.stationTest.getVehicles().size(), 0);
//	}
	
//	@Test 
//	public void OneVehicleStillInStationTest() {
//		int tailleInit = this.stationTest.getVehicles().size();
//		Bike b = (Bike) this.stationTest.getOneVehicle(0);
//		b.use();
//		Map<Integer, TwoWheeledVehicle> vehiclesCollected = this.c.collectVehicles();
//		assertEquals(vehiclesCollected.size(),tailleInit - 1);
//		assertEquals(this.stationTest.getVehicles().size(), 1);
//	}
	
//	@Test
//	public void WhenVehiclesAreCollectedVehiclesArentInStation() {
//		Bike b = (Bike) this.stationTest.getOneVehicle(0);
//		Map<Integer, TwoWheeledVehicle> vehiclesCollected = this.c.collectVehicles();
//		assertTrue(vehiclesCollected.containsValue(b));
//		assertEquals(b.getStation(), null);
//		assertFalse(this.stationTest.getVehicles().containsKey(b));
//	}

}

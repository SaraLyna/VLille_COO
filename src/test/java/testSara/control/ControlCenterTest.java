package testSara.control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.Exception.AlreadyExisting;
import projetCOO.Exception.NotExisting;
import projetCOO.Exception.OutOfLimit;
import projetCOO.control.ControlCenter;
import projetCOO.control.worker.repairer.Repairer;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.Bike;

public class ControlCenterTest {
	
	private ControlCenter c;
	private Station stationTest;
	
	@BeforeEach
	public void init() throws OutOfLimit {
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
	
	@Test
	public void ControlCenterHasOneStation() {
		assertEquals(1, this.c.getStationList().size());
	}
	
	@Test
	public void ControlCenterHasntRepairer() {
		assertEquals(0,this.c.getWorkerList().size());
	}
	
	@Test
	public void ControlCenterHasAsManyBikesAsTheStation() {
		assertEquals(this.stationTest.getCapacityMax(), this.c.getVehiclesList().size());
	}
	
	@Test
	public void NotVehiclesOnTheRoad() {
		assertEquals(0, this.c.getVehiclesOnRoad().size());
	}
	
	@Test 
	public void TheControlCenterManagesNewStation() {
		Station newStation = new Station(1, c);
		try {
			this.c.addStation(newStation);
		} catch (AlreadyExisting e) {
			e.printStackTrace();
		}
		assertEquals(2,this.c.getStationList().size());
	}
	
	@Test 
	public void WeAddNewStationButTheStationHasTheSameIDThatAnother() {
		AlreadyExisting exception = assertThrows(AlreadyExisting.class, () -> {
			this.c.addStation(new Station(0,c));
		});
		assertEquals(exception.getMessage(), "the Station already exists or the a Station has the same ID");
	}
	
	@Test 
	public void WeAddStationAlreadyExisting() {
		AlreadyExisting exception = assertThrows(AlreadyExisting.class, () -> {
			this.c.addStation(this.stationTest);
		});
		assertEquals(exception.getMessage(), "the Station already exists or the a Station has the same ID");
	}
	
	@Test
	public void WeRemoveAStation() {
		this.c.removeStation(stationTest);
		assertEquals(0,this.c.getStationList().size());
	}
	
	@Test
	public void WeAddAWorker() {
		this.c.addWorker(new Repairer());
		assertEquals(1, this.c.getWorkerList().size());
	}
	
	@Test
	public void WeRemoveRepairer() {
		Repairer r = new Repairer();
		this.c.addWorker(r);
		assertEquals(1, this.c.getWorkerList().size());
		this.c.removeWorker(r);
		assertEquals(0,this.c.getWorkerList().size());
	}
	
	@Test
	public void WeAddVehicleInTheListOfTheControlCenter() {
		this.c.addVehicle(new Bike("default", null, 3));
		assertEquals(this.stationTest.getCapacityMax() + 1, this.c.getVehiclesList().size());
	}
	
	@Test
	public void WeRemoveVehicleIntTheListOfTheControlCenter() {
		Bike b = (Bike) this.stationTest.getVehicles().get(0);
		this.stationTest.removeVehicle(b);
		assertEquals(this.stationTest.getCapacityMax() - 1, this.c.getVehiclesList().size());
	}
	
	@Test
	public void WeAddVehicleOnTheRoad() {
		this.c.addVehicleOnRoad(new Bike("default", null, 3));
		assertEquals(1,this.c.getVehiclesOnRoad().size());
	}
	
	@Test
	public void WeRemoveVehcileOnTheRoad() {
		Bike b = new Bike("default", null, 3);
		this.c.addVehicleOnRoad(b);
		assertEquals(1,this.c.getVehiclesOnRoad().size());
		this.c.removeVehicleOnRoad(b);
		assertEquals(0,this.c.getVehiclesOnRoad().size());
	}
	
	@Test
	public void WeSendWorker() throws NotExisting {
		Bike b = (Bike) this.stationTest.getVehicles().get(0);
		Repairer r = new Repairer();
		this.c.addWorker(r);
		this.c.sendWorker(stationTest, b, r);
		assertEquals(1,this.stationTest.getWorker().size());
		assertEquals(1,r.getPlanning().getStationToVisit().size());
		assertEquals(1, r.getPlanning().getPlanning().size());
		assertEquals(1,r.getPlanning().getPlanning().get(stationTest).getSecond().size());
	}
	
	@Test 
	public void WeSendWorkerButTheWorkerIsNotInTheWorkerList() {
		NotExisting exception = assertThrows(NotExisting.class, () -> {
			this.c.sendWorker(stationTest, stationTest.getVehicles().get(0), new Repairer());
		});
		assertEquals("The Worker doesn't exists", exception.getMessage());
	}
	
	@Test
	public void WeSendWorkerButTheStationNotExists() {
		Repairer r = new Repairer();
		this.c.addWorker(r);
		NotExisting exception = assertThrows(NotExisting.class, () -> {
			this.c.sendWorker(new Station(1,c), stationTest.getVehicles().get(0), r);
		});
		assertEquals("The Station doesn't exists",exception.getMessage());
	}
	
	@Test 
	public void WeSendWorkerButTheVehicleNotExisting() {
		Repairer r = new Repairer();
		this.c.addWorker(r);
		NotExisting exception = assertThrows(NotExisting.class, () -> {
			this.c.sendWorker(stationTest, new Bike(null, null, 0), r);
		});
		assertEquals("The Vehicle doesn't exists", exception.getMessage());
	}
	
	@Test 
	public void AllVehiclesAreCollect() {
		int tailleInit = this.stationTest.getVehicles().size();
		Map<Integer, TwoWheeledVehicle> vehiclesCollected = this.c.collectVehicles();
		assertEquals(vehiclesCollected.size(),tailleInit);
		assertEquals(this.stationTest.getVehicles().size(), 0);
	}
	
	@Test
	public void WhenVehiclesAreCollectedVehiclesArentInStation() {
		Bike b = (Bike) this.stationTest.getVehicles().get(0);
		Map<Integer, TwoWheeledVehicle> vehiclesCollected = this.c.collectVehicles();
		assertTrue(vehiclesCollected.containsValue(b));
		assertEquals(b.getStation(), null);
		assertFalse(this.stationTest.getVehicles().contains(b));
	}
	
	@Test 
	public void WhenVehiclesAreredistributedNotStationIsEmpty() {
		c.redistribution();
		for (Map.Entry<Integer, Station> set : c.getStationList().entrySet()) {
			assertFalse(set.getValue().getVehicles().size());
		}
	}

}

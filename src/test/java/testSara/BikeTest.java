package testSara;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.Exception.OutOfService;
import projetCOO.control.ControlCenter;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;


public class BikeTest {

	private Station s;
	private Bike bike;
	private ControlCenter c;

	@BeforeEach
	public void init() {
		this.c = new ControlCenter(0);
		this.s = new Station(1,c);
		this.c.addStation(s);
		this.bike = new Bike("Red",this.s,3);
		this.s.addVehicle(bike);
	}
	
	@Test 
	public void WeUseTheBike() throws OutOfService {
		this.bike.startRental();
		assertFalse(this.s.getVehicles().contains(bike));
	}
	
	@Test
	public void WeHandOverTheBike() throws OutOfService {
		this.bike.startRental();
		assertFalse(this.s.getVehicles().contains(bike));
		this.bike.stopRental(s);
		assertTrue(this.s.getVehicles().contains(bike));
	}
	
	@Test 
	public void TheVehicleIsOutOfService() throws OutOfService {
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
	public void WeAddFeatureOnTheBike() {
		
	}
	
	

}

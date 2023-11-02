package testSara;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;


public class BikeTest {

	private Station s;
	private Bike bike;

	@BeforeEach
	public void init() {
		this.s = new Station(1);
		this.bike = new Bike(null,this.s,3);
		this.s.addVehicle(bike);
	}
	
	@Test 
	public void WeUseTheBike() {
		this.bike.use();
		assertEquals(this.s.getVehicles().get(bike), State.UNAVAILABLE);
	}
	
	@Test
	public void WeHandOverTheBike() {
		this.bike.use();
		assertEquals(this.s.getVehicles().get(bike), State.UNAVAILABLE);
		this.bike.use();
		assertEquals(this.s.getVehicles().get(bike), State.AVAILABLE);
	}
	
	@Test
	public void TheVehicleIsOutOfService() {
		for (int i = 0; i < 6; i++) {
			this.bike.use();
		}
		assertEquals(this.s.getVehicles().get(bike), State.OUTOFSERVICE);
	}


	
	@Test 
	public void WeAddFeatureOnTheBike() {
		
	}
	
	

}

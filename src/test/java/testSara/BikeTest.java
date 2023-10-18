package testSara;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;


public class BikeTest {

	private Station s;
	private Bike bike;

	@BeforeEach
	public void init() {
		this.s = new Station(1);
		this.bike = new Bike(null,this.s);
	}


	
	@Test 
	public void WeAddFeatureOnTheBike() {
		
	}
	
	

}

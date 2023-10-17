package testSara;
import ProjetSara.station.Station;

//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import java.util.List;


import ProjetSara.bike.Bike;


public class BikeTest {

	private Station s;
	private Bike bike;

	@BeforeEach
	public void init() {
		this.s = new Station(0,null);
		this.bike = new Bike(null,this.s);
	}


	
	@Test 
	public void WeAddFeatureOnTheBike() {
		
	}
	
	

}

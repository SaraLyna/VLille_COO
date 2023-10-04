package bike;
import feature.*;
import station.Station;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bike.Bike;


public class BikeTest {

	private Station s;
	private Bike bike;

	@Before
	public void init() {
		this.s = new Station();
		this.bike = new Bike(s);
	}

	@Test
	public void TheBikeHasntFeatures() {
		assertTrue(this.bike.getFeatures().isEmpty());
	}
	
	@Test 
	public void WeAddFeatureOnTheBike() {
		
	}
	
	

}

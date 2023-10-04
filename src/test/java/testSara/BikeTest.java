package feature;
import feature.*;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


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

}

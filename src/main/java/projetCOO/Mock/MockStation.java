package projetCOO.Mock;

import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;

public class MockStation extends Station {

	private static final Bike b1 = new Bike(null, null, 3);
	private static final Bike b2 = new Bike(null, null, 3);
	private static final Bike b3 = new Bike(null, null, 3);
	
	public MockStation() {
		super(0, null);
		b1.setStation(this);
		b2.setStation(this);
		b3.setStation(this);
		b2.takeDamage();
		b3.takeDamage();
		b2.setNBUse(3);
		b3.setNBUse(3);
		this.vehicles.add(b1);
		this.vehicles.add(b2);
		this.vehicles.add(b3);
	}

	
}

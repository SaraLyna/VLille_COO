package projetCOO.Mock;

import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.*;

public class MockStation extends Station {

	private static final Bike b1 = new Bike(null, null, 3);
	private static final Bike b2 = new Bike(null, null, 3);
	private static final Bike b3 = new Bike(null, null, 3);
	
	private static final ElectricBike b4 = new ElectricBike(null, null, 3,100);
	private static final ElectricBike b5 = new ElectricBike(null, null, 3,100);
	private static final ElectricBike b6 = new ElectricBike(null, null, 3,100);
	
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
		
		b4.setStation(this);
		b5.setStation(this);
		b6.setStation(this);
		b5.takeDamage();
		b6.takeDamage();
		b5.setNBUse(3);
		b6.setNBUse(3);
		b4.setNiveauBatterie(0);
		b5.setNiveauBatterie(0);
		b6.setNiveauBatterie(0);
		this.vehicles.add(b4);
		this.vehicles.add(b5);
		this.vehicles.add(b6);
	}

	
}

package projetCOO.Mock;

import projetCOO.Exception.OutOfLimit;
import projetCOO.control.ControlCenter;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;

public class MockControlCenter extends ControlCenter{

	/**
	 * We build a Control Center with 3 station
	 * Each Station is filled with classic Bike
	 */
	public MockControlCenter() {
		super(3);
		this.initVehicles();
	}
	
	public void initVehicles() {
		for (int i = 0; i < super.getStationList().size(); i++) {
			Station s = super.getStationList().get(i);
			for (int j = 0; j < s.getCapacityMax(); j++)
				try {
					s.addVehicle(new Bike("test " + i + j, s, 3));
				} catch (OutOfLimit e) {
					e.printStackTrace();
				}
		}
	}

	

}

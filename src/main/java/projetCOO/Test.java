package projetCOO;

import projetCOO.Exception.AlreadyExisting;
import projetCOO.Exception.OutOfLimit;
import projetCOO.control.ControlCenter;
import projetCOO.control.worker.repairer.Repairer;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;

public class Test {

	public static void main(String[] args) {
		ControlCenter c = new ControlCenter(0);
		Station s = new Station(1, c);
		Repairer r = new Repairer();
		try {
			c.addStation(s);
			for (int i = 0; i < s.getCapacityMax();i++) {
				s.addVehicle(new Bike("default", s, 3));
			}
		} catch (AlreadyExisting e1) {
			e1.printStackTrace();
		} catch (OutOfLimit e) {
			e.printStackTrace();
		}
		Bike b1 = (Bike) s.getVehicles().get(0);
		s.addWorker(r);
		c.addWorker(r);
		System.out.println(s.getWorker());
		s.needRepairer(b1);
	}

}

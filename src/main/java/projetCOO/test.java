package projetCOO;

import java.util.Map;

import projetCOO.Exception.OutOfLimit;
import projetCOO.Mock.MockControlCenter;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;

public class test {

	public static void main(String[] args) throws OutOfLimit {
		MockControlCenter mc = new MockControlCenter();
		Map<Integer, TwoWheeledVehicle> vs = mc.collectVehicles();
		mc.redistribution();
		
	}

}

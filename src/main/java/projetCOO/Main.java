package projetCOO;

import projetCOO.Exception.OutOfLimit;
import projetCOO.control.ControlCenter;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;
import projetCOO.twoWheeledVehicle.bike.ElectricBike;



/**
 * Main of the project 
 */
public class Main {

    public static void main(String[] args) throws OutOfLimit {
    	ControlCenter controlCenter = new ControlCenter(10);
		
    	
    	controlCenter.initStation();
    	
    	
    	for (Station station : controlCenter.getStationList().values()) {
            Bike bike = new Bike("Classical", station, 3);
            station.addVehicle(bike);
        }
    	
    	for (Station station : controlCenter.getStationList().values()) {
            ElectricBike electricBike = new ElectricBike("Electric", station, 500, 3);
            station.addVehicle(electricBike);
        }
    	
    	
//    	 for (Station station : controlCenter.getStationList().values()) {
////             for (TwoWheeledVehicle bike : station.getVehicles().keySet()) {
////                 bike = new Basket(bike);
////             }
//         }
//    	 
//    	 Station station = controlCenter.getStationList().get(0);
////         TwoWheeledVehicle damagedBike = station.getOneVehicle(0);
////         damagedBike.takeDamage();

         
         controlCenter.show();
         
         controlCenter.verification();
//         controlCenter.sendRepairer();
         
         controlCenter.show();
         
    }
}

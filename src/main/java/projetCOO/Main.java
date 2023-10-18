package projetCOO;
import java.util.*;

import projetCOO.control.ControlCenter;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.Bike;
import projetCOO.feature.*;


/**
 * Main of the project 
 */
public class Main {

    public static void main(String[] args) {
    	ControlCenter center = new ControlCenter(1);
    	center.show();
    }
}

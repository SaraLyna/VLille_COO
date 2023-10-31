package projetCOO.vlille;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import projetCOO.control.ControlCenter;
import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import projetCOO.twoWheeledVehicle.bike.Bike;
import projetCOO.twoWheeledVehicle.bike.ElectricBike;
import projetCOO.util.Input;

public class Vlille {

	private ControlCenter c;
	
	public Vlille(ControlCenter c) {
		this.c = c;
	}
	
	public ControlCenter getControlCenter() {
		return this.c;
	}
	
	public void week() {
		for (int i = 0; i<7; i++ ) {
			this.day();
		}
		this.c.verification();
		if (this.c.getStationWithBikeToverify().size() > 0) {
			this.c.sendRepairer();
		}
	}
	
	public void day() {
		for (Map.Entry<Integer, Station> s : this.c.getStationList().entrySet()) {
			for (Entry<TwoWheeledVehicle, State> v : s.getValue().getVehicles().entrySet()) {
				this.event(v.getKey());
			}
		}
		
	}
	
	public void event(TwoWheeledVehicle v) {
		int prob = this.chance();
		if (prob < 60) {
			v.use();
		}
	}
	
	public int randomNB(int max, int min) {
		int range = max - min + 1;
		return (int)(Math.random() * range) + min;
	}
	
	public int chance() {
		return this.randomNB(0, 100);
	}
	
	/**
     * -------------------------------------------------------------
     * ----------------------- Displays Methods ------------------------
     * -------------------------------------------------------------      
     */
	
	public void displayVehiclesForEachStations() {
		for (Station s : this.c.getStationList().values()) {
			s.displayVehicles();
		}
	}
	
	/**
     * -------------------------------------------------------------
     * ----------------------- Inits Methods ------------------------
     * -------------------------------------------------------------      
     */
	
	public void initVehicules() {
		for (Map.Entry<Integer, Station> s : this.c.getStationList().entrySet()) {
			while (s.getValue().getVehicles().size() != s.getValue().getCapacityMax()) {
				int r = this.randomNB(1,0);
				if (r == 0 ) {
					Bike b = new Bike("Classic", s.getValue());
					s.getValue().addVehicle(b);
				}
				if (r == 1 ) {
					ElectricBike eb = new ElectricBike("Classic", s.getValue(), 100);
					s.getValue().addVehicle(eb);
				}
			}
		}
	}
	
	public void run() {
		this.initVehicules();
		try {
			int nbWeek = Input.readInt();
			while (nbWeek > 0 ) {
				this.week();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

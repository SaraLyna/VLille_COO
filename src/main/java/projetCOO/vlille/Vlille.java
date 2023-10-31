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
		for (Map.Entry<Integer, Station> s : this.c.getStationList().entrySet()) {
			System.out.println(s.getValue().toString() + " :");
			s.getValue().displayVehicles();
		}
		this.c.verification();
		if (this.c.getStationWithBikeToverify().size() > 0) {
			System.out.println("Repairers send");
			this.c.sendRepairer();
		}
	}
	
	public void day() {
		for (Map.Entry<Integer, Station> s : this.c.getStationList().entrySet()) {
			for (Entry<TwoWheeledVehicle, State> v : s.getValue().getVehicles().entrySet()) {
				this.event(v.getKey());
			}
			s.getValue().stoleAVehicle();
		}
		
	}
	
	public void event(TwoWheeledVehicle v) {
		int prob = this.chance();
		if (prob < 90) {
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
					Bike b = new Bike("Default", s.getValue());
					s.getValue().addVehicle(b);
				}
				if (r == 1 ) {
					ElectricBike eb = new ElectricBike("Default", s.getValue(), 100);
					s.getValue().addVehicle(eb);
				}
			}
		}
	}
	
	public void run() {
		this.initVehicules();
		try {
			System.out.print("How many week ? ");
			int nbWeek = Input.readInt();
			int i = 1;
			while (nbWeek > 0 ) {
				System.out.println("Week " + i + " : ");
				this.week();
				nbWeek--;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

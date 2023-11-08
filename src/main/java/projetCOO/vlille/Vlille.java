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



/**
 *Vlille class 
 *represents the game itself, it's a representation of a round.
 *Here we define the stations and the vehicles and play the round
 */
public class Vlille {

	
	
	private ControlCenter c;
	
	
	
	/**
	 * Constructor of the class Vlille
	 * @param c
	 */
	public Vlille(ControlCenter c) {
		this.c = c;
	}
	
	
	
	/**
	 * @return the control center concerned
	 */
	public ControlCenter getControlCenter() {
		return this.c;
	}
	
	
	
	/**
	 * Representation on an interval of time , 
	 * here it's one week where the vehicles are in the station
	 */
	public void week() {
		for (int i = 0; i<7; i++ ) {
			this.day();
			if ( i == 3) {
				this.displayVehiclesForEachStations();
				this.c.verification();
				//this.c.sendRepairer();
//				this.repair();
			}
		}
	}
	
	
	
	/**
	 * An interval of time which is represented in one day
	 */
	public void day() {
		for (Map.Entry<Integer, Station> s : this.c.getStationList().entrySet()) {
			for (Entry<TwoWheeledVehicle, State> v : s.getValue().getVehicles().entrySet()) {
				this.event(v.getKey());
			}
			s.getValue().stoleAVehicle();
		}
		
	}
	
	
	
	/**
	 * The probability of chance that a vehicle is been used
	 * @param v
	 */
	public void event(TwoWheeledVehicle v) {
		int prob = this.chance();
		if (prob < 90) {
			v.use();
			prob = this.chance();
			if (prob < 15 && v.getStation().getVehicles().get(v).equals(State.UNAVAILABLE)) {
				v.takeDamage();
			}
		}
	}
	
	/**
	 * order Repairers to repair 
	 */
//	public void repair() {
//		for (Map.Entry<Integer, Station> s : this.c.getStationList().entrySet()) {
//			if (s.getValue().getRepairer() != null) {
//				s.getValue().getRepairer().action();
//			}
//		}
//	}
	
	
	
	/**
	 * @param max
	 * @param min
	 * @return a random number
	 */
	public int randomNB(int max, int min) {
		int range = max - min + 1;
		return (int)(Math.random() * range) + min;
	}
	
	
	
	/**
	 * @return the chance using the random number
	 */
	public int chance() {
		return this.randomNB(0, 100);
	}
	
	/**
     * -------------------------------------------------------------
     * ----------------------- Displays Methods ------------------------
     * -------------------------------------------------------------      
     */
	
	
	
	
	/**
	 * the method that displays the vehicles for each station
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
	
	
	
	
	/**
	 * the method that initialize the vehicles
	 */
	public void initVehicules() {
		for (Map.Entry<Integer, Station> s : this.c.getStationList().entrySet()) {
			while (s.getValue().getVehicles().size() != s.getValue().getCapacityMax()) {
				int r = this.randomNB(1,0);
				if (r == 0 ) {
					Bike b = new Bike("Default", s.getValue(), 3);
					s.getValue().addVehicle(b);
				}
				if (r == 1 ) {
					ElectricBike eb = new ElectricBike("Default", s.getValue(), 3, 100);
					s.getValue().addVehicle(eb);
				}
			}
		}
	}
	
	
	
	
	
	/**
	 * the main method that runs the game using the differents methods below
	 */
	public void run() {
		this.initVehicules();
		try {
			System.out.print("How many week ? ");
			int nbWeek = Input.readInt();
			int i = 1;
			while (nbWeek > 0 ) {
				System.out.println("\nWeek " + i + " : ");
				this.week();
				nbWeek--;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

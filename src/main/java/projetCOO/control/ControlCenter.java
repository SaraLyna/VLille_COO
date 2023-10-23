package projetCOO.control;

import projetCOO.control.repairer.Repairer;
import projetCOO.state.State;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import java.util.*;
import java.util.Map.Entry;


/**
*The class that represent the control center
*/
public class ControlCenter{
	private Map<Integer,Station> stationList;
	private List<Station> stationsNeedsToBeverify;
	private int nbStation;
	

	/**
	* Constructor of the class
	*/
	public ControlCenter(int n){
		this.nbStation = n;
		this.initStation();
		this.stationsNeedsToBeverify = new ArrayList<>();
	}
	
	
	
	/**
	 * @return stationList
	 */
	public Map<Integer,Station> getStationList() {
		return stationList;
	}
	
	

	
	/**
	 * @param index
	 * @return one station
	 */
	public Station getOneStation(int index) {
		Station s = null;
		try {
			for (Entry<Integer, Station> set : this.stationList.entrySet()) {
				if (index == set.getKey()) {
					s = set.getValue();
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	
	/**
	 * @return station with bike to verify
	 */
	public List<Station> getStationWithBikeToverify() {
		return this.stationsNeedsToBeverify;
	}
	
	
	
	
	/**
	 * @param station
	 */
	public void addStation(Station station) {
		stationList.put(station.getId(), station);
		
	}

	
	
	/**
	 * initialize station
	 */
	public void initStation() {
		this.stationList = new HashMap<>(); 
		for (int i = 0;i<this.nbStation; i++) {
			Station s = new Station(i);
			this.addStation(s);
		}
		
	}
	
	
	
	
	/**
	 * method verification
	 */
	public void verification() {
		for (Map.Entry<Integer, Station> s : this.stationList.entrySet()) {
			for (Entry<TwoWheeledVehicle, State> b : s.getValue().getVehicles().entrySet()) {
				if (b.getValue().equals(State.OUTOFSERVICE) || b.getKey().isDamaged()) {
					this.stationsNeedsToBeverify.add(s.getValue());
				}
			}
		}
	}
	
	
	
	/**
	 *send a repairer to repair a bike
	 */
	public void sendRepairer() {
		Repairer r;
		for (int i = 0; i<this.stationsNeedsToBeverify.size(); i++) {
			r = new Repairer();
			this.stationsNeedsToBeverify.get(i).setRepairer(r);
			r.setStation(this.stationsNeedsToBeverify.get(i));
		}
	}
	
	public Map<Integer, TwoWheeledVehicle> collectVehicles() {
		int cpt = 0;
		Map<Integer, TwoWheeledVehicle> vs = new HashMap<>();
		for (Map.Entry<Integer, Station> s : this.stationList.entrySet()) {
			Iterator<Map.Entry<TwoWheeledVehicle, State>> iterator = s.getValue().getVehicles().entrySet().iterator();

	        while (iterator.hasNext()) {
	            Map.Entry<TwoWheeledVehicle, State> v = iterator.next();

	            if (v.getValue() == State.AVAILABLE) {
	            	v.getKey().setStation(null);
	                vs.put(cpt, v.getKey());
	                iterator.remove();;
	                cpt++;
	            }
	        }
		}
		return vs;
	}
	
	public void redistribution() {
		Map<Integer, TwoWheeledVehicle> vs = this.collectVehicles();
		while (!vs.isEmpty()) {
			for (Map.Entry<Integer, Station> s : this.stationList.entrySet()) {
				if (s.getValue().getVehicles().size() < s.getValue().getCapacityMax()) {
					int randomNB = (int) (Math.random() * (vs.size() + 1));
					TwoWheeledVehicle b = vs.get(randomNB);
					s.getValue().addVehicle(b);
					vs.remove(randomNB);
				}
			}
		}
	}
	
	
	/**
	 * just show the stations
	 */
	public void show() {
		for (Map.Entry<Integer, Station> set : this.stationList.entrySet()) {
				System.out.println(set.getValue().toString());
		}
	}



}

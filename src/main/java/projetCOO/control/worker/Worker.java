package projetCOO.control.worker;

import projetCOO.station.Station;

public abstract class Worker {
	
	private Station station;
	
	public Worker() {
		this.station = null;
	}
	
	
	/**
	 * @return station
	 */
	public Station getStation() {
		return this.station;
	}
	
	/**
	 * leaves the station
	 */
	public void leaveStation() {
		this.getStation().removeWorker(this);
		this.setStation(null);
	}
	
	/**
	 * Set a station
	 * @param s
	 */
	public void setStation(Station s) {
		this.station = s;
	}
	
	/**
	 * make the action to manage in the station
	 */
	public abstract void action();

	public abstract String toString();
}

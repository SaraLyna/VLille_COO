package projetCOO.control.repairer;
import projetCOO.station.Station;

/**
 * the class that represent the repairer
 */
public class Repairer{
	
	private Station station;

	/**
	 * @param number
	 */
	public Repairer(){
	  this.station = null;
	}
	
	public Station getStation() {
		return this.station;
	}

	public void setStation(Station s) {
		this.station = s;
	}
	
	public void leaveStation() {
		this.getStation().setRepairer(null);
		this.setStation(null);
	}
 
  /**
   * repair the bike
   */
	public void action() {
		
	  
	}
	
	
}

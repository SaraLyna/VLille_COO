package projetCOO.control.repairer;
import projetCOO.control.ControlCenter;
import projetCOO.station.Station;

/**
 * the class that represent the repairer
 */
public class Repairer{
	
	private Station station;
	private ControlCenter controlCenter;

	/**
	 * @param number
	 */
	public Repairer(ControlCenter c){
	  this.controlCenter = c;
	  this.station = null;
	}
	

	public void setStation(Station s) {
		this.station = s;
	}
 
  /**
   * repair the bike
   */
	public void action() {
	  
	  
	}
	
	
}

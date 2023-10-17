package ProjetSara.bike;

import java.util.*;

import ProjetSara.feature.FeatureDeco;
import ProjetSara.station.Station;

/**
*this is the Bike class representing the bikes
*in the station
*/
public class Bike {

	protected Station station;
	protected List<FeatureDeco> features;
	protected List<FeatureDeco> problemFeatures;
	protected String skin; 
	protected boolean inService;
	


	/**
	* Constructor of the class Bike
	*/
	public Bike(String skin,Station station) {
		this.station = station;
		this.features = new ArrayList<>();
		this.problemFeatures = new ArrayList<>();
		this.skin=skin;
		this.inService = true;
	}


	
	/**
	 * @return
	 */
	public List<FeatureDeco> getFeatures() {
		return this.features;
	}
	
	
	
	/**
	 * @return
	 */
	public Station getStation() {
		return this.station;
	}
	
	
	
	
	
	/**
	 * @return
	 */
	public List<FeatureDeco> getProblemFeatures() {
		return this.problemFeatures;
	}
	
	
	
	/**
	 * @param s
	 */
	public void setStation(Station s) {
		this.station = s;
	}
	
	
	 
	/**
	 * @param s
	 */
	public void applySkin(String s) {
		this.skin = s;
	}
	
	
	
	/**
	 * @param f
	 */
	public void addProblem(FeatureDeco f) {
		this.problemFeatures.add(f);
	}
	
	
	
	/**
	 * @param f
	 */
	public void removeProblem(FeatureDeco f) {
		this.problemFeatures.remove(f);
	}

	
	public boolean isInService() {
        return inService;
    	}

   	public void setInService(boolean inService) {
        this.inService = inService;
    	}

	/**
	 *
	 */
	public String toString() {
		return "Bike{" +
                "station=" + station +
                ", features=" + features +
                ", problemFeatures=" + problemFeatures +
                ", skin='" + skin + '\'' +
                ", inService=" + inService +
                '}';
		
	}
}

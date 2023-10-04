package bike;

import java.util.*;

import feature.FeatureDeco;
import station.Station;

/**
*this is the Bike class representing the bikes
*in the station
*/
public class Bike {

	protected Station station;
	protected List<FeatureDeco> feature;
	protected List<FeatureDeco> problemFeature;
	protected String skin; 
	


	/**
	* Constructor of the class Bike
	*/
	public Bike(String skin,Station station) {
		this.station = station;
		this.feature = new ArrayList<>();
		this.problemFeature = new ArrayList<>();
		this.skin=skin;
	}


	public List<FeatureDeco> getFeatures() {
		return this.feature;
	}
	
	public Station getStation() {
		return this.station;
	}
	public List<FeatureDeco> getProblemFeatures() {
		return this.problemFeature;
	}
	
	public void setSation(Station s) {
		this.station = s;
	}
	 
	public void applySkin(String s) {
		this.skin = s;
	}
	public void addProblem(FeatureDeco f) {
		this.problemFeature.add(f);
	}
	
	public void removeProblem(FeatureDeco f) {
		this.problemFeature.remove(f);
	}


	public String toString() {
		return null;
		
	}
}

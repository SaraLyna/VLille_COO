package feature;

import java.util.*;

import feature.Feature;
//import station.*;

/**
*this is the Bike class representing the bikes
*in the station
*/
public class Bike {

	protected String id;
	protected String type;
	protected String etat;
	protected Station station;


	/**
	* Constructor of the class Bike
	*/
	public Bike(String id, String type, String etat,Station station) {
		this.id = id;
		this.type = type;
		this.etat = etat;
		this.station = station;
	//	this.feature = new ArrayList<>();
	}

  	public String getId() {
         return id;
     }

     public String getType() {
         return type;
     }

     public String getEtat() {
         return etat;
     }

	public List<Feature> getFeatures() {
		return this.feature;
	}
}

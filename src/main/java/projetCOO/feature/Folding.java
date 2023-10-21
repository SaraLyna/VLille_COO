package projetCOO.feature;

import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;


/**
 * The folding on the vehicles
 */
public class Folding extends FeatureDeco{
	
	
	
	/**
	 * Constructor
	 */
	public Folding(TwoWheeledVehicle v) {
		super(v);
		
	}
	
	
	
	/**
	 *The method of the decorator class
	 */
	public String decorate(){
		return super.decorate() + " with folding";
	}
	
	
	
	
	
	
}
package projetCOO.feature;

import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;

/**
 * The class that represents the basket in a vehicle
 */
public class Basket extends FeatureDeco{
	
	
	
	/**
	 * Constructor
	 */
	public Basket(TwoWheeledVehicle v) {
		super(v);
		
	}
	
	
	
	/**
	 *The method of the decorator class
	 */
	public String decorate(){
		return super.decorate() + " with basket ";
	}
	
	
	
	
	
	
	
}
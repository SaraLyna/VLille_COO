package projetCOO.feature;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;

/**
 * The pannier rack on the vehicles
 */
public class PannierRack extends FeatureDeco{
	
	
	
	/**
	 * Constructor of the class
	 */
	public PannierRack(TwoWheeledVehicle v) {
		super(v);
		
	}
	
	
	/**
	 *The method of the decorator class
	 */
	public String decorate(){
		return super.decorate() + " with pannier rack";
	}
	
	
	
	
}
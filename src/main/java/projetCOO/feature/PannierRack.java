package projetCOO.feature;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;

/**
 * 
 */
public class PannierRack extends FeatureDeco{
	
	
	
	/**
	 * Constructor of the class
	 */
	public PannierRack(TwoWheeledVehicle v) {
		super(v);
		
	}
	
	public String decorate(){
		return super.decorate() + " with pannier rack";
	}
	
	
	
	
}
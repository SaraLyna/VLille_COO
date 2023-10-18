package feature;
import twoWheeledVehicle.TwoWheeledVehicle;

/**
 * 
 */
public class Basket extends FeatureDeco{
	
	
	
	/**
	 * 
	 */
	public Basket(TwoWheeledVehicle v) {
		super(v);
		
	}
	
	
	
	/**
	 *
	 */
	public String decorate(){
		return super.decorate() + " with basket ";
	}
	
	
	
	
	
	
	
}
package projetCOO.feature;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import supp.*;
/**
 * 
 */
public class Folding extends FeatureDeco{
	
	
	
	/**
	 * 
	 */
	public Folding(TwoWheeledVehicle v) {
		super(v);
		
	}
	
	
	
	/**
	 *
	 */
	public String decorate(){
		return super.decorate() + " with folding";
	}
	
	
	
	
	
	
}
package projetCOO.feature;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;
import supp.*;
/**
 * Decorator class
 */
public class FeatureDeco implements TwoWheeledVehicle {
	
	protected TwoWheeledVehicle v;

	/**
	* Constructor of the class FeatureDeco
	 * @param v 
	*/
	public FeatureDeco(TwoWheeledVehicle v){
		this.v=v;
		
		
	}
	
	
	
	
	public String decorate() {
		return "un deux roues" ;
	
	}




	@Override
	public void applySkin(String s) {
		// TODO Auto-generated method stub
		
	}




	
	public void repair() {
		this.v.repair();	
	}
	
	
	
	
	
}

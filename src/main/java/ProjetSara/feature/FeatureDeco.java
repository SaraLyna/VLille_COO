package ProjetSara.feature;
import ProjetSara.bike.*;
/**
 * Decorator class
 */
public abstract class FeatureDeco {
	
	protected Bike b;

	/**
	* Constructor of the class FeatureDeco
	 * @param b 
	*/
	public FeatureDeco(Bike b){
		//TwoWheeledVehicle v
		//this.v=v;
		this.b=b;
		
	}
	
	
	
	
	public String Decorate() {
		return null;
	
	}
	
	
	/**
	 * 
	 *
	public void repair() {
		damaged = false;
		
	}
	*/
	
	
		/**
     	* Check if the feature is damaged.
     	*
     	* @return true if damaged, false otherwise
     	
    	public Boolean isDamaged() {
        	return damaged;
    	}
	*/
	
	
	/**
	 * Mark the feature as damaged.
	 *
	public void takeDamage() {
		damaged = true;
		
	}
	*/
	
	
	/**
	 *
	 */
	public String toString() {
		return null;
		
	}

}

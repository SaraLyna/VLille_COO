package ProjetSara.feature;

/**
 * Decorator class
 */
public abstract class FeatureDeco {
	
	protected Boolean damaged;

	/**
	* Constructor of the class FeatureDeco
	*/
	public FeatureDeco(){
		damaged = false;
	}
	
	
	
	/**
	 * 
	 */
	public void repair() {
		damaged = false;
		
	}
	
	
	
		/**
     	* Check if the feature is damaged.
     	*
     	* @return true if damaged, false otherwise
     	*/
    	public Boolean isDamaged() {
        	return damaged;
    	}
	
	
	
	/**
	 * Mark the feature as damaged.
	 */
	public void takeDamage() {
		damaged = true;
		
	}
	
	
	
	/**
	 *
	 */
	public String toString() {
		return "FeatureDeco{" +
                "damaged=" + damaged +
                '}';
		
	}

}

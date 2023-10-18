 package projetCOO.twoWheeledVehicle;

/**
 * The class that represent all the things having two wheeled ! 
 * bikes, trotinettes....
 */
public interface TwoWheeledVehicle {

	/**
	 * @param s
	 */
	public void applySkin(String s);
	
	
	public boolean isDamaged();
	public void takeDamage();
	public void repair();
	
	public String toString();

}

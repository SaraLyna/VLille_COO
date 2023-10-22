package projetCOO.feature;

import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;


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
	
	
	
	/**
	 *The method of the decorator class
	 */
	public String decorate() {
		return this.v.toString() ;
	
	}




	@Override
	public void applySkin(String s) {
		
		
	}




	
	public void repair() {
		this.v.repair();	
	}




	@Override
	public boolean isDamaged() {
		return this.v.isDamaged();
	}




	@Override
	public void takeDamage() {
		this.v.takeDamage();
	}




	@Override
	public String getType() {
		
		return null;
	}




	@Override
	public void startRental() {
		
		
	}




	@Override
	public void stopRental() {
		
		
	}




	@Override
	public boolean isAvailable() {
		
		return false;
	}




	@Override
	public void markForRepair() {
		
		
	}




	@Override
	public void performRepair() {
		
		
	}




	@Override
	public void markAsStolen() {
		
		
	}




	@Override
	public boolean isStolen() {
		
		return false;
	}



	
	@Override
	public void setStation(Station station) {
		
		
	}




	@Override
	public void use() {
		this.v.use();
	}



	@Override
	public Station getCurrentStation(Station s) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void attachToStation(Station stationId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}

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
	
	
	
	
	public String decorate() {
		return this.v.toString() ;
	
	}




	@Override
	public void applySkin(String s) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void startRental() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void stopRental() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public void markForRepair() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void performRepair() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void markAsStolen() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean isStolen() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public void attachToStation(String stationId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public String getCurrentStation() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void setStation(Station station) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void use() {
		this.v.use();
	}
	
	
	
	
	
}

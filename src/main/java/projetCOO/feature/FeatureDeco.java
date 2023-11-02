package projetCOO.feature;

import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;


/**
 * Decorator class of the different features added to a vehicle
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
	 *The main method of the decorator class
	 */
	public String decorate() {
		return this.v.toString() ;
	}


	@Override
	public void setStation(Station station) {
		this.v.setStation(station);
	}

	@Override
	public void applySkin(String s) {
		this.v.applySkin(s);
	}




	@Override
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
	public void use() {
		this.v.use();
	}
	
	@Override
	public void stole() {
		this.v.stole();
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
	public Station getCurrentStation(Station s) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void attachToStation(Station stationId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Station getStation() {
		return v.getStation();
	}



	@Override
	public int getNBUse() {
		return this.v.getNBUse();
	}



	@Override
	public int getUseLimit() {
		return this.v.getUseLimit();
	}



	@Override
	public void setUseLimit(int n) {
		this.v.setUseLimit(n);
		
	}



	@Override
	public void resetNBUse() {
		this.v.resetNBUse();
	}
}

package projetCOO.feature;

import java.util.List;

import projetCOO.Exception.OutOfService;
import projetCOO.control.repairer.Repairer;
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
	public Repairer askRepairer(List<Repairer> repairerList) {
		return this.v.askRepairer(repairerList);
	}
	
	@Override
	/**
   	 * says if is the right type of Repairer
   	 * @param Repairer
   	 * @return boolean
   	 */
   	public boolean isGoodRepairer(Repairer r) {
		return this.v.isGoodRepairer(r);
	}
	
	@Override
	public void stole() {
		this.v.stole();
	}

	@Override
	public void startRental() throws OutOfService {
		this.v.startRental();
	}

	@Override
	public void stopRental(Station s) {
		this.v.stopRental(s);
	}




	@Override
	public boolean isAvailable() {
		
		return false;
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

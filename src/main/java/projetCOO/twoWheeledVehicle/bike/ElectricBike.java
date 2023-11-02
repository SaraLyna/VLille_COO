package projetCOO.twoWheeledVehicle.bike;

import projetCOO.station.Station;



/**
 * The class represents a type of bike
 * the electric  one
 */
public class ElectricBike extends Bike{
	
	private int capacityBatterie;
	private int niveauBatterie;
	
	/**
	 * Constructor of the class
	 * @param skin
	 * @param station
	 * @param capacityBatterie
	 */
	public ElectricBike(String skin,Station station, int capacityBatterie){
		super(skin,station);
		this.capacityBatterie= capacityBatterie;
		this.niveauBatterie = 100;
	}

	
	 /**
	 * @return capacityBatterie
	 */
	public int getCapacityBatterie() {
	        return capacityBatterie;
	 }

	
	
	 /**
	  * set the capacity max of the battery
	 * @param capacityBatterie
	 */
	public void setCapacityBatterie(int capacityBatterie) {
	        this.capacityBatterie = capacityBatterie;
	 }
	
	
	 /**
	 * @return battery level
	 */
	public int getNiveauBatterie() {
	        return niveauBatterie;
	 }

	
	
	 /**
	  * set the battery level
	 * @param niveauBatterie
	 */
	public void setNiveauBatterie(int niveauBatterie) {
	       if (niveauBatterie >= 0 && niveauBatterie <= 100) {
	            this.niveauBatterie = niveauBatterie;
	       }
	 }
	
	
	 /**
	 * @param pourcentage
	 * recharge the battery
	 */
	public void BatterieRecharge(int pourcentage) {
	        if (niveauBatterie + pourcentage <= 100) {
	            niveauBatterie += pourcentage;
	        }
	  }
	
	
	
	/**
	 * @param pourcentage
	 * décharge the battery
	 */
	public void BatterieUse(int pourcentage) {
        if (niveauBatterie - pourcentage >= 0) {
            niveauBatterie -= pourcentage;
        }
    }
	
	
	/**
	 * @return niveauBatterie
	 * verify if the battery is low
	 */
	public boolean BatterieFaible() {
        return niveauBatterie < 20; 
    }
	
	
	
	/**
	 *ToString() method
	 */
	public String toString() {
		return this.skin + " ElectricBike";
	}

}

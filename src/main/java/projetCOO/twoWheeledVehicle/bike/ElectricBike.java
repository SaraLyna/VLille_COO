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
	 * Constructor
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
	 * @param capacityBatterie
	 */
	public void setCapacityBatterie(int capacityBatterie) {
	        this.capacityBatterie = capacityBatterie;
	 }
	
	
	 /**
	 * @return niveau batterie
	 */
	public int getNiveauBatterie() {
	        return niveauBatterie;
	 }

	
	
	 /**
	 * @param niveauBatterie
	 */
	public void setNiveauBatterie(int niveauBatterie) {
	       if (niveauBatterie >= 0 && niveauBatterie <= 100) {
	            this.niveauBatterie = niveauBatterie;
	       }
	 }
	
	
	 /**
	 * @param pourcentage
	 * recharger la batterie
	 */
	public void rechargerBatterie(int pourcentage) {
	        if (niveauBatterie + pourcentage <= 100) {
	            niveauBatterie += pourcentage;
	        }
	  }
	
	
	
	/**
	 * @param pourcentage
	 * décharger la batterie
	 */
	public void utiliserBatterie(int pourcentage) {
        if (niveauBatterie - pourcentage >= 0) {
            niveauBatterie -= pourcentage;
        }
    }
	
	
	/**
	 * @return niveauBatterie
	 * vérifier si la batterie est faible
	 */
	public boolean estBatterieFaible() {
        return niveauBatterie < 20; 
    }

}

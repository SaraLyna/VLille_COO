package projetCOO.twoWheeledVehicle.bike;

import java.util.Iterator;
import java.util.List;

import projetCOO.control.worker.Worker;
import projetCOO.control.worker.repairer.Repairer;
import projetCOO.control.worker.repairer.RepairerElectric;
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
	public ElectricBike(String skin,Station station, int ul, int capacityBatterie){
		super(skin,station,ul);
		this.capacityBatterie= capacityBatterie;
		this.niveauBatterie = 100;
	}
	
	/**
	 * ask a RepairerElcetic for this bike
	 * @return RepairerElectic
	 */
	@Override
	public Worker askRepairer(List<Worker> repairersList) {
		Iterator<Worker> i = repairersList.iterator();
   		int min = 1000000;
   		Worker save = null;
   		while (i.hasNext()) {
   			Worker r = i.next();
   			if (this.isGoodRepairer(r) && min > r.getNBTask()) {
   				save = r;
   				min = r.getNBTask();
   			}
   		}
   		return save;
	}
	
	/**
   	 * says if is the right type of Repairer
   	 * @param Repairer
   	 * @return boolean
   	 */
   	public boolean isGoodRepairer(Repairer r) {
   		return r instanceof RepairerElectric;
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

package feature;


/**
*this is the Station class representing the station
*where are the bikes located
*/
public class Station {
	private static Station instance = new Station();
	protected String id;
	protected int CapaciteAccueil;
	protected List<Bike> bikes;

	/**
	* Constructor of the class Station
	*/
	public Station(){

	}

	public static Station getInstance() {
        return instance;
    }

}

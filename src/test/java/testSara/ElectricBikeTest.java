package testSara;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.ElectricBike;

class ElectricBikeTest {
	private ElectricBike electricBike;

	@BeforeEach
	void setUp() {
		Station station = new Station(1, null);
        electricBike = new ElectricBike("Electric", station, 0, 3);
	}
	

	@Test
    void testBatterieRecharge() {
        electricBike.BatterieRecharge(50);
        assertEquals(100, electricBike.getNiveauBatterie());
    }

    @Test
    void testBatterieUse() {
        electricBike.BatterieUse(30);
        assertEquals(70, electricBike.getNiveauBatterie());
    }
    
    void testEstBatterieFaible() {
        electricBike.setNiveauBatterie(15);
        assertTrue(electricBike.BatterieFaible());
        
        electricBike.setNiveauBatterie(30);
        assertFalse(electricBike.BatterieFaible());
    }
}

package testSara.control.worker.repairer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.Mock.MockStation;
import projetCOO.control.worker.repairer.Repairer;
import projetCOO.planning.FakePlanning;
import projetCOO.twoWheeledVehicle.bike.ElectricBike;

class ElectricRepairerTest {
	
	private Repairer r;
	private ElectricBike b;
	private MockStation s;

	@BeforeEach
	public void init() {
		this.s =  new MockStation();
		this.r = new Repairer();
		this.b = (ElectricBike) s.getVehicles().get(4);
	}
	
	@Test
	public void RepairerRepairABikeThatIsDammaged() {
		b.takeDamage();
		assertTrue(b.isDamaged());
		r.controlVehicle(b);
		assertFalse(b.isDamaged());
	}
	
	@Test 
	public void RepairerResetNBUse() {
		b.setNBUse(3);
		assertEquals(3,b.getNBUse());
		r.controlVehicle(b);
		assertEquals(0,b.getNBUse());
	}
	
	@Test 
	public void RepairerVerifiesOtherVehicleAndHasTwoTasks() {
		r.verifyOtherVehicle(s);
		assertEquals(4,r.getNBTask());
	}
	
	@Test
	public void RepairerWorks() {
		r.setPlanning(new FakePlanning());
		r.addTask(b);
		assertTrue(r.getPlanning().getPlanning().containsKey(s));
		r.action();
		for(int i = 0; i < s.getVehicles().size(); i++) {
			assertFalse(s.getVehicles().get(i).isDamaged());
			assertEquals(0, s.getVehicles().get(i).getNBUse());
		}
		assertEquals(0, r.getNBTask());
	}
	
	@Test
	public void controlVehicleTest() {
		assertEquals(0,b.getNiveauBatterie());
		b.BatterieRecharge(100);
		assertEquals(100,b.getNiveauBatterie());
		
	}

}

package testSara.control.worker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetCOO.Mock.MockWorker;
import projetCOO.control.worker.Worker;
import projetCOO.planning.FakePlanning;
import projetCOO.planning.Planning;
import projetCOO.station.Station;
import projetCOO.twoWheeledVehicle.bike.Bike;

public class WorkerTest {

	
	protected Worker w;
	protected Station s;
	protected Bike b;
	
	@BeforeEach
	public void init() {
		this.w = new MockWorker();
		this.s = new Station(0,null); 
		this.b = new Bike(null,s,3);
	}
	
	
	@Test
	public void WorkerHasZeroTask() {
		assertEquals(0,w.getNBTask());
	}
	
	@Test 
	public void WorkerHasPlanning() {
		assertTrue(w.getPlanning() instanceof Planning);
	}
	
	@Test 
	public void WorkerHasFakePlanning() {
		w.setPlanning(new FakePlanning());
		assertTrue(w.getPlanning() instanceof FakePlanning);
	}
	
	@Test 
	public void WorkerHasOneTask() {
		w.increaseTasks(1);
		assertEquals(1,w.getNBTask());
	}
	
	@Test
	public void WeAddTaskForWorker() {
		this.w.addTask(b);
		assertEquals(1,w.getNBTask());
	}
}

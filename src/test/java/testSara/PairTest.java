package testSara;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import projetCOO.util.Pair;

public class PairTest {
	
	@Test
	public void PairWithOnlyInt() {
		Pair<Integer,Integer> p = new Pair<Integer, Integer>(12,14);
		assertEquals(12, p.getFirst());
		assertEquals(14,p.getSecond());
		assertFalse(12 == p.getSecond());
		assertFalse(14 == p.getFirst());
	}
	
	@Test
	public void PairWithTwoDifferentTypes() {
		Pair<Integer,Boolean> p = new Pair<Integer, Boolean>(12,true);
		assertTrue(p.getSecond());
		assertEquals(12,p.getFirst());
	}

}

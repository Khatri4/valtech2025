package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleArithmeticTest {
	
	private Arithmetic ari = new SimpleArithmetic();

	@Test
	void testAdd() {
	}
	
	@Test
	void testSub() {
	}
	
	@Test
	void testMul() {
	}
	
	@Test
	void testDivWithDouble() {
	}
	
	@Test
	void testDivWithInt() {
		assertEquals(2, ari.div(4, 2));
		assertEquals(3, ari.div(7, 2));
	}
	
	@Test
	void testDivWithIntDenomIsZero() {
		try {
			ari.div(3, 0);
			fail("Exception was Expected...");
		} catch (Exception e) {
			
		}
	}

}

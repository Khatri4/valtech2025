package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void testSquareNow() {
		Square square = (a) -> a * a;
		
		assertEquals(0, square.squareNow(0));
		assertEquals(0, square.squareNow(-0));
		assertEquals(1, square.squareNow(1));
		assertNotEquals(0, square.squareNow(1));
		assertNotEquals(5, square.squareNow(2));
		assertNotEquals(3, square.squareNow(1));
		assertEquals(4, square.squareNow(-2));
	}

}

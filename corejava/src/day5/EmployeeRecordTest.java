package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assignment.Employee.Gender;

class EmployeeRecordTest {

	@Test
	void test() {
		EmployeeRecord er = new EmployeeRecord(1, "ABC", 23, Gender.MALE, 12000, 5, 2);
		assertEquals(1, er.id());
		assertEquals("ABC", er.name());
		assertEquals(23, er.age());
		assertEquals(Gender.MALE, er.gender());
		assertEquals(12000, er.salary());
		assertEquals(5, er.experience());
		assertEquals(2, er.level());
		
		System.out.println(er);
		
		EmployeeRecord er1 = new EmployeeRecord(1, "ABC", 23, Gender.MALE, 12000, 5, 2);
		System.out.println(er1);
		
		assertEquals(er, er1);
		assertEquals(er.hashCode(), er1.hashCode());
		
		EmployeeRecord er2 = new EmployeeRecord(1, "ABCD", 23, Gender.MALE, 12000, 5, 2);
		System.out.println(er2);
		
		assertNotEquals(er, er2);
		assertNotEquals(er.hashCode(), er2.hashCode());
		assertFalse(er.hashCode() == er2.hashCode());
		
		assertEquals(2500, er.computeBonus());
	}

}

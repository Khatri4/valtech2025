package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assignment.Employee.Gender;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao = new EmployeeDAOImpl();
		
//		dao.save(new Employee(2,"working", 24,11000, Gender.FEMALE, 6,3));
//		
//		Employee e = new Employee(1, "DEF", 31, 120000, Gender.MALE, 3,2);
//		dao.update(e);
//		
//		
//		e = dao.get(1);
//		assertEquals(1, e.getId());
//		assertEquals("DEF", e.getName());
//		assertEquals(31, e.getAge());
//		assertEquals(Gender.MALE, e.getGender());
//		assertEquals(120000, e.getSalary());
//		assertEquals(2, e.getExperience());
//		assertEquals(3, e.getLevel());
//		
//		assertTrue(dao.getAll().size()>1);
//		dao.delete(2);
		
	}
	

}

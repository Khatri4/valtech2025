package servlets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DeptDAOImplTest {

	@Test
	void testInsert() {
		DeptDAO dao = new DeptDAOImpl();
		
//		dao.save(new Dept(5,"SE", "BLR"));
		
//		Dept d = new Dept(3, "Marketing", "ABD");
//		dao.update(d);
//		System.out.println(dao.getDept(5));
		
//		
//		d = dao.getDept(4);
//		assertEquals(4, d.getId());
//		assertEquals("SE", d.getName());
//		assertEquals("ABD", d.getLocation());
//	
		
//		assertTrue(dao.getAll().size()>1);
//		dao.delete(5);
		
		
		System.out.println(dao.first());
		System.out.println(dao.last());
		System.out.println(dao.next(2));
		System.out.println(dao.previous(3));
	
	}
}

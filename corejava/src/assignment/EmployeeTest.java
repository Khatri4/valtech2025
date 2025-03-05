package assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment.Employee.Gender;
class EmployeeTest {
	
	private EmployeeService empService;

    @BeforeEach
    void setUp() {
        empService = new EmployeeServiceImpl();  
    }
	
//	public EmployeeTest(EmployeeService empService) {
//        this.empService = empService;
//    }
//	
//	method for adding employees
	private List<Employee> addEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(Employee.builder().id(1).name("Raj").age(20).salary(200000).gender("MALE").level(1).experience(2).build());
		employees.add(Employee.builder().id(2).name("Arya").age(22).salary(100000).gender("MALE").level(1).experience(1).build());
		employees.add(Employee.builder().id(3).name("Bhavya").age(32).salary(300000).gender("MALE").level(1).experience(2).build());
		employees.add(Employee.builder().id(4).name("Varnika").age(22).salary(200000).gender("FEMALE").level(2).experience(2).build());
		employees.add(Employee.builder().id(5).name("Hemant").age(32).salary(400000).gender("MALE").level(2).experience(2).build());
		employees.add(Employee.builder().id(6).name("Rushab").age(21).salary(202000).gender("MALE").level(3).experience(3).build());
		employees.add(Employee.builder().id(7).name("Tej").age(21).salary(210000).gender("MALE").level(3).experience(3).build());
		employees.add(Employee.builder().id(8).name("Sakshi S").age(24).salary(400000).gender("FEMALE").level(4).experience(2).build());
		employees.add(Employee.builder().id(9).name("Sakshi G").age(25).salary(500000).gender("FEMALE").level(4).experience(2).build());
		employees.add(Employee.builder().id(10).name("Indrajeet").age(26).salary(600000).gender("MALE").level(1).experience(4).build());
		employees.add(Employee.builder().id(11).name("Vishal").age(23).salary(700000).gender("MALE").level(1).experience(2).build());
		employees.add(Employee.builder().id(12).name("Suhas").age(23).salary(200000).gender("MALE").level(2).experience(1).build());
		employees.add(Employee.builder().id(13).name("Mayur").age(24).salary(300000).gender("MALE").level(2).experience(2).build());
		employees.add(Employee.builder().id(14).name("Mital").age(18).salary(500000).gender("FEMALE").level(3).experience(1).build());
		employees.add(Employee.builder().id(15).name("Akshit").age(19).salary(100000).gender("MALE").level(3).experience(2).build());
		employees.add(Employee.builder().id(16).name("Dev").age(19).salary(900000).gender("MALE").level(4).experience(2).build());
		return employees;
	}

	@Test
	void testSort() {
		List<Employee> employees = addEmployees();
		
		Collections.sort(employees);
		
		for (Employee e : employees) {
			System.out.println(e);
		}	
		
		
		
		Map<Gender, List<Employee>> mapGenderEmp = employees.stream()
				.collect(Collectors.groupingBy(
						Employee::getGender));;
//						Collectors.mapping(Employee::getName,Collectors.toList())
//						));
		
						mapGenderEmp.forEach((gender,names) -> {
							System.out.println("Gender :"+gender);
//							System.out.println("Employees :"+names));
							names.forEach(e->System.out.println(e.getName()));
						});
	}


	

	
	@Test
	void testHashCode() {
		Employee e1 = new Employee(1,"Raj",19,20000,Gender.MALE,1,1);
		Employee e2 = new Employee(1,"Raj",19,20000,Gender.MALE,1,1);
		Employee e3 = new Employee(2,"Raj",19,20000,Gender.MALE,1,1);
		System.out.println(e1.hashCode());
		assertEquals(e1.hashCode(), e2.hashCode());
		assertNotEquals(e1.hashCode(), e3.hashCode());
	
	}
	
	@Test
	void testEquals() {
		Employee e1 = new Employee(1,"Raj",19,20000,Gender.MALE,1,1);
		Employee e2 = new Employee(1,"Raj",19,20000,Gender.MALE,1,1);
		Employee e3 = new Employee(2,"Raj",19,20000,Gender.MALE,1,1);
		
		assertFalse(e1.equals(e3));
		assertTrue(e1.equals(e2));
	}
		
	List<Employee> employees = addEmployees();
	
	
	@Test
	void testEmpById() {
		List<Employee> myNewEmp = empService.getEmpById(employees, 2);
		assertEquals("Arya", myNewEmp.get(0).getName());
	}
	
	
	@Test
	void testEmpByLevel() {
		List<Employee> myNewEmp = empService.getEmpByLevel(employees, 2);
		System.out.println(myNewEmp);
		double totalSalary = empService.getSumOfSalary(myNewEmp);
		System.out.println("Total Salary: "+totalSalary);
		
		assertEquals(1100000.0, totalSalary);
		assertNotEquals(1101000.0, totalSalary);
	}
	
	
	@Test
	void testEmpByGender() {
		List<Employee> myNewEmp1 = empService.getEmpByGender(employees, Gender.FEMALE);
		System.out.println(myNewEmp1);
		double totalSalary1 = empService.getSumOfSalary(myNewEmp1);
		System.out.println("Total Salary: "+totalSalary1);
		
		assertEquals(1600000.0, totalSalary1);
		assertNotEquals(1601000.0, totalSalary1);
	}
	
	
	@Test
	void testEmpByName() {
		List<Employee> myNewEmp2 = empService.getEmpByName(employees, "i"); 
		System.out.println("------------------"+myNewEmp2);
		double totalSalary2 = empService.getSumOfSalary(myNewEmp2);
		System.out.println("Total Salary 2: "+totalSalary2);
		
		assertEquals(2400000.0, totalSalary2);
		assertNotEquals(2410000.0, totalSalary2);
	}
	
	@Test
	void testEmpByLevelAndGender() {
		List<Employee> myNewEmp3 = empService.getEmpByLevelAndGender(employees, 1, Gender.MALE);
		System.out.println(myNewEmp3);
		double totalSalary3 = empService.getSumOfSalary(myNewEmp3);
		System.out.println("Total Salary 3: "+ totalSalary3);
		
		assertEquals(1900000.0, totalSalary3);
		assertNotEquals(1910000.0, totalSalary3);
	}
	
	
	@Test
	void testEmpByIgnoreCase() {
		List<Employee> myNewEmp4 = empService.getEmpByIgnoreCase(employees, "e");
		System.out.println("------------------"+myNewEmp4);
		double totalSalary4 = empService.getSumOfSalary(myNewEmp4);
		System.out.println("Total Salary 4: "+totalSalary4);
		
		assertEquals(3702000.0, totalSalary4);
		assertNotEquals(2410000.0, totalSalary4);
	}
	
	

}





//@Test
//void testStreamApi() {		
//	List<Employee> employees = addEmployees();
//	
//	
//
////	emp by level
//	List<Employee> myNewEmp = empService.getEmpByLevel(employees, 2);
//	System.out.println(myNewEmp);
//	double totalSalary = empService.getSumOfSalary(myNewEmp);
//	System.out.println("Total Salary: "+totalSalary);
//	
//	assertEquals(1100000.0, totalSalary);
//	assertNotEquals(1101000.0, totalSalary);
//	
//	
////	emp by gender
//	List<Employee> myNewEmp1 = empService.getEmpByGender(employees, Gender.FEMALE);
//	System.out.println(myNewEmp1);
//	double totalSalary1 = empService.getSumOfSalary(myNewEmp1);
//	System.out.println("Total Salary: "+totalSalary1);
//	
//	assertEquals(1600000.0, totalSalary1);
//	assertNotEquals(1601000.0, totalSalary1);
//
//	
////	emp by name
//	List<Employee> myNewEmp2 = empService.getEmpByName(employees, "i"); 
//	System.out.println("------------------"+myNewEmp2);
//	double totalSalary2 = empService.getSumOfSalary(myNewEmp2);
//	System.out.println("Total Salary 2: "+totalSalary2);
//	
//	assertEquals(2400000.0, totalSalary2);
//	assertNotEquals(2410000.0, totalSalary2);
//
//	
////	emp by level and gender
//	List<Employee> myNewEmp3 = empService.getEmpByLevelAndGender(employees, 1, Gender.MALE);
//	System.out.println(myNewEmp3);
//	double totalSalary3 = empService.getSumOfSalary(myNewEmp3);
//	System.out.println("Total Salary 3: "+ totalSalary3);
//	
//	assertEquals(1900000.0, totalSalary3);
//	assertNotEquals(1910000.0, totalSalary3);
//
//	
////	emp by ignore case
//	List<Employee> myNewEmp4 = empService.getEmpByIgnoreCase(employees, "e");
//	System.out.println("------------------"+myNewEmp4);
//	double totalSalary4 = empService.getSumOfSalary(myNewEmp4);
//	System.out.println("Total Salary 4: "+totalSalary4);
//	
//	assertEquals(3702000.0, totalSalary4);
//	assertNotEquals(2410000.0, totalSalary4);
//}

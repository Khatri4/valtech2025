package dao;

import java.util.List;

public interface EmployeeDAO {
	
	void save(Employee e);
	
	void update(Employee e);
	
	void delete(int id);
	
	Employee get(int id);
	
	List<Employee> getAll();
	
	List<Employee> sortById(String sortOrder);
	
	List<Employee> sortByName(String sortOrder);
	
	List<Employee> sortByAge(String sortOrder);
	
	List<Employee> sortByGender(String sortOrder);
	
	List<Employee> sortBySalary(String sortOrder);
	
	List<Employee> sortByExperience(String sortOrder);
	
	List<Employee> sortByLevel(String sortOrder);
	
	List<Employee> sortByDeptid(String sortOrder);
	
	List<Employee> getEmpByDeptID(int deptid);
	
//	for search operations
	
	List<Employee> getEmpByName(String name);
	
	List<Employee> getEmpByLevel(String bylevel, int level);
	
	List<Employee> getEmpByExperience(String byExp, int exp);
	
	List<Employee> getEmpBySalary(String bySalary, int sal);
	
	List<Employee> getEmpByAge(String byAge, int age);
	
}

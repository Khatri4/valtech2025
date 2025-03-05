package dao;

import java.util.List;

public interface EmployeeService {

	//	sorting
	List<Employee> sortById(String sortOrder, List<Employee> emp);

	List<Employee> sortByName(String sortOrder, List<Employee> emp);

	List<Employee> sortByAge(String sortOrder, List<Employee> emp);

	List<Employee> sortByGender(String sortOrder, List<Employee> emp);

	List<Employee> sortBySalary(String sortOrder, List<Employee> emp);

	List<Employee> sortByExperience(String sortOrder, List<Employee> emp);

	List<Employee> sortByLevel(String sortOrder, List<Employee> emp);

	List<Employee> sortByDeptid(String sortOrder, List<Employee> emp);

	List<Employee> getEmpByName(String name);

	List<Employee> getEmpByLevel(String byLevel, int level);

	List<Employee> getEmpByExperience(String byExp, int exp);

	List<Employee> getEmpBySalary(String bySalary, int sal);

	List<Employee> getEmpByAge(String byAge, int age);

}
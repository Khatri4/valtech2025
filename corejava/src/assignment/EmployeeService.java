package assignment;

import java.util.List;

import assignment.Employee.Gender;

public interface EmployeeService {

	//	emp by level
	List<Employee> getEmpByLevel(List<Employee> emps, int level);

	//	emp by gender
	List<Employee> getEmpByGender(List<Employee> emps, Gender gender);

	//	emp by name
	List<Employee> getEmpByName(List<Employee> emps, String name);

	//	emp by level and gender
	List<Employee> getEmpByLevelAndGender(List<Employee> emps, int level, Gender gender);

	//	emp by ignore case
	List<Employee> getEmpByIgnoreCase(List<Employee> emps, String name);
	
	//	emp by id
	List<Employee> getEmpById(List<Employee> emps, long id);
	
	// get sum of salary
	double getSumOfSalary(List<Employee> employees);

}
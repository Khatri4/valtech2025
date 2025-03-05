package assignment;

import java.util.List;
import java.util.stream.Collectors;

import assignment.Employee.Gender;

public class EmployeeServiceImpl implements EmployeeService {
	
//	emp by level
	@Override
	public List<Employee> getEmpByLevel(List<Employee> emps, int level){
		return emps.stream().filter(employee -> employee.getLevel()==level).collect(Collectors.toList());
	}
	
//	emp by gender
	@Override
	public List<Employee> getEmpByGender(List<Employee> emps, Gender gender){
		return emps.stream().filter(employee -> employee.getGender()==gender).collect(Collectors.toList());
	}
	
//	emp by name
	@Override
	public List<Employee> getEmpByName(List<Employee> emps, String name){
		return emps.stream().filter(employee -> employee.getName().contains(name)).collect(Collectors.toList());
	}
	
//	emp by level and gender
	@Override
	public List<Employee> getEmpByLevelAndGender(List<Employee> emps, int level, Gender gender){
		return emps.stream().filter(employee -> employee.getGender()==gender && employee.getLevel()==level).collect(Collectors.toList());
	}
	
//	emp by ignore case
	@Override
	public List<Employee> getEmpByIgnoreCase(List<Employee> emps, String name){
		return emps.stream().filter(employee -> !employee.getName().contains(name)).collect(Collectors.toList());
	}
	
//	emp by id
	public List<Employee> getEmpById(List<Employee> emps, long id){
		return emps.stream().filter(employee -> employee.getId()==id).collect(Collectors.toList());
	}
	
	
//	get sum of salary
	@Override
	public double getSumOfSalary(List<Employee> employees) {
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }

}

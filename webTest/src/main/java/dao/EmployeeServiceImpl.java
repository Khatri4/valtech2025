package dao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO empDAO;
	
	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.empDAO = dao;
	}

	//	sorting
	@Override
	public List<Employee> sortById(String sortOrder, List<Employee> emp){
//		List<Employee> emp_list = empDAO.getAll();
		
		if("asc".equals(sortOrder)) {
			return emp.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
		} else {
			return emp.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> sortByName(String sortOrder, List<Employee> emp){
//		List<Employee> emp_list = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emp.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		} else {
			return emp.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> sortByAge(String sortOrder, List<Employee> emp){
//		List<Employee> emp_list = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emp.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		} else {
			return emp.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> sortByGender(String sortOrder, List<Employee> emp){
//		List<Employee> emp_list = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emp.stream().sorted(Comparator.comparing(Employee::getGender)).collect(Collectors.toList());
		} else {
			return emp.stream().sorted(Comparator.comparing(Employee::getGender).reversed()).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> sortBySalary(String sortOrder, List<Employee> emp){
//		List<Employee> emp_list = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emp.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		} else {
			return emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> sortByExperience(String sortOrder, List<Employee> emp){
//		List<Employee> emp_list = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emp.stream().sorted(Comparator.comparing(Employee::getExperience)).collect(Collectors.toList());
		} else {
			return emp.stream().sorted(Comparator.comparing(Employee::getExperience).reversed()).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> sortByLevel(String sortOrder, List<Employee> emp){
//		List<Employee> emp_list = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emp.stream().sorted(Comparator.comparing(Employee::getLevel)).collect(Collectors.toList());
		} else {
			return emp.stream().sorted(Comparator.comparing(Employee::getLevel).reversed()).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> sortByDeptid(String sortOrder, List<Employee> emp){
//		List<Employee> emp_list = empDAO.getAll();
		if("asc".equals(sortOrder)) {
			return emp.stream().sorted(Comparator.comparing(Employee::getDeptid)).collect(Collectors.toList());
		} else {
			return emp.stream().sorted(Comparator.comparing(Employee::getDeptid).reversed()).collect(Collectors.toList());
		}
	}
	
	
//	search by diff diff param
	
	@Override
	public List<Employee> getEmpByName(String name){
		List<Employee> emp = empDAO.getAll();
		return emp.stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList());
		
	}
	
	@Override
	public List<Employee> getEmpByLevel(String byLevel, int level){
		List<Employee> emp = empDAO.getAll();
		if ("greaterThanLevel".equals(byLevel)) {
			return emp.stream().filter(l -> l.getLevel() > level).collect(Collectors.toList());
		} else {
			return emp.stream().filter(l -> l.getLevel() < level).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> getEmpByExperience(String byExp, int exp){
		List<Employee> emp = empDAO.getAll();
		if ("greaterThanExp".equals(byExp)) {
			return emp.stream().filter(e -> e.getExperience() > exp).collect(Collectors.toList());
		} else {
			return emp.stream().filter(e -> e.getExperience() < exp).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> getEmpBySalary(String bySalary, int sal) {
		List<Employee> emp = empDAO.getAll();
		if ("greaterThanSal".equals(bySalary)) {
			return emp.stream().filter(s -> s.getSalary() > sal).collect(Collectors.toList());
		} else {
			return emp.stream().filter(s -> s.getSalary() < sal).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> getEmpByAge(String byAge, int age) {
		List<Employee> emp = empDAO.getAll();
		if ("greaterThanAge".equals(byAge)) {
			return emp.stream().filter(a -> a.getAge() > age).collect(Collectors.toList());
		} else {
			return emp.stream().filter(a -> a.getAge() < age).collect(Collectors.toList());
		}
	}

}

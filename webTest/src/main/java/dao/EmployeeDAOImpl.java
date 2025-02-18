package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import jakarta.servlet.ServletContext;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	ServletContext sc;
	
	public EmployeeDAOImpl(ServletContext sc) {
		this.sc = sc;
	}

	private Connection getConnection(ServletContext sc) throws SQLException{
		String url = (String) sc.getAttribute("url");
		String username = (String) sc.getAttribute("username");
		String password = (String) sc.getAttribute("password");
		
		System.out.println("=========>>>>>>>>>" + sc.getAttribute("url"));
		System.out.println("=========>>>>>>>>>" + sc.getAttribute("password"));
		System.out.println("=========>>>>>>>>>" + sc.getAttribute("username"));
		
		
		return DriverManager.getConnection(url, username, password);
	}
	
	
	
	@Override
	public void save(Employee e) {
		try (Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTID,ID) VALUES (?,?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted = "+rowsAffected);
			
			} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}



	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3,e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setLong(7, e.getDeptid());
		ps.setLong(8, e.getId());

	}

	@Override
	public void update(Employee e) {
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("UPDATE EMPLOYEE SET NAME = ?,AGE = ?,GENDER = ?,SALARY = ?,EXPERIENCE = ?,LEVEL = ?, DEPTID = ? WHERE ID = ?");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = "+rowsAffected);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	
	
	
	
	@Override
	public void delete(int id) {
		try (Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("DELETE FROM EMPLOYEE WHERE ID = ? ");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			System.out.println("Rows deleted = "+rows);
			
		} catch (Exception ex) {
			throw new RuntimeException();
		}
	}

	
	
	
	@Override
	public Employee get(int id) {
		try (Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTID FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { // if this next returns true then we have another row. next return false, we are at end of the resultset
				Employee e = populateEmployee(rs);
				return e;
			}else {
				new RuntimeException("No Employee with id "+id+" found");
			}
		} catch (Exception ex) {
			throw new RuntimeException();
		} 
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		
		return Employee.builder().id(rs.getLong(1)).name(rs.getString(2)).age(rs.getInt(3))
				.gender(rs.getString(4)).salary(rs.getFloat(5)).experience(rs.getInt(6))
				.level(rs.getInt(7)).deptid(rs.getInt(8)).build();
	}



	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		
		System.out.println("=========>>>>>>>>>" + sc.getAttribute("url"));
		System.out.println("=========>>>>>>>>>" + sc.getAttribute("password"));
		System.out.println("=========>>>>>>>>>" + sc.getAttribute("username"));
		
		
		System.out.println("lllllllllllllllllllll" + this.sc);
		try (Connection conn = getConnection(this.sc)){
			
			
			
			
			System.out.println("=========>>>>>>>>>" + sc.getAttribute("url"));
			System.out.println("=========>>>>>>>>>" + sc.getAttribute("password"));
			System.out.println("=========>>>>>>>>>" + sc.getAttribute("username"));
			
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTID FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		} catch (Exception ex) {
			throw new  RuntimeException(); 
		}
		return emps;
	}

//	sorting
	public List<Employee> sortById(String sortOrder){
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());
		}
	}
	
	public List<Employee> sortByName(String sortOrder){
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		}
	}
	
	public List<Employee> sortByAge(String sortOrder){
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
		}
	}
	
	public List<Employee> sortByGender(String sortOrder){
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getGender)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getGender).reversed()).collect(Collectors.toList());
		}
	}
	
	public List<Employee> sortBySalary(String sortOrder){
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		}
	}
	
	public List<Employee> sortByExperience(String sortOrder){
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getExperience)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getExperience).reversed()).collect(Collectors.toList());
		}
	}
	
	public List<Employee> sortByLevel(String sortOrder){
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getLevel)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getLevel).reversed()).collect(Collectors.toList());
		}
	}
	
	public List<Employee> sortByDeptid(String sortOrder){
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getDeptid)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getDeptid).reversed()).collect(Collectors.toList());
		}
	}
	
	
	
//	get employees by dept id
	@Override
	public List<Employee> getEmpByDeptID(int deptid) {
	    List<Employee> employeeList = new ArrayList<>();
	    
	    try (Connection conn = getConnection(this.sc);
	         PreparedStatement ps = conn.prepareStatement(
	            "SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL, DEPTID FROM EMPLOYEE WHERE DEPTID = ?")) {
	        
	        ps.setInt(1, deptid);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	             employeeList.add(populateEmployee(rs));
	        }
	    } catch (SQLException ex) {
	        throw new RuntimeException("Database error while fetching employees by department ID", ex);
	    }
	    
	    return employeeList; 
	}
	
	
//	search by diff diff param
	
	@Override
	public List<Employee> getEmpByName(String name){
		List<Employee> emp = getAll();
		return emp.stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList());
		
	}
	
	@Override
	public List<Employee> getEmpByLevel(String byLevel, int level){
		List<Employee> emp = getAll();
		if ("greaterThanLevel".equals(byLevel)) {
			return emp.stream().filter(l -> l.getLevel() > level).collect(Collectors.toList());
		} else {
			return emp.stream().filter(l -> l.getLevel() < level).collect(Collectors.toList());
		}
	}
	
	@Override
	public List<Employee> getEmpByExperience(String byExp, int exp){
		List<Employee> emp = getAll();
		if ("greaterThanExp".equals(byExp)) {
			return emp.stream().filter(e -> e.getExperience() > exp).collect(Collectors.toList());
		} else {
			return emp.stream().filter(e -> e.getExperience() < exp).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> getEmpBySalary(String bySalary, int sal) {
		List<Employee> emp = getAll();
		if ("greaterThanSal".equals(bySalary)) {
			return emp.stream().filter(s -> s.getSalary() > sal).collect(Collectors.toList());
		} else {
			return emp.stream().filter(s -> s.getSalary() < sal).collect(Collectors.toList());
		}
	}



	@Override
	public List<Employee> getEmpByAge(String byAge, int age) {
		List<Employee> emp = getAll();
		if ("greaterThanAge".equals(byAge)) {
			return emp.stream().filter(a -> a.getAge() > age).collect(Collectors.toList());
		} else {
			return emp.stream().filter(a -> a.getAge() < age).collect(Collectors.toList());
		}
	}
	
	
}

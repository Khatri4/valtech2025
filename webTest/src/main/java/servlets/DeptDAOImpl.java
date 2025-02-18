package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.Employee;
import jakarta.servlet.ServletContext;

public class DeptDAOImpl implements DeptDAO {
	
	ServletContext sc;
	
	public DeptDAOImpl(ServletContext sc) {
		this.sc = sc;
	}

	private Connection getConnection(ServletContext sc) throws SQLException{
		String url = (String) sc.getAttribute("url");
		String username = (String) sc.getAttribute("username");
		String password = (String) sc.getAttribute("password");
		
		return DriverManager.getConnection(url, username, password);
	}
	
	
	
	@Override
	public void save(Dept d) {
		try (Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO DEPT (ID, NAME, LOCATION) VALUES (?,?,?)");
//			setValuesToPreparedStatement(d, ps);
			ps.setInt(1, d.getId());
			ps.setString(2, d.getName());
			ps.setString(3, d.getLocation());
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted = "+rowsAffected);
			
			} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}



	private void setValuesToPreparedStatement(Dept d, PreparedStatement ps) throws SQLException {
		ps.setInt(1, d.getId());
		ps.setString(2, d.getName());
		ps.setString(3, d.getLocation());
		ps.setInt(4, d.getId());
	}

	@Override
	public void update(Dept d) {
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("UPDATE DEPT SET ID = ?, NAME = ?,LOCATION = ? WHERE ID = ?");
			setValuesToPreparedStatement(d, ps);
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
					("DELETE FROM DEPT WHERE ID = ? ");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			System.out.println("Rows deleted = "+rows);
			
		} catch (Exception ex) {
			throw new RuntimeException();
		}
	}

	
	
	
	@Override
	public Dept getDept(int id) {
		try (Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("SELECT * FROM DEPT WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				// if this next returns true then we have another row. next return false, we are at end of the resultset
				Dept d = populateDept(rs);
				return d;
			}else {
				new RuntimeException("No Dept with id "+id+" found");
			}
		} catch (Exception ex) {
			throw new RuntimeException();
		} 
		return null;
	}

	private Dept populateDept(ResultSet rs) throws SQLException {
		return Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build();
	}



	@Override
	public Set<Dept> getAll() {
		Set<Dept> dpts = new HashSet<Dept>();
		try (Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,LOCATION FROM DEPT");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				dpts.add(populateDept(rs));
			}
		} catch (Exception ex) {
			throw new  RuntimeException(); 
		}
		return dpts;
	}



	@Override
	public Dept first() {
		try (Connection conn = getConnection(this.sc)){
			DeptDAO dao = new DeptDAOImpl(this.sc);
			PreparedStatement ps = conn.prepareStatement
					("select id,name,location from dept where id = (select min(id) from dept)");
//			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				// if this next returns true then we have another row. next return false, we are at end of the resultset
				Dept d = populateDept(rs);
				return d;
			}else {
				new RuntimeException("No Dept with id found");
			}
		} catch (Exception ex) {
			throw new RuntimeException();
		} 
		return null;
	}



	@Override
	public Dept last() {
		try (Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("select id,name,location from dept where id = (select max(id) from dept)");
//			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				// if this next returns true then we have another row. next return false, we are at end of the resultset
				Dept d = populateDept(rs);
				return d;
			}else {
				new RuntimeException("No Dept with id found");
			}
		} catch (Exception ex) {
			throw new RuntimeException();
		} 
		return null;
	}



	@Override
	public Dept next(int id) {
		try (Connection conn = getConnection(this.sc)){
			DeptDAO dao = new DeptDAOImpl(this.sc);
			PreparedStatement ps = conn.prepareStatement
					("select id,name,location from dept where id = (select min(id) from dept where id > ?)");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) { 
				// if this next returns true then we have another row. next return false, we are at end of the resultset
				Dept d = populateDept(rs);
				return d;
			}else {
				return dao.first();
//				new RuntimeException("No Dept with id "+id+" found");
			}
		} catch (Exception ex) {
			throw new RuntimeException();
		} 
		
	}



	@Override
	public Dept previous(int id) {
		try (Connection conn = getConnection(this.sc)){
			DeptDAO dao = new DeptDAOImpl(this.sc);
			PreparedStatement ps = conn.prepareStatement
					("select id,name,location from dept where id = (select max(id) from dept where id < ?)");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				// if this next returns true then we have another row. next return false, we are at end of the resultset
				Dept d = populateDept(rs);
				return d;
			}else {
				return dao.last();
//				new RuntimeException("No Dept with id "+id+" found");
			}
		} catch (Exception ex) {
			throw new RuntimeException();
		} 
//		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	


}

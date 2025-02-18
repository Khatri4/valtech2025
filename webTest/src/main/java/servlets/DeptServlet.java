package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/depts")
public class DeptServlet extends HttpServlet {
	
	private DeptDAO deptDAO;
	private EmployeeDAO employeeDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		deptDAO = new DeptDAOImpl(config.getServletContext());
		employeeDAO = new EmployeeDAOImpl(config.getServletContext());
//		deptDAO.save(new Dept(1, "HR", "Blr"));
//		deptDAO.save(new Dept(2, "HR", "Ahm"));
//		deptDAO.save(new Dept(3, "Dev", "Blr"));
//		deptDAO.save(new Dept(4, "Dev", "Ahm"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("operation");
		HttpSession session = req.getSession();
		
		
		
		Dept current =(Dept) session.getAttribute("current");
		if(current==null) {
			current = deptDAO.first();
		} else {
			if("First".equals(operation)) {
				current = deptDAO.first();
			} else if("Last".equals(operation)){
				current = deptDAO.last();
			} else if("Previous".equals(operation)){
				current = deptDAO.previous(current.getId());
			} else {
				current = deptDAO.next(current.getId());
				
				
			}
		}
		session.setAttribute("current", current);
		
		 // Fetch employees related to the current department and store in session
	    session.setAttribute("employees", employeeDAO.getEmpByDeptID(current.getId()));
	    
//		expressions in jsp can work with objects in session also
		req.setAttribute("dept", current);
//		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		
		
		if("Cancel".equals(operation)) {
			req.setAttribute("dept", deptDAO.getDept(current.getId()));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		
		System.out.println("--------->>>>>>>>>>>>>");
//		System.out.println("=================>>>>>>>>>>>>>>>>>>> " + current);
	
		
	//	System.out.println("------------>>>>>>>>>>>>>>>>>>"+dept);
		
		if("Save".equals(operation) ) {
			Dept dept = Dept.builder()
					.id(Integer.parseInt(req.getParameter("id")))
					.name(req.getParameter("name"))
					.location(req.getParameter("location"))
					.build();
			System.out.println("888888888888888888888"+dept);

			deptDAO.save(dept);
			System.out.println(dept);
			req.setAttribute("dept", deptDAO.getDept(dept.getId()));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		if("Update".equals(operation)) {
			Dept dept = Dept.builder()
					.id(Integer.parseInt(req.getParameter("id")))
					.name(req.getParameter("name"))
					.location(req.getParameter("location"))
					.build();
			deptDAO.update(dept);
			req.setAttribute("dept", deptDAO.getDept(dept.getId()));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		Cookie [] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName() + " " + cookies[i].getValue());
		}
		
		resp.addCookie(new Cookie("operation", operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String sortOrder = req.getParameter("sortOrder");
//		String sortBy = req.getParameter("sortBy");
		req.setAttribute("dept", deptDAO.first());
		HttpSession session = req.getSession();
		session.setAttribute("current", deptDAO.first());
		String operation = req.getParameter("operation");
		Dept current = (Dept) session.getAttribute("current");		
		
		
		
		if (current == null) {
	        current = deptDAO.first();  // Set first department if not found in session
	        req.getSession().setAttribute("current", current);
	    }
		
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Dept d = deptDAO.getDept(id);
			req.setAttribute("dept", d);
			req.setAttribute("mode", "Update");
			req.setAttribute("readonly", "readonly");
			req.getRequestDispatcher("editDepts.jsp").forward(req, resp);
			return;
		}
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			deptDAO.delete(id);
			req.setAttribute("dept", deptDAO.getDept(current.getId()));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editDepts.jsp").forward(req, resp);
			return;
		}
		
		
		session.setAttribute("employees",employeeDAO.getEmpByDeptID(current.getId()));
//		req.setAttribute("dept", dept);
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		
		
	}

}

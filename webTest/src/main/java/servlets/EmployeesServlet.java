package servlets;

import java.io.IOException;
import java.util.List;

import dao.Employee;
import dao.Employee.Gender;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {
	
	private EmployeeDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new EmployeeDAOImpl(config.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		String sortOrder = req.getParameter("sortOrder");
		String sortBy = req.getParameter("sortBy");
		String search = req.getParameter("search");
		String searchBy = req.getParameter("searchBy");
		
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Employee e = dao.get(id);
			req.setAttribute("emp", e);
			req.setAttribute("mode", "Update");
			req.setAttribute("readonly", "readonly");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		
		if("sorting".equals(operation)) {
			if (sortOrder == null) {
	            sortOrder = "asc";
			}
			if (sortBy == null) {
		        sortBy = "id";
		    }
			List<Employee> employees = null;
//			if("sorting".equals(operation)) {
				switch (sortBy) {
	            case "id":
	                employees = dao.sortById(sortOrder);
	                break;
	            case "name":
	                employees = dao.sortByName(sortOrder);
	                break;
	            case "age":
	                employees = dao.sortByAge(sortOrder);
	                break;
	            case "gender":
	                employees = dao.sortByGender(sortOrder);
	                break;
	            case "salary":
	                employees = dao.sortBySalary(sortOrder);
	                break;
	            case "experience":
	                employees = dao.sortByExperience(sortOrder);
	                break;
	            case "level":
	                employees = dao.sortByLevel(sortOrder);
	                break;
	            case "deptid":
	                employees = dao.sortByDeptid(sortOrder);
	                break;    
	            default:
	                employees = dao.sortById(sortOrder); 
	                break;
	        }
//			}
//			employees = dao.sortById(sortOrder);
//			employees = dao.sortByName(sortOrder);
//			employees = dao.sortByAge(sortOrder);
//			employees = dao.sortByGender(sortOrder);
//			employees = dao.sortBySalary(sortOrder);
//			employees = dao.sortByExperience(sortOrder);
//			employees = dao.sortByLevel(sortOrder);
//			
//	        if ("desc".equals(sortOrder)) {
//	            employees = dao.sortById(); // Sort in descending order
//	            }  else {
//	           employees = dao.sortById(); // Sort in ascending order
//	        }
	        req.setAttribute("emps", employees);
	        req.setAttribute("sortOrder", sortOrder);
	        req.getRequestDispatcher("employees.jsp").forward(req, resp);
	        return;
		}
		
		
		
//		employees by search
		if("greaterThanSal".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpBySalary(searchBy, Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("lessThanSal".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpBySalary(searchBy, Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("greaterThanExp".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByExperience(searchBy, Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("lessThanExp".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByExperience(searchBy, Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("greaterThanAge".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByAge(searchBy, Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("lessThanAge".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByAge(searchBy, Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("greaterThanLevel".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByLevel(searchBy, Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("lessThanLevel".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByLevel(searchBy, Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("name".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByName(search));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		
		
		
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");

		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		Employee emp = Employee.builder()
				.id(Integer.parseInt(req.getParameter("id")))
				.name(req.getParameter("name"))
				.age(Integer.parseInt(req.getParameter("age")))
				.gender(req.getParameter("gender").toUpperCase())
				.salary(Integer.parseInt(req.getParameter("salary")))
				.experience(Integer.parseInt(req.getParameter("experience")))
				.level(Integer.parseInt(req.getParameter("level")))
				.deptid(Integer.parseInt(req.getParameter("deptid")))
				.build();
		
		if("Save".equals(operation)) {
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("Update".equals(operation)) {
			dao.update(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
	}
}

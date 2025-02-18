<%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="employees" method="get">
    <label for="search">Search:</label>
    <input type="text" id="search" name="search" placeholder="Search for employees">
    
    <label for="searchBy">Search by:</label>
    <select id="searchBy" name="searchBy">
        <option value="name">Name</option>
        <option value="greaterThanSal">Greater Than Salary </option>
        <option value="lessThanSal">Less Than Salary </option>
        <option value="greaterThanAge">Greater Than Age</option>
        <option value="lessThanAge">Less Than Age</option>
        <option value="greaterThanExp">Greater Than Experience</option>
        <option value="lessThanExp">Less Than Experience</option>
        <option value="greaterThanLevel">Greater Than Level</option>
        <option value="lessThanLevel">Less Than Level</option>
    </select>
    
    <input type="submit" value="Search">
</form>


<!-- <form action="employees" method="get">
<table>
<tr>
	<td>
	     <label for="name">Name:</label>
	    <input type="text" id="name" name="name" placeholder="Enter employee name">
    </td>
    
    <td>
	    <label for="greaterThanSal">Greater Than Salary:</label>
	    <input type="text" id="greaterThanSal" name="greaterThanSal">
    </td>
    
    <td>
	    <label for="lessThanSal">Less Than Salary:</label>
	    <input type="text" id="lessThanSal" name="lessThanSal">
    </td>
    
    <td>
	    <label for="greaterThanAge">Greater Than Age:</label>
	    <input type="text" id="greaterThanAge" name="greaterThanAge">
    </td>
    
    <td>
	    <label for="experience">Experience:</label>
	    <input type="text" id="experience" name="experience" placeholder="Enter years of experience">
    </td>
    
    <td>
	    <label for="level">Level:</label>
	    <input type="text" id="level" name="level" placeholder="Enter employee level">
    </td>
    
    <td>
    	<input type="submit" name = "operation" value="Search">
    </td>
</tr>   
</table> 
</form> -->





<table>
<tr>
	<th><a href="employees?operation=sorting&sortOrder=${sortOrder == 'asc' ? 'desc' : 'asc'}&sortBy=id">Id ${sortOrder == 'asc' ? '(asc)' : '(desc)'}</a></th>
	<th><a href="employees?operation=sorting&sortOrder=${sortOrder == 'asc' ? 'desc' : 'asc'}&sortBy=name">Name ${sortOrder == 'asc' ? '(asc)' : '(desc)'}</a></th>
	<th><a href="employees?operation=sorting&sortOrder=${sortOrder == 'asc' ? 'desc' : 'asc'}&sortBy=age">Age ${sortOrder == 'asc' ? '(asc)' : '(desc)'}</a></th>
	<th><a href="employees?operation=sorting&sortOrder=${sortOrder == 'asc' ? 'desc' : 'asc'}&sortBy=gender">Gender ${sortOrder == 'asc' ? '(asc)' : '(desc)'}</a></th>
	<th><a href="employees?operation=sorting&sortOrder=${sortOrder == 'asc' ? 'desc' : 'asc'}&sortBy=salary">Salary ${sortOrder == 'asc' ? '(asc)' : '(desc)'}</a></th>
	<th><a href="employees?operation=sorting&sortOrder=${sortOrder == 'asc' ? 'desc' : 'asc'}&sortBy=experience">Experience ${sortOrder == 'asc' ? '(asc)' : '(desc)'}</a></th>
	<th><a href="employees?operation=sorting&sortOrder=${sortOrder == 'asc' ? 'desc' : 'asc'}&sortBy=level">Level ${sortOrder == 'asc' ? '(asc)' : '(desc)'}</a></th>
	<th><a href="employees?operation=sorting&sortOrder=${sortOrder == 'asc' ? 'desc' : 'asc'}&sortBy=deptid">Dept ID ${sortOrder == 'asc' ? '(asc)' : '(desc)'}</a></th>
	<th>Action</th>
</tr>
<c:forEach items="${emps}" var="e">
	<tr>
		<td><c:out value="${e.id}"></c:out></td>   <!-- original way to write -->
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		<td>${e.deptid}</td>
		<td>
			<a href="employees?operation=Update&id=${e.id}">Update</a>
			<a href="employees?operation=Delete&id=${e.id}">Delete</a>
		</td>
	</tr>
</c:forEach>
<tr>
	<td colspan="7">
		<a href="employees?operation=new">New Employee</a>
	</td>
</tr>
</table>




<table>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Salary</th>
	<th>Experience</th>
	<th>Level</th>
	<th>Dept ID</th>
</tr>

<% 
	List<Employee> emps = (List<Employee>) request.getAttribute("emps");
	for(Employee e : emps){
%>
	<tr>
		<td>
			<%=e.getId() %>
		</td>
		<td>
			<%=e.getName() %>
		</td>
		<td>
			<%=e.getAge() %>
		</td>
		<td>
			<%=e.getGender() %>
		</td>
		<td>
			<%=e.getSalary() %>
		</td>
		<td>
			<%=e.getExperience() %>
		</td>
		<td>
			<%=e.getLevel() %>
		</td>
		<td>
			<%=e.getDeptid() %>
		</td>
	</tr>
<%}%>
</table>
</body>
</html>
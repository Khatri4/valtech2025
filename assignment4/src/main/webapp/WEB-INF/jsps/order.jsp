<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="order">
	<table>
		<!-- <tr>
			<td><input name="cusId" type="text" value="0" hidden="true"/></td>
		</tr> -->
		<tr>
			<td>Customer ID</td>
			<td><input name="cusId" type="text"/></td>
		</tr>
		<tr>
			<td>Item ID</td>
			<td><input name="itemId" type="text"/></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><input name="quantity" type="text"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input name="action" value="Add" type="submit"/>
				<input name="action" value="Cancel" type="submit"/>
			</td>
			
		</tr>
	</table>

</form>

</body>
</html>
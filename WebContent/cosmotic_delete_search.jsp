<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Cosmotic Delete</title>
</head>
<body>
	<%
		String category = request.getParameter("category");
		String name = request.getParameter("pname");
		String qty = request.getParameter("qty");
		String price = request.getParameter("price");
	%>
	<form action="cos_delete" method="post">
		<table border="1">
			<tbody>
				<tr>
				<tr>
					<td>Category :</td>
					<td><input type="text" name="category" value="<%=category%>"
						readonly></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="pname" value="<%=name%>" readonly></td>
				</tr>
				<tr>
					<td>Qty:</td>
					<td><input type="text" name="qty" value="<%=qty%>"
						readonly></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="text" name="price" value="<%=price%>"
						readonly></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="delete"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Modify Search Page</title>
</head>
<body>
	<%
		String category = request.getParameter("category");
		String name = request.getParameter("pname");
		String qty = request.getParameter("qty");
		String price = request.getParameter("price");
	%>
	<form action="cos_modify" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>Category :</td>
					<td><input type="text" name="category" value="<%=category%>"></td>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="pname" value="<%=name%>" readonly></td>
				</tr>
				<tr>
					<td>Quantity :</td>
					<td><input type="text" name="qty" value="<%=qty%>"></td>
				</tr>
				<tr>
					<td>Price :</td>
					<td><input type="text" name="price" value="<%=price%>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Modify"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>

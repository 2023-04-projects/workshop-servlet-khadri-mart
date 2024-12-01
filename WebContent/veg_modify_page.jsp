<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">

<meta charset="ISO-8859-1">
<title>Modify Item</title>
</head>
<body>
	<%
		String name = request.getParameter("veg_name");
		String qty = request.getParameter("veg_qty");
		String price = request.getParameter("veg_price");
	%>
	<form action="vegModifyPage" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>Vegetable Name: <input type="text" name="veg_name"
						value="<%=name%>" readonly>
					</td>
				</tr>
				<tr>
					<td>Vegetable Qty: <input type="text" name="veg_qty" id="qty"
						value="<%=qty%>">
					</td>
				</tr>
				<tr>
					<td>Vegetable Price: <input type="text" name="veg_price"
						id="price" value="<%=price%>">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Modify Vegetables"></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>
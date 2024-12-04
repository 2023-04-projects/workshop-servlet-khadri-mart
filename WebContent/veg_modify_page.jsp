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
		String vegName = request.getParameter("veg_name");
		String vegQty = request.getParameter("veg_qty");
		String vegPrice = request.getParameter("veg_price");
	%>
	<form action="vegModify" method="get">
		<table border="1">
			<tbody>
				<tr>
					<td>Vegetable Name: <input type="text" name="veg_name" value="<%=vegName%>" readonly>
					</td>
				</tr>
				<tr>
					<td>Vegetable Qty: <input type="text" name="veg_qty" id="qty" value="<%=vegQty%>">
					</td>
				</tr>
				<tr>
					<td>Vegetable Price: <input type="text" name="veg_price" id="price" value="<%=vegPrice%>">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Modify"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
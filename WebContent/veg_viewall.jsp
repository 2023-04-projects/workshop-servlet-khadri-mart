<%@page import="com.khadri.mart.vegetable.form.VegetableForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!DOCTYPE html>
<html>
<head>
<title>View All Vegetable Page</title>
</head>
<body>
	<form action="vegViewAll" method="get">
		<h2>View All Vegetable Items</h2>

		<table border="1">
			<thead>
				<tr>
					<th>Item</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<%
                List<VegetableForm> vegetableList = (List<VegetableForm>) request.getAttribute("vegetableList");

				if(vegetableList == null || vegetableList.isEmpty()){

				%>
				<tr>
					<td colspan="3">No vegetable items found.</td>
				</tr>
				<%
					} else {
						for (VegetableForm eachForm : vegetableList) {
				%>
				<tr>
					<td><%=eachForm.getVegName()%></td>
					<td><%=eachForm.getVegQty()%></td>
					<td><%=eachForm.getVegPrice()%></td>
				</tr>
				<%
					}
					}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>
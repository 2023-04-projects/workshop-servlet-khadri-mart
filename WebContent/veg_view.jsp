<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.khadri.mart.vegetable.dao.VegetableDao"%>
<%@ page import="com.khadri.mart.vegetable.form.VegetableForm"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vegetable List</title>
<style>
table {
	width: 50%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
	text-align: left;
}
</style>
</head>
<body>
<%
	String vName = request.getParameter("vName");

	if (vName != null && !vName.trim().isEmpty()) {
		// Call the DAO method to get the vegetable data
		VegetableDao vegetableDao = new VegetableDao();
		List<VegetableForm> vegetableList = vegetableDao.selectVegetables(vName);

		if (vegetableList.isEmpty()) {
		}
%>

<p>
	No vegetables found for the name "<%=vName%>".
</p>
<%
	} else {
%>
	<h1>Vegetable List</h1>
	<form action="vegetables.jsp" method="get">
		<label for="vName">Vegetable Name:</label> <input type="text"
			id="vName" name="vName" required>
		<button type="submit">Search</button>
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>Item</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<%
				// Loop through the list and display the vegetables
					for (VegetableForm vegetable : vegetableList) {
			%>


			<tr>
				<td><%=vegetable.getVegName()%></td>
				<td><%=vegetable.getVegQty()%></td>
				<td><%=vegetable.getVegPrice()%></td>
			</tr>

			<%
				}
				}
			%>
		
		</tbody>
	</table>
</body>
</html>
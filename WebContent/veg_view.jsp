<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.khadri.mart.vegetable.dao.VegetableDao"%>
<%@ page import="com.khadri.mart.vegetable.form.VegetableForm"%>
<%@ page import="java.util.*"%>

	<%
		ServletContext context = application;

		VegetableDao vegetableDao = new VegetableDao(context);
		List<VegetableForm> listofData = new ArrayList<>();
		
		String searchName = request.getParameter("veg_name");

		if (searchName != null && !searchName.trim().isEmpty()) {
			listofData  = vegetableDao.selectVegetables(searchName.trim());
	%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
    <title>View Vegetable Items</title>
</head>
<body>
	<h1> View Vegetables </h1>
	<form action="vegView" method="get">
		<label for="veg_name">Vegetable Name:</label> 
		<input type="text" id="veg_name" name="veg_name">
		<input type="submit" value = "Search_Items">
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
					for (VegetableForm eachForm : listofData ) {
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
</body>
</html>
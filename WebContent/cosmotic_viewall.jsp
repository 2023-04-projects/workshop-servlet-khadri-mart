<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.khadri.mart.cosmotic.dao.CosmoticDao"%>
<%@ page import="com.khadri.mart.cosmotic.form.CosmoticForm"%>
<%
	ServletContext context = application;
	CosmoticDao dao = new CosmoticDao(context);
	List<CosmoticForm> listOfCosmotic = dao.selectAllcosmotic();
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>View All Cosmotic</title>
</head>
<body>
	<h2>View All Cosmotic </h2>

	<table border="1">
		<thead>
			<tr>
				<th>Category</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (CosmoticForm eachForm : listOfCosmotic) {
			%>

			<tr>
				<td><%=eachForm.getCategory()%></td>
				<td><%=eachForm.getName()%></td>
				<td><%=eachForm.getQty()%></td>
				<td><%=eachForm.getPrice()%></td>
			</tr>
			<%
				}
				if (listOfCosmotic.isEmpty()) {
			%>
			<tr>
				<td colspan="4">No Cosmotic found.</td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.khadri.mart.cosmotic.dao.CosmoticDao"%>
<%@ page import="com.khadri.mart.cosmotic.form.CosmoticForm"%>
<%
	ServletContext context = application;
	CosmoticDao dao = new CosmoticDao(context);
	List<CosmoticForm> listOfCosmotic = new ArrayList<>();
	String searchName = request.getParameter("pname");
	System.out.println("Search Parameter: " + searchName);
	if (searchName != null && !searchName.trim().isEmpty()) {
		listOfCosmotic = dao.selectCosmotic(searchName.trim());
	}
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>View Cosmotic Items</title>
</head>
<body>
	<h2>View Cosmotic</h2>
	<form action="cos_view" method="get">
		<label for="name"> Name:</label> <input type="text" id="pname"
			name="pname"> <input type="submit" value="Search">
	</form>

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
			%>
		</tbody>
	</table>
</body>
</html>
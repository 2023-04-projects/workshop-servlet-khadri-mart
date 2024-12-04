<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.khadri.mart.cosmotic.dao.CosmoticDao"%>
<%@ page import="com.khadri.mart.cosmotic.form.CosmoticForm"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Modify Cosmotic Items</title>
</head>
<body>
	<h2>Search Cosmotic Item</h2>
	<form action="cos_modify" method="get">
		<table>

			<tr>
				<td>Name: <input type="text" name="pname"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<br>
	<%
		String searchName = request.getParameter("name");
		List<CosmoticForm> listOfCosmotic = new ArrayList<>();
		if (searchName != null && !searchName.isEmpty()) {
			ServletContext context = application;
			CosmoticDao dao = new CosmoticDao(context);
			listOfCosmotic = dao.selectCosmotic(searchName);
		}
	%>
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
				<td><a
					href="grosary_modify_page.jsp?category=<%=eachForm.getCategory()%>name=<%=eachForm.getName()%>&qty=<%=eachForm.getQty()%>&price=<%=eachForm.getPrice()%>"
					target="bottom_right"><%=eachForm.getName()%> </a></td>
				<td><%=eachForm.getCategory()%></td>
				<td><%=eachForm.getQty()%></td>
				<td><%=eachForm.getPrice()%></td>
			</tr>
			<%
				}
				if (listOfCosmotic.isEmpty() && searchName != null) {
			%>
			<tr>
				<td colspan="4">No items found for "<%=searchName%>".
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>


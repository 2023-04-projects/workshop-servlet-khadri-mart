<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.khadri.mart.grosary.dao.GrosaryDao"%>
<%@ page import="com.khadri.mart.grosary.form.GrosaryForm "%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Search and Delete Grocery Items</title>
</head>
<body>
	<h2>Search Grocery Items</h2>
	<form action="grosary_delete" method="post">
		<label for="name">Grosary Name:</label> <input type="text" id="name"
			name="name" required> <input type="submit" value="Search">
	</form>

	<%
		String searchName = request.getParameter("name");

		List<GrosaryForm> listOfGrossaries = new ArrayList<>();

		if (searchName != null) {
			ServletContext context = application;
			GrosaryDao dao = new GrosaryDao(context);
			listOfGrossaries = dao.selectGrosary(searchName);
		}
	%>


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
				if (!listOfGrossaries.isEmpty()) {
					for (GrosaryForm eachForm : listOfGrossaries) {
			%>
			<tr>
				<td><%=eachForm.getGrosaryName()%></td>
				<td><%=eachForm.getGrosaryQty()%></td>
				<td><%=eachForm.getGrosaryPrice()%></td>
				<td>
					<form action="grodelete" method="post">
						<input type="hidden" name="grosaryName"
							value="<%=eachForm.getGrosaryName()%>"><br> <input
							type="submit" value="Delete">
					</form>
				</td>
			</tr>
			<%
				}
				} else {
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

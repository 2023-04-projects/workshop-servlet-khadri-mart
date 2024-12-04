<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.khadri.mart.cosmotic.dao.CosmoticDao"%>
<%@ page import="com.khadri.mart.cosmotic.form.CosmoticForm"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title> Delete Cosmotic Search </title>
</head>
<body>
	<h2> Delete Search Cosmotic</h2>
	<form action="cos_delete" method="post">
		<label for="name"> Name:</label> <input type="text" id="pname"
			name="pname" required> <input type="submit" value="Delete">
	</form>

	<%
		String searchName = request.getParameter("name");
		List<CosmoticForm> listOfCosmotic = new ArrayList<>();
		if (searchName != null) {
			ServletContext context = application;
			CosmoticDao dao = new CosmoticDao(context);
			listOfCosmotic = dao.selectCosmotic(searchName);
		}
	%>


	<table border="1">
		<thead>
			<tr>
			<th>category</th>
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
                    <td>
                        <a href="grosary_delete_page.jsp?category=<%=eachForm.getCategory()  %>&name=<%= eachForm.getName() %>&qty=<%= eachForm.getQty() %>&price=<%= eachForm.getPrice() %>" target="bottom_right">
                            <%= eachForm.getName()%>
                        </a>
                    </td>
                    <td><%= eachForm.getCategory()%></td>
                    <td><%= eachForm.getQty()%></td>
                    <td><%= eachForm.getPrice()%></td>
                </tr>
            <%
                }
            %>

		</tbody>
	</table>
</body>
</html>
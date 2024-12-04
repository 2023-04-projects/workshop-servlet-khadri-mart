<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Cosmotic Page</title>
<link rel='stylesheet' type='text/css' href='styles.css'/>
</head>
<body>
	<h2>Add Cosmotic Item</h2>

	<form action="cos_add" method="post">

		<label for="category">Category : </label><br> 
		<input type="text"id="category" name="category" required><br><br>
		
		<label for="name"> Name : </label><br> 
		<input type="text" id="pname" name="pname" required><br><br>
		 
		<label for="qty">Quantity:</label><br> 
		<input type="number" id="qty" name="qty" required><br><br> 
		
		<label for="price">Price:</label><br>
		<input type="number" id="price" name="price" required><br><br> 
		
		<input type="submit" value="Add Cosmotic">
	</form>
</body>
</html>
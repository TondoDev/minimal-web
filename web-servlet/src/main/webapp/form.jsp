<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page with form</title>
</head>
<body>

	<h2>This page contains form to be submitted</h2>
	
	<form action="myForm" method="post">
		<input type="text" name="name"/> Name
		<input type="text" name="surname"/> Surname <br />
		<input type="submit" value="Sent" />
	</form>
</body>
</html>

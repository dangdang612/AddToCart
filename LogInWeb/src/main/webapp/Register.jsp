<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Register </title>
</head>
<body>
<h2>Register </h2>
	<form action="RegisterServlet">
  		<label for="fname"> Username:</label>  <input type="text" name="username" value="${param.username}" ><br><br>
  		<label for="fname"> Password: </label> <input type="text" name="password" value="${param.password}" ><br><br>
  		<label for="fname"> Email: </label> <input type="text" name="email" value="${param.email}"">
  		<input type="submit" value="Login">
</form> 
</body>
</html>
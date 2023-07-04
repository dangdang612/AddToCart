<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Log In </h2>

<form action="LoginServlet" method ="get">
  <label for="fname"> Username:</label>  <input type="text" name = "username" value="${param.username}"/><br><br>
  <label for="fname"> Password: </label> <input type="password" name ="password" value="${param.password}"/>
  <input type="submit" value="Login">
</form> 
</body>
</html>

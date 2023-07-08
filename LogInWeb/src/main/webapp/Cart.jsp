<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="display: flex; padding:20">
		<div style="width: 30%;"></div>
		<div style="width:70%;">
			<c:if test="${not empty cart }">
			<h4> Books in Cart: </h4>
			<hr>
			<c:forEach var="item" items="${cart}" varStatus="status">
			${status.count}: ${item.value.name }---<a href="#"> Remove</a>
			<br>
			</c:forEach>
			<br>
			<input type="button" value="Submit Cart" />
			</c:if>
			
			<c:if test="${empty cart }">
				<h4> Empty Cart</h4>
			</c:if>
</body>
</html>
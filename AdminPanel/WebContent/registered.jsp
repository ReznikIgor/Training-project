<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div {
	width: 300px;
	background: #F8F8FF;
	border: 2px solid grey;
	padding: 20px;
	margin-top: 15%;
	margin-left: 40%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="DCDCDC">
	<div>
		<c:if test="${not empty dataList}">
			<c:forEach var="it" items="${dataList}">
				<p>Welcome, ${it.getLastName()} ${it.getFirstName()}!</p>
			</c:forEach>
		</c:if>
		<c:if test="${empty dataList}">
	List is empty!!!
</c:if>

	</div>
</body>
</html>
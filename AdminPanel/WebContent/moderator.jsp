<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div {
	width: 1000px;
	background: #F8F8FF;
	border: 2px solid grey;
	padding: 20px;
	margin-top: 15%;
	margin-left: 30%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="DCDCDC">
	<div>
		<table width="100%" border="1" cellpadding="4" cellspacing="0">
			<caption>List of all users</caption>
			<tr>
				<th>Login</th>
				<th>Password</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Country</th>
				<th>Street</th>
				<th>Zip</th>
				<th>Role</th>
				<th>Music Type</th>
			</tr>
			<c:if test="${not empty dataList}">
				<c:forEach var="it" items="${dataList}">
					<tr>
						<td>${it.getLogin()}</td>
						<td>${it.getPassword()}</td>
						<td>${it.getFirstName()}</td>
						<td>${it.getLastName()}</td>
						<td>${it.getAge()}</td>
						<td>${it.getAddress().getCountry()}</td>
						<td>${it.getAddress().getStreet()}</td>
						<td>${it.getAddress().getZipCode()}</td>
						<td>${it.getRole().getRoleName()}</td>
						<td><c:forEach var="type" items="${it.getMusicType()}">${type.getTypeName()}<p></p>
							</c:forEach></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty dataList}">
	List is empty!!!
</c:if>
		</table>
	</div>
</body>
</html>
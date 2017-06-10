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
<title>Error</title>
</head>
<body bgcolor="DCDCDC">
	<div>
		<p align="center">
			<b>The password and confirm are not matched or wrong type age(1
				to 100)</b>
		</p>
		<p align="center">
			<b>You can retype it</b>
		</p>
		<form action="createUser.jsp" method="post">

			<p></p>
			<p align="center">
				<input type="submit" value="Retype password">
			</p>
		</form>
	</div>
</body>
</html>
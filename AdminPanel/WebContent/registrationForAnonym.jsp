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

table.text {
	width: 100%;
	border-spacing: 0;
}

table.text td {
	width: 50%;
	vertical-align: top;
}

td.rightcol {
	text-align: center;
}

td.choosecol {
	text-align: right;
}

td.leftcol {
	text-align: left;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body bgcolor="DCDCDC">
	<div>
		<p align="center">
			<b>Registration</b>
		</p>
		<p align="center">Fill out the form to register</p>
		<form action="registr" method="post">
			<table class="text">
				<tr>
					<td>Username:</td>
					<td class="rightcol"><input type="text" name="username" /><br></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td class="rightcol"><input type="password" name="password" /><br></td>
				</tr>
				<tr>
					<td>Confirm password:</td>
					<td class="rightcol"><input type="password" name="confirm" /><br></td>
				</tr>
				<tr>
					<td>First name:</td>
					<td class="rightcol"><input type="text" name="firstName" /><br></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td class="rightcol"><input type="text" name="lastName" /><br></td>
				</tr>
				<tr>
					<td>Age :</td>
					<td class="rightcol"><input type="text" name="age" /><br></td>
				</tr>
				<tr>
					<td>Country :</td>
					<td class="rightcol"><input type="text" name="country" /><br></td>
				</tr>
				<tr>
					<td>Street :</td>
					<td class="rightcol"><input type="text" name="street" /><br></td>
				</tr>
				<tr>
					<td>Zip code :</td>
					<td class="rightcol"><input type="text" name="zip" /><br></td>
				</tr>
				<tr>
					<td>
						<p></p>
					</td>
				</tr>
				<tr>
					<td class="lefttcol">Choose music types :</td>
				</tr>
				<td></td>
				<td class="leftcol"><select name="MusicType"
					multiple="multiple" size="3">
						<option value="1">Rock</option>
						<option value="2">Rap</option>
						<option value="3">Club</option>
						<option value="4">Classic</option>
						<option value="5">Jazz</option>
						<option value="6">Funk</option>
				</select></td>
				<tr>
					<td></td>
					<td class="rightcol"><input type="submit" value="Registr now"><input
						type="reset" value="Clean"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
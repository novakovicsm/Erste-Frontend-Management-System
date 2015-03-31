<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Erste Netbank - User Information</title>
</head>
<body>
	<div align="center">
		<table border="0">
			<tr>
				<td colspan="2" align="center"><h2>User Information</h2></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<h3>Here's the review of the user details:</h3>
				</td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td>${user.userName}</td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td>${user.userEmail}</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>${user.password}</td>
			</tr>
		</table>
		<a href="http://localhost:8080/frontoffice/app/rest/test/all">List</a>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Erste Netbank - User Registration</title>
</head>
<body>
	<div align="center">
		<form:form action="/frontoffice/app/rest/addUser" method="POST"
			commandName="user">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Erste Netbank -
							Registration</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="userEmail" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit" /></td>
			</table>
		</form:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Erste Netbank - User Login</title>
</head>
<body>
	<div align="center">
		<form:form action="/frontoffice/app/login" method="POST"
			commandName="loginBean">
			<c:if test="${not empty invaliduser }">
				<div class="errorblock">Invalid user or password</div>
			</c:if>
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Erste Netbank - User
							Login</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
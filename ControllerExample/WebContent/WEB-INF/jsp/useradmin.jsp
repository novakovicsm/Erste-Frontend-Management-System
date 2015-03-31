<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<title>Erste Netbank - Administration</title>
</head>
<c:choose>
	<c:when test="${mode eq 'update' }">
		<body>
			<div align="center">
				<form:form action="/frontoffice/app/rest/userAdmin"
					method="POST" commandName="user">
					<form:errors path="*" cssClass="errorblock" element="div" />

					<table border="0">
						<tr>
							<td colspan="2" align="center"><h2>Erste Netbank - User
									Update</h2></td>
						</tr>
						<tr>
							<td><form:label path="id">User ID:</form:label></td>
							<td><form:input path="id" readonly="true" /></td>
						</tr>
						<tr>
							<td><form:label path="active">Active:</form:label></td>
							<td><form:input path="active" readonly="true" /></td>
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
								value="Update" /></td>
						</tr>

					</table>
				</form:form>
			</div>
	</c:when>
	<c:otherwise>
		<body>
			<div align="center">
				<form:form
					action="/frontoffice/app/rest/removeUser"
					method="POST" commandName="user">
					<table border="0">
						<tr>
							<td colspan="2" align="center"><h2>Erste Netbank - User
									Delete</h2></td>
						</tr>
						<tr>
							<td><form:label path="id">User ID:</form:label></td>
							<td><form:input path="id" readonly="true" /></td>
						</tr>
						<tr>
							<td><form:label path="active">Active:</form:label></td>
							<td><form:input path="active" readonly="true" /></td>
						</tr>
						<tr>
							<td>User Name:</td>
							<td><form:input path="userName" readonly="true" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><form:input path="password" readonly="true" /></td>
						</tr>
						<tr>
							<td>E-mail:</td>
							<td><form:input path="userEmail" readonly="true" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="Delete" /></td>
						</tr>

					</table>
				</form:form>
			</div>
	</c:otherwise>
</c:choose>
</body>
</html>
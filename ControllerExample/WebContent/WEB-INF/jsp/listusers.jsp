<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Search result: Active Users</title>
</head>
<body bgcolor="white">
	Here are all users matching your search critera:
	<table>
		<c:forEach items="${users}" var="current">
			<tr>
				<td><c:out value="${current.id}" /></td>
				<td><c:out value="${current.userName}" /></td>
				<td><c:out value="${current.userEmail}" /></td>
				<td><c:out value="${current.password}" /></td>
				<td><a
					href="http://localhost:8080/frontoffice/app/rest/test/${current.id}/update">Edit</a></td>
				<td><a
					href="http://localhost:8080/frontoffice/app/rest/test/${current.id}/delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
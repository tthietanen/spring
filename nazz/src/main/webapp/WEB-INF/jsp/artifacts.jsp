<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/artifacts.css">
<title>Artifacts</title>
</head>
<body>
		<table>
			<caption>Artifacts</caption>
			<thead>
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>STATUS</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${artifacts}" var="af">
					<tr>
						<td><c:out value="${af.id}" /></td>
						<td><c:out value="${af.name}" /></td>
						<td><c:out value="${af.status}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>
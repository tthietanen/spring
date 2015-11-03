<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
<title><spring:message code="af.list.title" /></title>
</head>
<body>

	<div id="langsel">
		<a href="?lang=en">en</a> | <a href="?lang=fi">fi</a>
	</div>
	
	<h1>
		<spring:message code="af.list.heading" />
	</h1>

	<div id="contentbox">
	<table>
		<thead>
			<tr>
				<td><spring:message code="af.list.id" /></td>
				<td class="artifactlist"><spring:message code="af.list.name" /></td>
				<td class="artifactlist"><spring:message code="af.list.status" /></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${artifacts}" var="afList">
				<tr>
					<td ><c:out value="${afList.id}" /></td>
					<td class="artifactlist"><c:out value="${afList.name}" /></td>
					<td class="artifactlist"><c:out value="${afList.status}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>
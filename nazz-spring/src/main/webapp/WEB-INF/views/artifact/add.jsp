<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="af.add.title" /></title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>	
<body>

	<div id="langsel">
		<a href="?lang=en">en</a> | <a href="?lang=fi">fi</a>
	</div>

	<h1>
		<spring:message code="af.add.heading" />
	</h1>
	

	
		<form:form modelAttribute="artifact" method="post">
		  	<fieldset>		
				<legend><spring:message code="af.add.legend" /></legend>
				
				<spring:hasBindErrors name="artifact">
					<p class="Virheotsikko"><spring:message code="af.add.errors" />:</p>
					<div class="Virheblokki"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
				<p>
					<form:label	path="name"><spring:message code="af.add.name" /></form:label><br/>
					<form:input path="name" cssErrorClass="VirheellinenKentta"/> <form:errors path="name" cssClass="Virheteksti"/>		
				</p>
				<p>	
					<form:label path="status"><spring:message code="af.add.status" /></form:label><br/>
					<form:input path="status" cssErrorClass="VirheellinenKentta"/> <form:errors path="status" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<button type="submit"><spring:message code="af.add.add" /></button>
				</p>
			</fieldset>
		</form:form>
</body>
</html>
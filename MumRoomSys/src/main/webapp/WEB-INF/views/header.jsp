<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarToggler" aria-controls="navbarToggler"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href='<c:url value="/"/>'>MUM Room Management System</a>

	<div class="collapse navbar-collapse" id="navbarToggler">
		<c:url var="post_url" value="/logout" />
		<form:form class="form-inline my-2 my-lg-0" 
			modelAttribute="searchCriteria" action="${post_url}" method="post">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
		</form:form>
	</div>
</nav>
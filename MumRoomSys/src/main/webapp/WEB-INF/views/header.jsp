<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-between">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarToggler" aria-controls="navbarToggler"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<a class="navbar-brand" href='<c:url value="/"/>'>MUM Room
		Management System</a>

	<div class="collapse navbar-collapse" id="navbarToggler">
		<ul class="navbar-nav ml-auto">
			<sec:authorize access="isAuthenticated()">
				<c:url var="post_url" value="/logout" />
				<form:form class="form-inline my-2 my-lg-0"
					modelAttribute="searchCriteria" action="${post_url}" method="post">
					<button class="btn btn-outline-success" type="submit">Logout</button>
					<sec:csrfInput />
				</form:form>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<c:url var="post_url" value="/login" />
				<form:form class="form-inline my-2 my-lg-0"
					modelAttribute="searchCriteria" action="${post_url}" method="get">
					<button class="btn btn-outline-success" type="submit">Login</button>
				</form:form>
			</sec:authorize>

		</ul>
	</div>
</nav>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<c:url var="post_url" value="/rest/requestsType" />
		<form  action="/rest/requestsType" method="Get">
			<p>id:-<input type="text" name="id"/></p>
		</form>	
	</thead>
</table>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<c:url var="post_url" value="/bookings/search/status/0" />
		<form:form class="form-inline my-2 my-lg-0" 
			modelAttribute="request" action="${post_url}" method="post">
			<div class="form-row">
			 	<div class="form-group col-md-4">
				 	<form:select path="requestType" class="form-control">
						<form:option value="MAINTENANCE">Maintenance</form:option>				 	
						<form:option value="CHANGING_ROOM">changing Room</form:option>
						<form:option value="LEAVING_ROOM">Leaving Room</form:option>
					</form:select>
			 	</div>
			 	<div class="form-group col-md-2">
					<form:button class="btn btn-outline-success" type="submit">List of Request</form:button>			 	
			 	</div>
			</div>
		</form:form>	
	</thead>
</table>
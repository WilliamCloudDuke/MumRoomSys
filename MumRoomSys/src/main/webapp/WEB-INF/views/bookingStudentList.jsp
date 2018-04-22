<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h5>Select a Student:</h5>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<c:url var="post_url" value="/bookings/students/0" />
		<form:form class="form-inline my-2 my-lg-0" 
			modelAttribute="searchCriteria" action="${post_url}" method="post">
			<div class="form-row">
			 	<div class="form-group col-md-6">
				 	<form:input path="criteria" class="form-control"
					type="search" placeholder="Search" aria-label="Search" />
			 	</div>
			 	<div class="form-group col-md-4">
				 	<form:select path="searchBy" class="form-control">
						<form:option value="name">By Student Name</form:option>
						<form:option value="email">By Student Email</form:option>
					</form:select>
			 	</div>
			 	<div class="form-group col-md-2">
					<button class="btn btn-outline-success" type="submit">Search</button>			 	
			 	</div>
			</div>
		</form:form>	
	</thead>
</table>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Name</th>
			<th scope="col">Email</th>
			<th scope="col">Phone</th>
			<th scope="col">Role</th>
			<th scope="col">Select</th>			
		</tr>	
	</thead>
	<tbody>		
		<c:if test="${!students.hasContent()}">
			<tr><td colspan="4">No records found<td></tr>
		</c:if>			
		<c:if test="${students.hasContent()}">
			<c:forEach var="student" items="${students.getContent()}">
				<tr>
					<td>${student.name}</td>
					<td>${student.email}</td>	
					<td>${student.phone}</td>
					<td>${student.account.role.name}</td>
					<td><a href='<c:url value="/bookings/students/select/${student.id}"/>'>Select</a></td>				
				</tr>								
			</c:forEach>		
		</c:if>
	</tbody>
</table>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr>
			<c:if test="${students.hasContent()}">
				<td>Pages: 	
					<c:forEach var="no" begin="0" end="${page.getTotalPage() - 1}">
						<a href="/bookings/students/${no}?criteria=${searchCriteria.criteria}&searchBy=${searchCriteria.searchBy}">${no + 1} </a>
					</c:forEach>
				</td>			
			</c:if>
		</tr>
	</thead>
</table>
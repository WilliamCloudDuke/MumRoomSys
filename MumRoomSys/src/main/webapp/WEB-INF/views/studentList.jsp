<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Name</th>
			<th scope="col">Email</th>
			<th scope="col">Phone</th>
			<th scope="col">Role</th>
			<th scope="col">Edit</th>			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="student" items="${students.getContent()}">
			<tr>
				<td>${student.name}</td>
				<td>${student.email}</td>	
				<td>${student.phone}</td>
				<td>${student.account.role.name}</td>
				<td><a href='<c:url value="/student/${student.id} }"/>'>Edit</a></td>				
			</tr>								
		</c:forEach>
	</tbody>
</table>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr>
			<td>Pages: 	<c:forEach var="no" begin="0" end="${page.getTotalPage() - 1}">
				<a href="/students/${no}">${no + 1} </a>
			</c:forEach>
			</td>
		
		</tr>
	</thead>
</table>
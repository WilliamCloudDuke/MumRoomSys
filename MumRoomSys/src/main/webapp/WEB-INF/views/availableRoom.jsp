<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h5>Available Rooms</h5>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>		
			<th scope="col">Building No</th>
			<th scope="col">Room No</th>
			<th scope="col">Status</th>
		</tr>	
	</thead>
	<tbody>		
		<c:if test="${rooms.isEmpty()}">
			<tr><td colspan="3">No records found<td></tr>
		</c:if>			
		<c:forEach var="room" items="${rooms}" varStatus="loop">
			<tr>
				<td>${loop.index + 1}</td>					
				<td>${room.buildNumber}</td>
				<td>${room.number}</td>	
				<td>${room.status}</td>
			</tr>								
		</c:forEach>		
	</tbody>
</table>
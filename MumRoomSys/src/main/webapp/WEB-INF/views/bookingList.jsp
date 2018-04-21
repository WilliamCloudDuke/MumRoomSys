<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<c:url var="post_url" value="/bookings/search/status/0" />
		<form:form class="form-inline my-2 my-lg-0" 
			modelAttribute="searchCriteria" action="${post_url}" method="post">
			<div class="form-row">
			 	<div class="form-group col-md-4">
				 	<form:select path="bookingStatus" class="form-control">
						<form:option value="NEW">New</form:option>				 	
						<form:option value="CHECKED_IN">Checked in</form:option>
						<form:option value="CHECKED_OUT">Checked out</form:option>
					</form:select>
			 	</div>
			 	<div class="form-group col-md-2">
					<button class="btn btn-outline-success" type="submit">Filter By Status</button>			 	
			 	</div>
			</div>
		</form:form>	
	</thead>
</table>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<c:url var="post_url" value="/bookings/search/0" />
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
					<button class="btn btn-outline-success" type="submit">Filter By Student</button>			 	
			 	</div>
			</div>
		</form:form>	
	</thead>
</table>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr>
			<th scope="col" class="col">Student</th>
			<th scope="col" class="col">Email</th>
			<th scope="col" class="col">Phone</th>
			<th scope="col" class="col">Building</th>	
			<th scope="col" class="col">Room</th>								
			<th scope="col" class="col-4">Moved in Date</th>
			<th scope="col" class="col-4">Moved out Date</th>	
			<th scope="col" class="col">Status</th>		
			<th scope="col" class="col-4">Check in Details</th>	
			<th scope="col" class="col-4">Check out Details</th>									
		</tr>	
	</thead>
	<tbody>		
		<c:if test="${!bookings.hasContent()}">
			<tr><td colspan="9">No records found<td></tr>
		</c:if>			
		<c:if test="${bookings.hasContent()}">
			<c:forEach var="booking" items="${bookings.getContent()}">
				<tr>
					<td>${booking.student.name}</td>
					<td>${booking.student.email}</td>	
					<td>${booking.student.phone}</td>
					<td>${booking.room.buildNumber}</td>			
					<td>${booking.room.number}</td>									
					<td>${booking.moveInDate}</td>
					<td>${booking.moveOutDate}</td>		
					<td>${booking.status}</td>								
					<td>
						<c:set var="checkinRecord" value="${booking.getCheckinRecord()}"/>
						<c:if test="${checkinRecord  != null}">
							<a href='<c:url value="/booking/checkin/${checkinRecord.id} }"/>'>Details</a>
						</c:if>						
					</td>
					<td>
						<c:set var="checkoutRecord" value="${booking.getCheckoutRecord()}"/>
						<c:if test="${checkoutRecord  != null}">
							<a href='<c:url value="/booking/checkin/${checkoutRecord.id} }"/>'>Details</a>
						</c:if>						
					</td>										
				</tr>								
			</c:forEach>		
		</c:if>
	</tbody>
</table>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr>
			<c:if test="${bookings.hasContent()}">
				<td>Pages: 	
					<c:forEach var="no" begin="0" end="${page.getTotalPage() - 1}">
						<a href="/bookings/${no}">${no + 1} </a>
					</c:forEach>
				</td>			
			</c:if>
		</tr>
	</thead>
</table>
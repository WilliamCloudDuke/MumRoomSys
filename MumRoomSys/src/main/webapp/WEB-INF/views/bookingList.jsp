<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h5>Search Bookings</h5>
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
		<c:url var="post_url" value="/bookings/search/building/0" />
		<form:form class="form-inline my-2 my-lg-0" 
			modelAttribute="roomSearchCriteria" action="${post_url}" method="post">
			<div class="form-row">
			 	<div class="form-group col-md-3">
				 	<form:input path="buildingNo" class="form-control"
					type="search" placeholder="Search" aria-label="Search" />
					<form:errors path="buildingNo"/>
			 	</div>
			 	<div class="form-group col-md-3">
				 	<form:input path="roomNo" class="form-control"
					type="search" placeholder="Search" aria-label="Search" />
					<form:errors path="roomNo"/>
			 	</div>			 	
			 	<div class="form-group col-md-2">
					<button class="btn btn-outline-success" type="submit">Filter By Building and Room</button>			 	
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
			<th scope="col" class="col-4">Remove</th>										
		</tr>	
	</thead>
	<tbody>		
		<c:if test="${!bookings.hasContent()}">
			<tr><td colspan="10">No records found<td></tr>
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
						<c:if test="${checkinRecord != null}">
							<a href='<c:url value="/student/checkin/${checkinRecord.id}"/>'>Details</a>
						</c:if>						
					</td>
					<td>
						<c:set var="checkoutRecord" value="${booking.getCheckoutRecord()}"/>
						<c:if test="${checkoutRecord != null}">
							<a href='<c:url value="/student/checkout/${checkoutRecord.id}"/>'>Details</a>
						</c:if>						
					</td>	
					<td>
						<c:set var="canDelete" value="${booking.status == 'NEW'}"/>
						<c:if test="${canDelete}">
							<a href='<c:url value="/booking/delete/${booking.id}"/>'>Delete</a>
						</c:if>						
					</td>																		
				</tr>								
			</c:forEach>		
		</c:if>
		<c:if test="${bookings.hasContent()}">
			<tr>
				<td colspan="11">Pages: 	
					<c:forEach var="no" begin="0" end="${page.getTotalPage() - 1}">
						<c:if test="${searchType == 'student'}">
							<a href="/bookings/search/${no}?searchBy=${searchCriteria.searchBy}&criteria=${searchCriteria.criteria}">${no + 1} </a>
						</c:if>
						<c:if test="${searchType == 'building'}">
							<a href="/bookings/search/building/${no}?buildingNo=${roomSearchCriteria.buildingNo}&roomNo=${roomSearchCriteria.roomNo}">${no + 1} </a>
						</c:if>		
						<c:if test="${searchType == 'status'}">
							<a href="/bookings/search/status/${no}?bookingStatus=${searchCriteria.bookingStatus}">${no + 1} </a>
						</c:if>										
					</c:forEach>
				</td>		
			<tr>		
		</c:if>
	
	</tbody>
</table>
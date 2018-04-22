<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h5>Select a Room:</h5>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<c:url var="post_url" value="/bookings/rooms/status/0" />
		<form:form class="form-inline my-2 my-lg-0" 
			modelAttribute="roomSearchCriteria" action="${post_url}" method="post">
			<div class="form-row">
			 	<div class="form-group col-md-4">
				 	<form:select path="roomStatus" class="form-control">
						<form:option value="OCCUPIED">OCCUPIED</form:option>				 	
						<form:option value="MAINTENANCE">MAINTENANCE</form:option>
						<form:option value="NEEDS_CLEANING">NEEDS_CLEANING</form:option>
						<form:option value="READY">READY</form:option>
						<form:option value="RESERVED"></form:option>															
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
		<c:url var="post_url" value="/bookings/rooms/number/0" />
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
		<tr>
			<th scope="col" class="col">Building</th>	
			<th scope="col" class="col">Room</th>								
			<th scope="col" class="col">Status</th>		
			<th scope="col" class="col">Select</th>									
		</tr>	
	</thead>
	<tbody>		
		<c:if test="${!rooms.hasContent()}">
			<tr><td colspan="3">No records found<td></tr>
		</c:if>			
		<c:if test="${rooms.hasContent()}">
			<c:forEach var="room" items="${rooms.getContent()}">
				<tr>
					<td>${room.buildNumber}</td>			
					<td>${room.number}</td>									
					<td>${room.status}</td>								
					<td>
						<a href='<c:url value="/bookings/rooms/select/${room.id}"/>'>Select</a>
					</td>									
				</tr>								
			</c:forEach>		
		</c:if>
		<c:if test="${rooms.hasContent()}">
			<tr>
				<td colspan="3">Pages: <c:forEach var="no" begin="0"
						end="${page.getTotalPage() - 1}">
						<c:if test="${searchType == 'building'}">
							<a
								href="/bookings/rooms/number/${no}?buildingNo=${roomSearchCriteria.buildingNo}&roomNo=${roomSearchCriteria.roomNo}">${no + 1}
							</a>
						</c:if>
						<c:if test="${searchType == 'status'}">
							<a
								href="/bookings/rooms/status/${no}?roomStatus=${roomSearchCriteria.roomStatus}">${no + 1}
							</a>
						</c:if>
					</c:forEach>
				</td>
			</tr>
		</c:if>
	</tbody>
</table>
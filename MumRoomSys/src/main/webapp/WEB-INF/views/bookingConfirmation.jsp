<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h5>Booking Step 3: Confirmation</h5>
<hr/>
<c:url var="post_url" value="/bookings/confirm" />
<form:form modelAttribute="booking" action="${post_url}" method="post">
	<fieldset>
		<div class="form-group">
			<label for="moveInDate">Move in Date</label> 
			<form:input type="date" path="moveInDate" id="moveInDate" class="form-control" placeholder="Move In Date"/>
			<form:errors path="moveInDate" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label for="moveOutDate">Move out Date</label> 
			<form:input type="date" path="moveOutDate" id="moveOutDate" class="form-control" placeholder="Move Out Date"/>
			<form:errors path="moveOutDate" cssClass="error"/>			
		</div>					
		<div class="form-group">
			<label for="studentName">Student Name</label> 
			<form:input disabled="true" type="text" path="student.name" id="studentName" class="form-control"/>
		</div>	
		<div class="form-group">
			<label for="studentEmail">Student email</label> 
			<form:input disabled="true" type="text" path="student.email" id="studentEmail" class="form-control"/>
		</div>		
		<div class="form-group">
			<label for="buildingNo">Building</label> 
			<form:input disabled="true" type="text" path="room.buildNumber" id="buildingNo" class="form-control"/>
		</div>				
		<div class="form-group">
			<label for="roomNo">Building</label> 
			<form:input disabled="true" type="text" path="room.number" id="roomNo" class="form-control"/>
		</div>						
	</fieldset>
	<fieldset>
		<form:button type="submit" class="btn btn-primary" value="submit">    Submit   </form:button>
	</fieldset>
</form:form>
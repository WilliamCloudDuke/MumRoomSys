<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="hasAnyAuthority('DIRECTOR')">
	<div class="row d-flex d-md-block flex-nowrap wrapper">
	    <div class="col-md-2 float-left col-1 pl-0 pr-0 collapse width show" id="sidebar">
	    	<div class="list-group border-0 card text-center text-md-left">
		<a href="#student" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><i class="fa fa-book"></i> <span class="d-none d-md-inline">Student </span></a>
	            <div class="collapse" id="student" data-parent="#sidebar">
	                <a href="/students/0" class="list-group-item" data-parent="#student">List Students</a>
	                <a href="/student/detail" class="list-group-item" data-parent="#student">Create Student</a>
	            </div>	                
	            
		<a href="#bookRoom" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><i class="fa fa-book"></i> <span class="d-none d-md-inline">Assign Room </span></a>
		<div class="collapse" id="bookRoom" data-parent="#sidebar">
	                <a href="/bookings/search/status/0?bookingStatus=NEW" class="list-group-item" data-parent="#bookRoom">List Bookings</a>
	                <a href="/bookings/students/0" class="list-group-item" data-parent="#bookRoom">Room Management</a>
	            </div>	  
	            <a href="#checkout" class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-heart"></i> <span class="d-none d-md-inline">Check Out</span></a>
	            
	            <a href='<c:url value="/requests/0"/>' class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-heart"></i> <span class="d-none d-md-inline">Facility Request</span></a>
	           
				<a href="#report" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><i class="fa fa-book"></i> <span class="d-none d-md-inline">Report </span></a>       
	           <div class="collapse" id="report" data-parent="#sidebar">
	               <a href="#" class="list-group-item" data-parent="#report">Available Room</a>
	               <a href="#" class="list-group-item" data-parent="#report">Booking History</a>
	           </div>	 	                
	       </div>
	   </div>
	</div>
</sec:authorize>
	
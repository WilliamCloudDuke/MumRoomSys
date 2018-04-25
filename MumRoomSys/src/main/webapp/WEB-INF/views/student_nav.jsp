<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="hasAnyAuthority('STUDENT')">
	<div class="row d-flex d-md-block flex-nowrap wrapper">
		<div class="col-md-2 float-left col-1 pl-0 pr-0 collapse width show" id="sidebar">
			<div class="list-group border-0 card text-center text-md-left">
				<a href="/student/checkin"
					class="list-group-item d-inline-block collapsed"
					data-parent="#sidebar"><i class="fa fa-heart"></i> <span
					class="d-none d-md-inline">Check In</span></a> 
				<a href="/requests/0"
					class="list-group-item d-inline-block collapsed"
					data-parent="#sidebar"><i class="fa fa-heart"></i> <span
					class="d-none d-md-inline">Facility Request</span></a>
			</div>
		</div>
	</div>
</sec:authorize>

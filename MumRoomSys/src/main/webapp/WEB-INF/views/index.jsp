<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/style.css"/>' />
<title>MUM Room Management System</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col" id="header">
				<c:import url="header.jsp" />
			</div>
		</div>	
	    <div class="row d-flex d-md-block flex-nowrap wrapper">
	        <div class="col-md-2 float-left col-1 pl-0 pr-0 collapse width show" id="sidebar">
	        	<div class="list-group border-0 card text-center text-md-left">
	 				<a href="#student" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><i class="fa fa-book"></i> <span class="d-none d-md-inline">Student </span></a>
	                <div class="collapse" id="student" data-parent="#sidebar">
	                    <a href="/students/0" class="list-group-item" data-parent="#student">List</a>
	                    <a href="#" class="list-group-item" data-parent="#student">Create</a>
	                </div>	                
	                
	                <a href="#bookRoom" class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-heart"></i> <span class="d-none d-md-inline">Book Room</span></a>

	                <a href="#checkout" class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-heart"></i> <span class="d-none d-md-inline">Check Out</span></a>
	                
	                <a href="#request" class="list-group-item d-inline-block collapsed" data-parent="#sidebar"><i class="fa fa-heart"></i> <span class="d-none d-md-inline">Facility Request</span></a>
	                
	 				<a href="#report" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><i class="fa fa-book"></i> <span class="d-none d-md-inline">Report </span></a>       
	                <div class="collapse" id="report" data-parent="#sidebar">
	                    <a href="#" class="list-group-item" data-parent="#report">Available Room</a>
	                    <a href="#" class="list-group-item" data-parent="#report">Booking History</a>
	                </div>	 	                
	            </div>
	        </div>
	        <main class="col-md-10 float-left col px-5 pl-md-2 pt-2 main">
	            <div class="row">
	                <div class="col-lg-6">
	                   <c:import url="${mainPage}" />
	                </div>
	            </div>
	        </main>
	    </div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
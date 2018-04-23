<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<style type="text/css">
	.errorblock {
		color: #ff0000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
	body {
		background-image: url("/images/backGround.jpg");
		background-repeat: repeat;
	}
</style>
<title>MUM Room Management System - Login</title>
</head>
<body onload='document.f.username.focus();'>
	<div class="container h-100">
		<div class="row align-items-center h-100">
			<div class="col col-md-4 offset-md-4">	
				<c:if test="${not empty error}">
					<div class="errorblock">
						Your login was unsuccessful. <br />
						Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
					</div>
				</c:if>
				<form action="j_spring_security_check" method="post" id="f">
					<fieldset>
						<div class="form-group">
							<h4><label for="username" class="text-white">Login</label></h4>
							<input type="text" id="username" name="username" value="" class="form-control" />
						</div>		
						<div class="form-group">
							<h4><label for="password" class="text-white">Password</label></h4>
							<input type="password" id="password"  name="password" value="" class="form-control"/>		
						</div>				
						<sec:csrfInput />								
						<button type="submit" class="btn btn-primary" value="submit">Submit</button>			
					</fieldset>
				</form>			
			</div>
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
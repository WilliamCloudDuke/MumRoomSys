<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
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
<title>Mum Request Service</title>
</head>
<body>
<div class="container-fluid">

		 <div class="row">
			<div class="col" id="header">
				<req:import url="header.jsp" />
			</div>
		</div>	 	
		<table class="tablerequest">
		<tr><th>studentname</th><th>Request type</th><th>Request Description</th></tr>
	 <c:forEach var="request" items="${requests.getContent()}">
			<tr >
				<td >${request.student.name}</td>
				<td>${request.type}</td>	
				<td>${request.description}</td>	
				<td><button>edit</button></td>
				<td><button>delete</button>	</td>
			</tr>								
	</c:forEach> 	
</table>	
<br>
</br>
</br>

<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<c:url var="post_url" value="/request/selectRequest/0" />
		<form:form class="form-inline my-2 my-lg-0" 
			modelAttribute="request" action="${post_url}" method="post">
			<div class="form-row">
			 	<div class="form-group col-md-4">
				 	<form:select path="description" class="form-control">
						<form:option value="BY REQUEST TYPE">Request Type</form:option>				 	
						<form:option value="BY BUILDING">By building</form:option>
						<form:option value="BY STUDENT">By student Id</form:option>
					</form:select>
			 	
			 	
					<form:button  type="submit">list out </form:button>			 	
			 	</div>
			</div>
		</form:form>	
	</thead>
</table>



		
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
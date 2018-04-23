<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<h1 class="well">Check in Form</h1>
		<c:url var="post_url" value="/student/checkin/0" />
		<form:form class="form-inline my-2 my-lg-0"
			modelAttribute="bookingNew" action="${post_url}" method="post">


			<div class="form-row">
				<div class="form-group col-md-6">
					<strong>Student Name</strong>
					<form:input path="student.name" class="form-control" type="text"
						placeholder="Student name" readonly="true" />
				</div>
				<div class="form-group col-md-4">
					<strong>Building number</strong>
					<form:input path="room.buildNumber" class="form-control"
						type="text" placeholder="Building number" readonly="true" />
				</div>
			</div>


			<div class="form-row">
				<div class="form-group col-md-6">
					<strong>Room Number</strong>
					<form:input path="room.number" class="form-control" type="text"
						placeholder="Room number" readonly="true" />
				</div>
				<div class="form-group col-md-4">
					<strong>Phone number</strong>
					<form:input path="student.phone" class="form-control" type="text"
						placeholder="Phone number" readonly="true" />
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<strong>Email Address</strong>
					<form:input path="student.email" class="form-control" type="text"
						placeholder="Email Address" readonly="true" />
				</div>
			</div>
		</form:form>
	</thead>
</table>


<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<h3 class="items">FURNITURE ITEMS</h3>
		<!-- ROOM ITEMS -->
		<form:form modelAttribute="bookingItemNew" action="${post_url}"
			method="post" class="form-inline my-2 my-lg-0">
			<div class="form-row">
				<div class="form-group col-md-4">
					<strong>Walls</strong>
					<div class="form-check">
						<form:select path="walls" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Windows</strong>abel>
					<div class="form-check">
						<form:select path="windows" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Screens</strong>
					<div class="form-check">
						<form:select path="screens" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Blinds</strong>
					<div class="form-check">
					
						<form:select path="blinds" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Sink</strong>
					<div class="form-check">
					
						<form:select path="sink" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Counter</strong>
					<div class="form-check">
					
						<form:select path="counter" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Mirror</strong>
					<div class="form-check">
					
						<form:select path="mirror" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Floor</strong>
					<div class="form-check">
					
						<form:select path="floor" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Closet</strong>
					<div class="form-check">
					
						<form:select path="closet" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>
				
				
				<div class="form-group col-md-4">
					<strong>Towel</strong>
					<div class="form-check">
						<form:select path="towel" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Shower</strong>
					<div class="form-check">
						<form:select path="shower" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Thermostat</strong>
					<div class="form-check">
						<form:select path="thermostat" class="form-control">
							<form:option value="GOOD">GOOD</form:option>
							<form:option value="FIX_IT">FIX IT</form:option>
							<form:option value="MISSING">MISSING</form:option>
							<form:option value="REPLACE">REPLACE</form:option>
						</form:select>
					</div>
				</div>

			</div>

			<div class="row items">
				<div>
					<strong>Move In Date: </strong> <input id="date" type="date">
					<br> <input type="checkbox" name="checkbox" value="check"
						id="agree" /> I have read and agree to the Terms and Conditions
					of the residence life. <br>
					<button type="button" class="btn btn-lg btn-info">Submit</button>
				</div>
			</div>
		</form:form>
	</thead>
</table>


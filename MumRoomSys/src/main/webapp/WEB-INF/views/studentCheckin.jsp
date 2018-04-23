<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<h1 class="well">Check in Form</h1>

		<c:if test="${not empty bookingItem.successMessage}">
			<form:form class="form-inline my-2 my-lg-0">
				<div class="alert alert-success" role="alert">
					<strong style="font-size: 15">${bookingItem.successMessage}</strong>
				</div>
			</form:form>
		</c:if>

		<c:if test="${not empty bookingItem.errorMessage}">
			<form:form class="form-inline my-2 my-lg-0">
				<div class="alert alert-danger" role="alert">
					<strong style="font-size: 15">${bookingItem.errorMessage}</strong>
				</div>
			</form:form>
		</c:if>

		<form:form class="form-inline my-2 my-lg-0" modelAttribute="booking"
			action="${post_url}" method="post">

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
						placeholder="123-456-7890" readonly="true" />
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
		<form:form modelAttribute="bookingItem" action="/student/checkin/add"
			method="post" class="form-inline my-2 my-lg-0">
			<div class="form-row">
				<div class="form-group col-md-4">
					<strong>Walls</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="walls" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="walls" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Windows</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="windows" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="windows" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Screens</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="screens" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="screens" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Blinds</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="blinds" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="blinds" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Sink</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="sink" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="sink" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Counter</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="counter" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="counter" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Mirror</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="mirror" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="mirror" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Floor</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="floor" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="floor" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Closet</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="closet" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="closet" class="form-control" disabled="false">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>


				<div class="form-group col-md-4">
					<strong>Towel</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="towel" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="towel" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Shower</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="shower" class="form-control" disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="shower" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>

				<div class="form-group col-md-4">
					<strong>Thermostat</strong>
					<div class="form-check">
						<c:if test="${bookingItem.disabled == true}">
							<form:select path="thermostat" class="form-control"
								disabled="true">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
						<c:if test="${bookingItem.disabled == false}">
							<form:select path="thermostat" class="form-control">
								<form:option value="GOOD">GOOD</form:option>
								<form:option value="FIX_IT">FIX IT</form:option>
								<form:option value="MISSING">MISSING</form:option>
								<form:option value="REPLACE">REPLACE</form:option>
							</form:select>
						</c:if>
					</div>
				</div>

			</div>

			<div class="form-group">
				<strong><label class="col-xs-3 control-label">Terms
						of use</label></strong>
				<div class="col-xs-9">
					<div
						style="border: 1px solid #e5e5e5; height: 200px; overflow: auto; padding: 10px;">
						<p>Lorem ipsum dolor sit amet, veniam numquam has te. No suas
							nonumes recusabo mea, est ut graeci definitiones. His ne melius
							vituperata scriptorem, cum paulo copiosae conclusionemque at.
							Facer inermis ius in, ad brute nominati referrentur vis. Dicat
							erant sit ex. Phaedrum imperdiet scribentur vix no, ad latine
							similique forensibus vel.</p>
						<p>Dolore populo vivendum vis eu, mei quaestio liberavisse ex.
							Electram necessitatibus ut vel, quo at probatus oportere,
							molestie conclusionemque pri cu. Brute augue tincidunt vim id, ne
							munere fierent rationibus mei. Ut pro volutpat praesent
							qualisque, an iisque scripta intellegebat eam.</p>
						<p>Mea ea nonumy labores lobortis, duo quaestio antiopam
							inimicus et. Ea natum solet iisque quo, prodesset mnesarchum ne
							vim. Sonet detraxit temporibus no has. Omnium blandit in vim, mea
							at omnium oblique.</p>
						<p>Eum ea quidam oportere imperdiet, facer oportere
							vituperatoribus eu vix, mea ei iisque legendos hendrerit. Blandit
							comprehensam eu his, ad eros veniam ridens eum. Id odio lobortis
							elaboraret pro. Vix te fabulas partiendo.</p>
						<p>Natum oportere et qui, vis graeco tincidunt instructior an,
							autem elitr noster per et. Mea eu mundi qualisque. Quo nemore
							nusquam vituperata et, mea ut abhorreant deseruisse, cu nostrud
							postulant dissentias qui. Postea tincidunt vel eu.</p>
						<p>Ad eos alia inermis nominavi, eum nibh docendi definitionem
							no. Ius eu stet mucius nonumes, no mea facilis philosophia
							necessitatibus. Te eam vidit iisque legendos, vero meliore
							deserunt ius ea. An qui inimicus inciderint.</p>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-xs-6 col-xs-offset-3">
					<div class="checkbox">
						<label> <input type="checkbox" name="agree" value="agree" />
							Agree with the terms and conditions
						</label>
					</div>
				</div>
			</div>

			<div class="row items">
				<div>
					<strong>Move In Date: </strong>
					<form:input path="checkInDate" class="form-control" type="date" />
					<br> <br>
					<c:if test="${bookingItem.disabled == false}">
						<button type="submit" class="btn btn-lg btn-info">Submit</button>
					</c:if>
				</div>
			</div>
		</form:form>
	</thead>
</table>


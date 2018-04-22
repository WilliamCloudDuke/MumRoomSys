<div class="container">
	<h1 class="well">Check in Form</h1>
	<div class="col-lg-12 well">
		<div class="row">
			<form>
				<div class="col-sm-12">
					<div class="row">
						<div class="col-sm-6 form-group">
							<label>User name</label> <input type="text"
								placeholder="Enter First Name Here.." class="form-control"
								value="${bookingNew.student.name}" readonly="readonly">
						</div>
					</div>

					<div class="row">
						<div class="col-sm-4 form-group">
							<label>Building</label> <input type="text"
								value="${bookingNew.room.buildNumber}" placeholder="Building.." class="form-control" readonly="readonly">
						</div>
						<div class="col-sm-4 form-group">
							<label>Room Number</label> <input type="text"
								value="${bookingNew.room.number}" placeholder="Room Number.." class="form-control" readonly="readonly">
						</div>

					</div>
					<div class="form-group">
						<label>Phone Number</label> <input type="text"
							value="${bookingNew.student.phone}" placeholder="Phone Number.." class="form-control" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Email Address</label> <input type="text"
							value="${bookingNew.student.email}"  placeholder="Email.." class="form-control" readonly="readonly">
					</div>
					<div class="row items">
						<h3 class="items">FURNITURE ITEMS</h3>
						<div class="col-sm-4 form-group">
							<label>Blinds</label>
							<div class="form-check">
								<div>
									<input class="form-check-input" type="radio"
										name="exampleRadios" id="exampleRadios1" value="good"
										checked> <label class="form-check-label"
										for="exampleRadios"> Good </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="exampleRadios" id="exampleRadios2" value="fixit">
									<label class="form-check-label" for="exampleRadios2">
										Fix it </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio"
										name="exampleRadios" id="exampleRadios3" value="missing">
									<label class="form-check-label" for="exampleRadios3">
										Missing </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio"
										name="exampleRadios" id="exampleRadios4" value="replace">
									<label class="form-check-label" for="exampleRadios4">
										Replace </label>
								</div>
							</div>

						</div>
						<div class="col-sm-4 form-group">
							<label>Closet</label>
							<div class="form-check">
								<div>
									<input class="form-check-input" type="radio"
										name="exampleRadios" id="exampleRadios1" value="good"
										checked> <label class="form-check-label"
										for="exampleRadios"> Good </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="exampleRadios" id="exampleRadios2" value="fixit">
									<label class="form-check-label" for="exampleRadios2">
										Fix it </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio"
										name="exampleRadios" id="exampleRadios3" value="missing">
									<label class="form-check-label" for="exampleRadios3">
										Missing </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio"
										name="exampleRadios" id="exampleRadios4" value="replace">
									<label class="form-check-label" for="exampleRadios4">
										Replace </label>
								</div>
							</div>

						</div>
						<div class="col-sm-4 form-group">
							<label>Book Shelf</label>
							<div class="form-check">
								<div>
									<input class="form-check-input" type="radio"
										name="exampleRadios2" id="exampleRadios1" value="option1"
										checked> <label class="form-check-label"
										for="exampleRadios"> Good </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="exampleRadios2" id="exampleRadios2" value="option2">
									<label class="form-check-label" for="exampleRadios">
										Bad </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio"
										name="exampleRadios2" id="exampleRadios3" value="option3">
									<label class="form-check-label" for="exampleRadios">
										Absent </label>
								</div>
							</div>

						</div>

					</div>
					<div class="row items">
						<h3 class="items">ROOM</h3>
						<div class="col-sm-4 form-group">
							<label>Windows</label>
							<div class="form-check">
								<div>
									<input class="form-check-input" type="radio"
										name="exampleRadios3" id="exampleRadios1" value="option1"
										checked> <label class="form-check-label"
										for="exampleRadios1"> Good </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="exampleRadios3" id="exampleRadios2" value="option2">
									<label class="form-check-label" for="exampleRadios2">
										Bad </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio"
										name="exampleRadios3" id="exampleRadios3" value="option3">
									<label class="form-check-label" for="exampleRadios3">
										Absent </label>
								</div>
							</div>

						</div>
						<div class="col-sm-4 form-group">
							<label>Blinds</label>
							<div class="form-check">
								<div>
									<input class="form-check-input" type="radio"
										name="exampleRadios4" id="exampleRadios1" value="option1"
										checked> <label class="form-check-label"
										for="exampleRadios"> Good </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="exampleRadios4" id="exampleRadios2" value="option2">
									<label class="form-check-label" for="exampleRadios">
										Bad </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio"
										name="exampleRadios4" id="exampleRadios3" value="option3">
									<label class="form-check-label" for="exampleRadios">
										Absent </label>
								</div>
							</div>

						</div>
						<div class="col-sm-4 form-group">
							<label>Floors</label>
							<div class="form-check">
								<div>
									<input class="form-check-input" type="radio"
										name="exampleRadios2" id="exampleRadios1" value="option1"
										checked> <label class="form-check-label"
										for="exampleRadios"> Carpet </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="exampleRadios2" id="exampleRadios2" value="option2">
									<label class="form-check-label" for="exampleRadios">
										Tile </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio"
										name="exampleRadios2" id="exampleRadios3" value="option3">
									<label class="form-check-label" for="exampleRadios">
										None </label>
								</div>
							</div>

						</div>

					</div>

					<strong>Move In Date: </strong> <input id="date" type="date">
					<br> <input type="checkbox" name="checkbox" value="check"
						id="agree" /> I have read and agree to the Terms and Conditions
					of the residence life. <br>
					<button type="button" class="btn btn-lg btn-info">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>

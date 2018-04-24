<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h5>Edit Student</h5>
<hr/>
<form:form modelAttribute="student" action="/student/edit/${student.id}" method="post">
	<fieldset>
		<div class="form-group">
			<label for="name">Name</label> 
			<form:input path="name" id="name" class="form-control" placeholder="Name"/>
			<form:errors path="name" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label for="email">Email</label> 
			<form:input type="email" path="email" id="email" class="form-control" placeholder="Email"/>
			<form:errors path="email" cssClass="error"/>			
		</div>					
		<div class="form-group">
			<label for="phone">Phone</label> 
			<form:input type="text" path="phone" id="phone" class="form-control" placeholder="123-456-7890"/>
			<form:errors path="phone" cssClass="error"/>			
		</div>	
	</fieldset>
	<fieldset>
		<form:button type="submit" class="btn btn-primary" value="submit">Edit</form:button>
	</fieldset>
</form:form>
<c:if  test="${student.account != null}">
	<h5>Reset Password</h5>
	<hr/>
	<form:form modelAttribute="student" action="/student/resetpass/${student.id}" method="post">
		<fieldset>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="username">Login</label> 
					<form:input disabled="true" type="text" path="username" id="username" class="form-control" />
				</div>		
				<div class="form-group col-md-6">
					<label for="password">Password</label> 
					<form:password path="password" id="password" class="form-control"/>
					<form:errors path="password" cssClass="error"/>				
				</div>				
			</div>
		</fieldset>
		<fieldset>
			<form:button type="submit" class="btn btn-primary" value="submit">Reset Password</form:button>
		</fieldset>
	</form:form>
	<h5>Enable/Disable Student</h5>
	<h6>(Lock/unlock Student access)</h6>			
	<hr/>
	<form:form modelAttribute="student" action="/student/enable/${student.id}" method="post">
		<fieldset>
			<div class="form-group">
				<label for="role">Role</label> 
				<form:input disabled = "true" path="role"/>	
		 	</div>		
			<div class="form-check">
				<form:checkbox class="form-check-input" path="enabled" id="enabled" />
				<label class="form-check-label" for="enabled">Enabled</label> 
				<form:errors path="enabled" cssClass="error"/>			
			</div>										
		</fieldset>
		<fieldset>
			<form:button type="submit" class="btn btn-primary" value="submit">Enable/disable Login</form:button>
		</fieldset>
	</form:form>
	<c:if var="canDelete" test="${student.isCanDelete()}">
		<h5>Delete Student</h5>
		<h6>(Student without room assignment)</h6>		
		<hr/>
		<form:form modelAttribute="student" action="/student/delete/${student.id}" method="post">
			<fieldset>
				<form:button type="submit" class="btn btn-primary" value="submit">Delete Student</form:button>
			</fieldset>
		</form:form>
	</c:if>
</c:if>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}

.subject.ng-valid {
	background-color: lightgreen;
}

.subject.ng-dirty.ng-invalid-required {
	background-color: red;
}

.subject.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.body.ng-valid {
	background-color: lightgreen;
}

.body.ng-dirty.ng-invalid-required {
	background-color: red;
}

.body.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-app="myApp" class="ng-cloak"
	ng-controller="UserController as ctrl">
	<div class="generic-container"
		style="margin-left: 10%; margin-right: 10%; margin-top: 10%; width: 80%">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Email Details Form </span>
			</div>
			<br>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="uname" style="margin-left: 5%">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.username" id="uname"
									class="username form-control input-sm"
									placeholder="Enter your name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.uname.$error.required">This is a
										required field</span> <span ng-show="myForm.uname.$error.minlength">Minimum
										length required is 3</span> <span ng-show="myForm.uname.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="email" style="margin-left: 5%">Email</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.user.email" id="email"
									class="email form-control input-sm"
									placeholder="Enter your Email" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.email.$error.required">This is a
										required field</span> <span ng-show="myForm.email.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="subject" style="margin-left: 5%">Subject</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.subject" id="subject"
									class="subject form-control input-sm"
									placeholder="Enter your Subject" required ng-minlength="3"/>
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.subject.$error.required">This is a
										required field</span> <span ng-show="myForm.subject.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="body" style="margin-left: 5%">Body</label>
							<div class="col-md-7">
								<textarea ng-model="ctrl.user.body" id="body"
									class="body form-control input-sm"
									placeholder="Enter your Body" required ng-minlength="10" cols="50" rows="15"></textarea>
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.body.$error.required">This is a
										required field</span> <span ng-show="myForm.body.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight" style="margin-left: 10.5%">
							<input type="submit" ng-click="ctrl.submit()"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid" />
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="<c:url value='/resources/static/js/app.js' />"></script>
	<script src="<c:url value='/resources/static/js/user_service.js' />"></script>
	<script src="<c:url value='/resources/static/js/user_controller.js' />"></script>


</body>
</html>
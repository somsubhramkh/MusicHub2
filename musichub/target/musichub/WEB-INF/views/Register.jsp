
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/WEB-INF/views/templates/Header.jsp"%>

<div class="row">

	<div class="section">
		<div class="container">
			<br />
			<ul class="breadcrumb">
				<li><a href="/musichub/">Home</a></li>
				<li class="active">Register</a>
				</li>

			</ul>
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-right">Register With Us:</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<img src="${images}/Logo.JPG" width="300px" class="img-responsive">
				</div>
				<div class="col-md-8">
					<form:form class="form-horizontal" role="form" action="/musichub/user/add" commandName="user" method="post">
						<div class="form-group">
							<div class="col-sm-2">
								<label for="name" class="control-label">Name</label>
							</div>
							<div class="col-sm-10">
								<form:input type="text" path="name" class="form-control" id="inputName"
									placeholder="Enter name" />
									<form:errors path="name" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2">
								<label for="email" class="control-label">Email</label>
							</div>
							<div class="col-sm-10">
								<form:input path="email" type="email" class="form-control" id="inputEmail"
									placeholder="Email" />
									<form:errors path="email" cssClass="error" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-2">
								<label for="password" class="control-label">Password</label>
							</div>
							<div class="col-sm-10">
								<form:input path="password" type="password" class="form-control" id="inputPassword"
									placeholder="Password" />
									<form:errors path="password" cssClass="error" />
							</div>
						</div>
						<form:input type="hidden" path="enabled" value="TRUE"/>
							<form:input type="hidden" path="role" value="ROLE_USER"/>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Register</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/Footer.jsp"%>
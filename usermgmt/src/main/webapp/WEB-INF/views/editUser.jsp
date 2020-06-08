<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://fonts.googleapis.com/css2?family=Josefin+Slab:wght@700&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/resources/css/chanepw.css"
	type="text/css" />
<title>Edit User Information</title>
</head>
<body class="home">
	<div class="wrapper">
		<jsp:include page='navAdmin.jsp' />
		<div class="main_container">
			<div class="header" style="font-size: 30px;">Edit User
				Information</div>
			<div style="align-items: center">
				<div class="card mr-auto ml-auto" style="width: 30rem;">
					<div class="card-header" style="text-align: center;">
						<h4>Information of ${existingUser.firstName}</h4>
					</div>
					<div class="card-body">
						<img src="<%=request.getContextPath()%>/resources/images/user.png"
							alt="" class="img-rounded"
							style="height: 40%; width: 40%; margin-left: 128px;" />
						<form
							action="/usermgmt/app/user/edit/submit?id=${existingUser.id}"
							style="margin: 50px;" method="post" name="vform"
							onsubmit="return Validate()">
							<div class="form-group">
								<label for="fname">First Name</label> <input type="text"
									class="form-control" value="${existingUser.firstName}"
									name="firstName">
								<div id="fname_error"></div>
							</div>
							<div class="form-group">
								<label for="mname">Middle Name</label> <input type="text"
									class="form-control" value="${existingUser.middleName}"
									name="middleName">
							</div>
							<div class="form-group">
								<label for="lname">Last Name</label> <input type="text"
									class="form-control" value="${existingUser.lastName}"
									name="lastName">
								<div id="lname_error"></div>
							</div>
							<div class="form-group">

								<c:choose>
									<c:when test="${existingUser.role eq 'CLIENT'}">
										<label>Role:</label>
										<input type="radio" id="admin" name="role" value="ADMIN">
										<label for="admin">Admin</label>
										<input type="radio" id="client" name="role" value="CLIENT"
											checked="checked">
										<label for="client">Client</label>
										<br>
									</c:when>
									<c:otherwise>
									<label>Role:</label>
										<input type="radio" id="admin" name="role" value="ADMIN" checked="checked">
										<label for="admin">Admin</label>
										<input type="radio" id="client" name="role" value="CLIENT">
										<label for="client">Client</label>
										<br>
									</c:otherwise>
								</c:choose>

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" value="${existingUser.email}"
									name="email" aria-describedby="emailHelp">
								<div id="email_error"></div>
							</div>
							<button class="btn btn-primary" type="Submit">Save
								Changes</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>

	<script type=text/javascript>
	// SELECTING ALL TEXT ELEMENTS
		var firstName = document.forms["vform"]["firstName"];
		var lastName = document.forms["vform"]["lastName"];
		var email = document.forms["vform"]["email"];
		
		// SELECTING ALL ERROR DISPLAY ELEMENTS	
		var fname_error = document.getElementById("fname_error");
		var lname_error = document.getElementById("lname_error");
		var email_error = document.getElementById("email_error");
		
		// SETTING EVENT LISTENERS
		firstName.addEventListener("blur", firstNameVerify, true);
		lastName.addEventListener("blur", lastNameVerify, true);
		email.addEventListener("blur", emailVerify, true);
		
		// VALIDATION FUNCTION
			function Validate(){
				if(firstName.value == ""){
					firstName.style.border = "1px solid red";
					document.getElementById('fname_error').style.color = "red";
					fname_error.textContent = "Do not leave the field empty.";
					firstName.focus();
					return false;
				}
				if(lastName.value == ""){
					lastName.style.border = "1px solid red";
					document.getElementById('lname_error').style.color = "red";
					lname_error.textContent = "Do not leave the field empty.";
					lastName.focus();
					return false;
				}
				if(email.value == ""){
					email.style.border = "1px solid red";
					document.getElementById('email_error').style.color = "red";
					email_error.textContent = "Do not leave the field empty.";
					email.focus();
					return false;
				}
			}
		
			// VERIFYING NAME
			function firstNameVerify(){
				if (firstName.value != ""){
					firstName.style.border = "1px solid #5E6E66";
					fname_error.innerHTML = "";
					return true;
				}
			}
			
			// VERIIFYING LAST NAME
			function lastNameVerify(){
				if (lastName.value != ""){
					lastName.style.border = "1px solid #5E6E66";
					lname_error.innerHTML = "";
					return true;
				}
			}
			
			// VERIFYING EMAIL
			function emailVerify(){
				if (email.value != ""){
					email.style.border = "1px solid #5E6E66";
					email_error.innerHTML = "";
					return true;
				}
			}
	</script>
</body>
</html>

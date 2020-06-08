<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
	href="<%= request.getContextPath() %>/resources/css/changepw.css" type="text/css" />
<title>Profile</title>
</head>
<body class="home">
	<div class="wrapper">
		<jsp:include page='navClient.jsp' />
		<div class="main_container">
			<div class="header" style="font-size: 30px;">Profile</div>
			<div class="card info">
				<div class="row no-gutters">
					<div class="col-md-2">
						<br> <img
							src="<%= request.getContextPath() %>/resources/images/user.png"
							style="height: 60%; width: 97%;">
					</div>
					<div class="col-md-10">
						<div class="card-body">
							<h5 class="card-title"><strong>Information</strong></h5>
							<p class="card-text">Name: ${loggedInUser.firstName} ${loggedInUser.middleName}	${loggedInUser.lastName}</p>
							<p class="card-text">Role: ${loggedInUser.role}</p>
							<p class="card-text">Email: ${loggedInUser.email}</p>
							<br> <a
								href="http://localhost:8080/usermgmt/app/changePassword"
								class="btn btn-primary">Change password</a> <a href="#"
								onclick="myFunction()" class="btn btn-info" id="btn">Edit
								Profile</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="wrapper">
		<div class="row" id="edit">
			<form action="/usermgmt/app/profile/update" style="margin: 25px 50px 60px 0px;" method="post" name="vform" onsubmit="return Validate()">
				<div class="col-md-10 float-left">
					<div class="card info">
						<div class="card-body">
							<h3 style="text-align: center;">Edit Your Profile</h3>
							<div class="form-group">
	                           <label for="fname" >First Name</label>
	                           <input type="text" value="${user.firstName}" class="form-control" name="firstName">
	                           <div id="fname_error"></div>
							</div>
							<div class="form-group">
	                           <label for="mname">Middle Name</label>
	                           <input type="text" value="${user.middleName}" class="form-control" name="middleName">
							</div>
							<div class="form-group">
	                           <label for="lname">Last Name</label>
	                           <input type="text" value="${user.lastName}" class="form-control" name="lastName">
	                           <div id="lname_error"></div>
							</div>
							<div class="form-group">
	                           <label for="exampleInputEmail1">Email address</label>
	                           <input type="email" value="${user.email}" class="form-control" name="email" aria-describedby="emailHelp">
	                           <div id="email_error"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2 float-right">
					<div class="card info" style="width: 35rem; margin-left: 70px;">
						<div class="card-body">
							<h5 class="card-title">Security Questions</h5>
							<br>
							<div class="form-group">
								<label>Which city were you born in?</label> <input type="text"
									class="form-control" name="ans1" value= "${user.ans1}"  placeholder="Your answer here..">
									<div id="ans1_error"></div>
							</div>
							<div class="form-group">
								<label>What is the name of your pet?</label> <input type="text"
									class="form-control" name="ans2" value= "${user.ans2}" 
									placeholder="Your answer here..">
								<div id="ans2_error"></div>
							</div>
							<br>
							<button class="btn btn-primary" type="Submit">Submit</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Adding JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>

	<script type=text/javascript>
      $(document).ready(function(){
      $("#edit").hide();
      $("#btn").click(function(){
        $("#edit").show();
        $("#btn").hide();
      });
    });
      
   // SELECTING ALL TEXT ELEMENTS
		var firstName = document.forms["vform"]["firstName"];
		var lastName = document.forms["vform"]["lastName"];
		var email = document.forms["vform"]["email"];
		var ans1 = document.forms["vform"]["ans1"];
		var ans2 = document.forms["vform"]["ans2"];
		
		// SELECTING ALL ERROR DISPLAY ELEMENTS	
		var fname_error = document.getElementById("fname_error");
		var lname_error = document.getElementById("lname_error");
		var email_error = document.getElementById("email_error");
		var ans1_error = document.getElementById("ans1_error");
		var ans2_error = document.getElementById("ans2_error");
		
		// SETTING EVENT LISTENERS
		firstName.addEventListener("blur", firstNameVerify, true);
		lastName.addEventListener("blur", lastNameVerify, true);
		email.addEventListener("blur", emailVerify, true);
		ans1.addEventListener("blur", ans1Verify, true);
		ans2.addEventListener("blur", firstNameVerify, true);
		
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
				if(ans1.value == ""){
					ans1.style.border = "1px solid red";
					document.getElementById('ans1_error').style.color = "red";
					ans1_error.textContent = "Do not leave the field empty.";
					ans1.focus();
					return false;
				}
				if(ans2.value == ""){
					ans2.style.border = "1px solid red";
					document.getElementById('ans2_error').style.color = "red";
					ans2_error.textContent = "Do not leave the field empty.";
					ans2.focus();
					return false;
				}
			}
		
			// VERIFYING EMAIL
			function firstNameVerify(){
				if (firstName.value != ""){
					firstName.style.border = "1px solid #5E6E66";
					fname_error.innerHTML = "";
					return true;
				}
			}
			
			// VERIIFYING PASSWORD
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
			
			// VALIDATING SECURITY ANSWER
			function ans1Verify(){
				if (ans1.value != ""){
					ans1.style.border = "1px solid #5E6E66";
					ans1_error.innerHTML = "";
					return true;
				}
			}
			
			// VALIDATING SECURITY ANSWER 
			function ans2Verify(){
				if (ans2.value != ""){
					ans2.style.border = "1px solid #5E6E66";
					ans2_error.innerHTML = "";
					return true;
				}
			}
    </script>
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</body>
</html>

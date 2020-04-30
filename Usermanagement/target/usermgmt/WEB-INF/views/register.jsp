<%-- 
    Document   : register
    Created on : Apr 24, 2020, 5:02:33 PM
    Author     : acer
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css" type="text/css" rel="stylesheet">
        <title>Register</title>
    </head>
  
    <body>
      <div class="container" style="padding-bottom: 66px;">
        <h1 style="text-align:center; padding: 30px;">Create a New Account</h1>
        <div class="row">
          <div class="col-md-6">
              <div class="card">
                  <div class="card-body">
                      <h5>Come join the community! Let's set up your account first. Already have an account? Login</h5>
                      <form:errors path="registrationForm.*"/>
                      <form action="/usermgmt/app/submit" style="margin: 50px;" method="post">
                      <p>${error}</p>
                          <div class="form-group">
                              <label for="fname">First Name</label>
                              <input type="text" class="form-control" name="fname">
                          </div>
                          <div class="form-group">
                              <label for="mname">Middle Name</label>
                              <input type="text" class="form-control" name="mname">
                          </div>
                          <div class="form-group">
                              <label for="lname">Last Name</label>
                              <input type="text" class="form-control" name="lname">
                          </div>
                          <div class="form-group">
                              <label for="exampleInputEmail1">Email address</label>
                              <input type="email" class="form-control" name="email" aria-describedby="emailHelp">
                          </div>
                          <div class="form-group">
                              <label for="Password1">Password</label>
                              <input type="password" class="form-control" name="pass1">
                          </div>
                          <div class="form-group">
                              <label for="Password2">Confirm Password</label>
                              <input type="password" class="form-control" name="pass2">
                          </div>
                  </div>
              </div>
          </div>
          <div class="col-md-6">
              <div class="card" style="width: 35rem; margin-left: 70px;">
                  <div class="card-body">
                      <h5 class="card-title">Help us keep your account secure.</h5>
                      <h6 class="card-subtitle mb-2 text-muted">Please answer the security questions.</h6> <br>
                      <div class="form-group">
                          <label>Which city were you born in?</label>
                          <input type="text" class="form-control" name="ans1" placeholder="Your answer here..">
                      </div>
                      <div class="form-group">
                          <label>What is the name of your pet?</label>
                          <input type="text" class="form-control" name="ans2" placeholder="Your answer here..">
                      </div> <br>
                      <button class="btn btn-primary" type="Submit">Submit</button>
                  </div>
              </div>
          </div>
              </form>
      </div>
    </div>
    </body>
</html>  

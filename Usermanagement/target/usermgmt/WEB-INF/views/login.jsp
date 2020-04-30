<%-- 
    Document   : login
    Created on : Apr 28, 2020, 6:33:17 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Oleo+Script+Swash+Caps&family=Rouge+Script&display=swap" rel="stylesheet"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <title>Register</title>
    </head>
    <body>
         <div class="container">
        <div class="row">
            <div class="col-md-5" style="padding-top: 15%;">
                <h2>Hello, there!</h2><br>
                <h4>Use a valid Email and Password to gain access to administration backend.</h4> <br>
                <img src="<%= request.getContextPath() %>/resources/images/lock.png" alt="lock" style="height: 40%; width: 42%;">
            </div>
            <div class="col-md-7" style="padding: 15.3%;">
                <div class="card" style="width: 30rem;">
                  <div class="card-body">
                    <h5 class="card-title text-center title">Administration</h5>
                  </div>
                </div>

                <div class="card text-center" style="width: 30rem;">
                  <div class="card-body">
                    <img src="<%= request.getContextPath() %>/resources/images/user.png" alt="" class="img-rounded" style="height: 40%; width: 40%;"><br>
                    <form>
                      <div class="form-group">
                        <label>Email address</label>
                        <input type="email" class="form-control" name="Email1" aria-describedby="emailHelp">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                      </div>
                      <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" name="Password1">
                      </div>
                      <p><a href="#">Forgot Password?</a></p>
                      <button type="submit" class="btn btn-primary">Login</button>
                    </form>
                  </div>
              </div>
            </div>
        </div>
    </div>
    </body>
</html>

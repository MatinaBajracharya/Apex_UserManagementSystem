<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%> 
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
	href="<%=request.getContextPath()%>/resources/css/style.css"
	type="text/css" />
<title>Home</title>
</head>
<body class="home">
	<div class="wrapper">
		<jsp:include page="navClient.jsp" />
		<div class="main_container">
			<div class="header" style="font-size: 30px;">Welcome!</div> <br>
				<div class="card ml-auto mr-auto" style="width: 80%;">
					<div class="card-header">
						<h4>At a Glance</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-6">
								<div class="card bg-light p-2 dash-box dash-box">
									<h2>
										<i class="fas fa-user-shield"></i>${loginCount}
									</h2>
									<h5>Number of times logged in</h5>
								</div>
							</div>
							<div class="col-md-6">
								<div class="card bg-light p-2 dash-box">
									<h2>
										<i class="fas fa-users"></i>${sessionTime} min(s)
									</h2>
									<h5>Session Time</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</body>
</html>

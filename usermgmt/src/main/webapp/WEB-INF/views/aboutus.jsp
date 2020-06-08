<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://fonts.googleapis.com/css2?family=Noticia+Text:wght@700&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@200&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/resources/css/aboutus.css" />
<title>About Us</title>
</head>
<body>
	<header>
		<!-- Navigation -->
		<div id="nav-bar">
			<nav class="navbar navbar-expand-lg navbar-light">
				<a class="navbar-brand" href="http://localhost:8080/usermgmt"><img
					src="<%= request.getContextPath() %>/resources/images/logo.jpg" alt=""
					style="height: 60px; border-radius: 50%;" /><strong> User
					Management System</strong></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="#"
							style="color: #fff;"><strong>ABOUT US</strong></a></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	<section id="team">
		<div class="container my-3 py-5 text-center">
			<div class="row team">
				<div class="col">
					<h1>Our Team</h1>
				</div>
			</div>

			<div class="team-card">
				<div class="card first">
					<div class="card-body">
						<img
							src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn4.iconfinder.com%2Fdata%2Ficons%2Fbusiness-conceptual-part1-1%2F513%2Fbusiness-woman-512.png&f=1&nofb=1"
							alt="" class="img-fluid-rounded-circle w-50 mb-3" />
						<h3>Matina Bajracharya</h3>
						<h5>NP03A180013</h5>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Voluptatem, itaque?</p>
						<div class="d-flex flex-row justify-content-center">
							<div class="p-4">
								<a href="#"> <i class="fa fa-facebook"></i>
								</a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-twitter"></i></a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="card second">
					<div class="card-body">
						<img
							src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn4.iconfinder.com%2Fdata%2Ficons%2Fbusiness-conceptual-part1-1%2F513%2Fbusiness-woman-512.png&f=1&nofb=1"
							alt="" class="img-fluid-rounded-circle w-50 mb-3" />
						<h3>Karma Dolma Gurung</h3>
						<h5>NP03A180020</h5>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Voluptatem, itaque?</p>
						<div class="d-flex flex-row justify-content-center">
							<div class="p-4">
								<a href="#"> <i class="fa fa-facebook"></i>
								</a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-twitter"></i></a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>
				<br />
				<div class="card third">
					<div class="card-body">
						<img
							src="http://hotprintdesign.com/wp-content/uploads/2019/02/Sani-Sebastian.png"
							alt="" class="img-fluid-rounded-circle w-50 mb-3" />
						<h3>Eric Joshi</h3>
						<h5>NP03A180010</h5>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Voluptatem, itaque?</p>
						<div class="d-flex flex-row justify-content-center">
							<div class="p-4">
								<a href="#"> <i class="fa fa-facebook"></i>
								</a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-twitter"></i></a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="card fourth">
					<div class="card-body">
						<img
							src="http://hotprintdesign.com/wp-content/uploads/2019/02/Sani-Sebastian.png"
							alt="" class="img-fluid-rounded-circle w-50 mb-3" />
						<h3>Grishan Bajracharya</h3>
						<h5>NP03A180014</h5>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Voluptatem, itaque?</p>
						<div class="d-flex flex-row justify-content-center">
							<div class="p-4">
								<a href="#"> <i class="fa fa-facebook"></i>
								</a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-twitter"></i></a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="card fifth">
					<div class="card-body">
						<img
							src="http://hotprintdesign.com/wp-content/uploads/2019/02/Sani-Sebastian.png"
							alt="" class="img-fluid-rounded-circle w-50 mb-3" />
						<h3>Jayant Karmacharya</h3>
						<h5>NP03A180007</h5>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Voluptatem, itaque?</p>
						<div class="d-flex flex-row justify-content-center">
							<div class="p-4">
								<a href="#"> <i class="fa fa-facebook"></i>
								</a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-twitter"></i></a>
							</div>
							<div class="p-4">
								<a href="#"><i class="fa fa-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>

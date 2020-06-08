<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	href="<%=request.getContextPath()%>/resources/css/chanepw.css"
	type="text/css" />
<title>Users</title>
</head>
<body class="home">
	<div class="wrapper">
		<jsp:include page="navAdmin.jsp" />
		<div class="main_container">
			<div class="header" style="font-size: 30px;">
				Users
				<form method="post"
					action="http://localhost:8080/usermgmt/app/users/search"
					class="form-inline my-2 my-lg-0 float-right">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" name="searchString" aria-label="Search"
						required />
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
						style="text-align: right;">Search</button>
				</form>
			</div>
			<div class="info">
				<a class="btn btn-primary"
					href="http://localhost:8080/usermgmt/app/newuser" role="button"
					style="float: right; margin-bottom: 25px;">Create New User</a>
				<div class="clearfix"></div>
				<div style="text-align: center;">
					<h3 style="color: red; text-align: center">${msg}</h3>
					<c:choose>
						<c:when test="${not empty allUsers}">
							<table class="table table-striped table-bordered" id="tableData"
								style="width: 80%; margin-left: auto; margin-right: auto;">
								<thead class="thead-dark">
									<tr>
										<th scope="col">First Name</th>
										<th scope="col">Middle Name</th>
										<th scope="col">Last Name</th>
										<th scope="col">Email</th>
										<th scope="col">Role</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${allUsers}">
										<tr>
											<td><c:out value="${user.firstName}" /></td>
											<td><c:out value="${user.middleName}" /></td>
											<td><c:out value="${user.lastName}" /></td>
											<td><c:out value="${user.email}" /></td>
											<td><c:out value="${user.role}" /></td>
											<td><a
												href="http://localhost:8080/usermgmt/app/user/edit?id=${user.id}"
												class="btn btn-secondary">Edit User Info</a>
												<form method="post"
													action="http://localhost:8080/usermgmt/app/user/delete"
													style="display: inline-block">
													<input type="hidden" name="deleteUserId" value="${user.id}" />
													<input type="hidden" name="email" value="${user.email}" />
													<input type="submit" value="DELETE USER"
														class="btn btn-danger" role="button">
												</form></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
	</div>

	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/paging.js"></script>
	<script type="text/javascript">
	            $(document).ready(function() {
	                $('#tableData').paging({limit:11});
	            });
	</script>
</body>
</html>

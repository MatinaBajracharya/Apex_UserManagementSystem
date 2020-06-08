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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css"
	type="text/css" />
<title>History</title>
</head>
<body class="home">
	<div class="wrapper">
	<jsp:include page='navClient.jsp' />
		<div class="main_container">
			<div class="header" style="font-size:30px;">History</div><br>
				<div style="text-align: center;">
					<table class="table table-striped table-bordered" id="tableData" style="width:80%;margin-left: auto; margin-right: auto;">
						<thead class="thead-dark">
							<tr>
							 	<th scope="col">First Name</th>
							    <th scope="col">Last Name</th>
							    <th scope="col">Role</th>
							    <th scope="col">Activity</th>
							    <th scope="col">Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="history" items="${allHistory}">
							<tr>
								<td><c:out value="${history.firstName}" /></td>
								<td><c:out value="${history.lastName}" /></td>
								<td><c:out value="${history.role}" /></td>
								<td><c:out value="${history.activity}" /></td>
								<td><c:out value="${history.date}" /></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.bg {
	background: #428bca !important;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<!------ Include the above in your HEAD tag ---------->

<script language="JavaScript"
	src="https://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
</head>
<body>
	<div class="container">
		<div class="card border-primary mb-3">
			<!-- <div class="row"> -->
			<div class="card bg text-white">
				<div class="card-body">SHIPMENT TYPE DATA</div>
			</div>
			<div class="col-md-12">
				<c:choose>
					<c:when test="${!empty list}">
						<label class="btn-xs"><a href="excel">Excel Export</a></label> | <label
							class="btn-xs"><a href="pdf">PDF Export</a></label>
						<table id="mytable" class="table border table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>MODE</th>
									<th>CODE</th>
									<th>ENABLE MODE</th>
									<th>GRADE</th>
									<th>NOTE</th>
									<th>EDIT</th>
									<th>DELETE</th>
								</tr>
								<c:forEach items="${list}" var="shipmenttype">
									<tr>
										<td><c:out value="${shipmenttype.id}"></c:out></td>
										<td><c:out value="${shipmenttype.mode}"></c:out></td>
										<td><c:out value="${shipmenttype.code}"></c:out></td>
										<td><c:out value="${shipmenttype.enabled}"></c:out></td>
										<td><c:out value="${shipmenttype.grade}"></c:out></td>
										<td><c:out value="${shipmenttype.dsc}"></c:out></td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Edit">
												<a href="edit?id=${shipmenttype.id}">
													<button class="btn btn-primary btn-xs" data-title="Edit"
														data-toggle="modal" data-target="#edit">
														<span class="glyphicon glyphicon-pencil"></span>
													</button>
												</a>
											</p></td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Delete">
												<a href="delete?id=${shipmenttype.id}"><button
														class="btn btn-danger btn-xs" data-title="Delete"
														data-toggle="modal" data-target="#delete">
														<span class="glyphicon glyphicon-trash"></span>
													</button></a>
											</p></td>
									</tr>
									
								</c:forEach>
							 </thead>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
					</c:otherwise>
				</c:choose>
				<!--PAGINATION-->
				<div align="right">
					<ul class="list-inline al">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</div>
			</div>
			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-danger text-white">${message}</div>
			</c:if>
			<!-- 	card end -->
		</div>
		<!-- container end -->
	</div>
</body>
</body>
</html>


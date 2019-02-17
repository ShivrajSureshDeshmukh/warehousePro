<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="BootStrapMenu.jsp" %>
<!DOCTYPE html>
<html>
<body>
	<div class="container">
		<div class="card border-primary mb-3">
			<!-- <div class="row"> -->
			<div class="card bg text-white">
				<div class="card-body">ORDER METHOD DATA</div>
			</div>
			<div class="col-md-12">
				<c:choose>
					<c:when test="${!empty list}">
						<label class="btn-xs"><a href="excel">Excel Export</a></label> | 	<label
							class="btn-xs"><a href="pdf">PDF Export</a></label>
						<!-- 	<div class="table-responsive border" > -->
						<table id="mytable" class="table border table-striped">
							<thead>
								<tr>
									<th>ORDER_METHOD ID</th>
									<th>ORDER MODE</th>
									<th>ORDER CODE</th>
									<th>ORDER METHOD</th>
									<th>ORDER ACCEPT</th>
									<th>DESCRIPTION</th>
									<th colspan="2">OPERATIONS</th>
								</tr>
								<c:forEach items="${list}" var="ordermethod">
									<tr>
										<td><c:out value="${ordermethod.id}"></c:out></td>
										<td><c:out value="${ordermethod.mode}"></c:out></td>
										<td><c:out value="${ordermethod.code}"></c:out></td>
										<td><c:out value="${ordermethod.method}"></c:out></td>
										<td><c:out value="${ordermethod.accept}"></c:out></td>
										<td><c:out value="${ordermethod.dsc}"></c:out></td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Edit">
												<a href="edit?id=${ordermethod.id}">
													<button class="btn btn-primary btn-xs" data-title="Edit"
														data-toggle="modal" data-target="#edit">
														<span class="glyphicon glyphicon-pencil"></span>
													</button>
												</a>
											</p></td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Delete">
												<a href="delete?id=${ordermethod.id}"><button
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


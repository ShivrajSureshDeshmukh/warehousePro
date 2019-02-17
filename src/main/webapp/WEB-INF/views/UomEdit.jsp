<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 -->
<style type="text/css">
</style>
</head>
<body>
	<!-- container start -->
	<div class="container" style="width: 50%;">

		<!-- card start -->
		<div class="card border-primary mb-3">


			<!-- card Header -->

			<div class="card-header">DMLWarehouse</div>
			<div class="card-body text-primary">
				<h5 class="card-title">UOM REGISTER PAGE</h5>
				<p class="card-text">Unit of Measurement, To identify one Item,
					it should be measured using one UOM Possible.</p>
			</div>

			<!-- card body -->
			<div class="card-body">

			<form:form action="update" method="post" modelAttribute="uom">
				<div class="form-row form-control-plaintext">
					<label for="type" class="control-label col-sm-3">UOM ID</label>
					
					<form:input path="id" cssClass="form-control col-sm-7"
							readonly="true" />
						
				</div>
					<div class="form-row form-control-plaintext">
						<label for="type" class="control-label col-sm-3">UOM TYPE</label>
						<form:select path="type" cssClass="form-control col-sm-7">
							<form:option value="">--SELECT--</form:option>
							<form:option value="PACKING">PACKING</form:option>
							<form:option value="NO PACKING">NO PACKING</form:option>
							<form:option value="-NA-">-NA-</form:option>
						</form:select>
						<label class="control-label col-sm-3"></label>
								<form:errors path="type" cssClass="text-danger" />
					</div>


					<div class="form-row form-control-plaintext">
						<label for="model" class="control-label col-sm-3">UOM
							MODEL</label>
						<form:input path="model" cssClass="form-control col-sm-7"
							placeholder="Enter here" />
						<label class="control-label col-sm-3"></label>
						<form:errors path="model" cssClass="text-danger" />
					</div>


					<div class="form-row form-control-plaintext">
						<label for="dsc" class="control-label col-sm-3">UOM NOTE</label>
						<form:textarea path="dsc" cssClass="form-control col-sm-7"
							placeholder="Enter here" />
						<label class="control-label col-sm-3"></label>
						<form:errors path="dsc" cssClass="text-danger" />
					</div>

					<div class="form-row form-control-plaintext">
						<label class="control-label col-sm-3"></label><input type="submit"
							value="Register" class="btn btn-primary col-sm-3" /> <label
							class="control-label col-sm-1"></label><input type="reset"
							value="Reset" class="btn col-sm-3" />
					</div>
				</form:form>
			</div>

			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>

			<!-- card end -->
		</div>

		<!-- container end -->
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
<%@include file="BootStrapMenu.jsp" %>
	<body>
	<!-- container start -->
	<div class="container" style="width: 50%;">

		<!-- card start -->
		<div class="card border-primary mb-3">
		
			<!-- card Header -->

			<div class="card-header">DMLWarehouse</div>
			<div class="card-body text-primary">
				<h5 class="card-title">SHIPMENT PAGE</h5>
				<p class="card-text">Unit of Measurement, To identify one Item,
					it should be measured using one UOM Possible.</p>
			</div>

			<!-- card body -->
			<div class="card-body">

		<form:form action="insert" method="post" modelAttribute="shipmenttype">
				
				
				<div class="form-row form-control-plaintext">
						<label for="type" class="control-label col-sm-3">SHIPMENT MODE :</label>
						<form:select path="mode">
							<form:option value="">---select---</form:option>
							<form:option value="Air">AIR</form:option>
							<form:option value="Truck">TRUCK</form:option>
							<form:option value="Ship">SHIP</form:option>
							<form:option value="Train">TRAIN</form:option>
						</form:select>

										</div>


					<div class="form-row form-control-plaintext">
						<label for="model" class="control-label col-sm-3">SHIPMENT CODE :
							MODEL</label>
						<form:input path="code" cssClass="form-control col-sm-7"
							placeholder="Enter here" />
						<label class="control-label col-sm-3"></label>
						<form:errors path="code" cssClass="text-danger" />
					</div>
					
					<div class="form-row form-control-plaintext">
						<label for="dsc" class="control-label col-sm-3">ENABLE SHIPMENT :</label>
					<form:checkbox path="enabled" value="Yes" />YES
					<label class="control-label col-sm-3"></label>
						<form:errors path="dsc" cssClass="text-danger" />
					</div>
					
					<div class="form-row form-control-plaintext">
						<label for="dsc" class="control-label col-sm-3"> SHIPMENT GRADE :</label>
					<form:radiobutton path="grade" value="A " />A <form:radiobutton
							path="grade" value="B" />B <form:radiobutton path="grade"
							value="C" />C
								<label class="control-label col-sm-3"></label>
						<form:errors path="dsc" cssClass="text-danger" />
					</div>
				
			<div class="form-row form-control-plaintext">
						<label for="dsc" class="control-label col-sm-3"> NOTES :</label>
					<form:textarea path="dsc" />
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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="BootStrapMenu.jsp" %>

<!DOCTYPE html>
<html lang="en">
<body>
	<!-- container start -->
	<div class="container" style="width: 50%;">

		<!-- card start -->
		<div class="card border-primary mb-3">


			<!-- card Header -->
			<div class="card-header">DMLWarehouse</div>
			<div class="card-body text-primary">
				<h5 class="card-title">ORDER METHOD REGISTER PAGE</h5>
				<p class="card-text">Unit of Measurement, To identify one Item,
					it should be measured using one UOM Possible.</p>
			</div>

			<!-- card body -->
			<div class="card-body">
				<form:form action="insert" method="post"
					modelAttribute="orderMethod" cssClass="form">

					   <div class="form-row form-control-plaintext">
						<label for="mode" class="control-label col-sm-3">Test
							Result </label>
							 <label class="radio-inline"><form:radiobutton
								path="mode" value="Sale" /> Sale</label> <label class="control-label col-sm-1"></label><label class="radio-inline">
							<form:radiobutton path="mode" value="Purchase"  /> Purchase</label>
						 <label class="control-label col-sm-3"></label><label class="control-label col-sm-3"></label>
						<form:errors path="mode" cssClass="text-danger" />
					</div>


					<div class="form-row form-control-plaintext">
						<label for="code" class="control-label col-sm-3">Order
							Code</label>
						<form:input path="code"	cssClass="form-control col-sm-7" placeholder="Enter here" />
					<label class="control-label col-sm-3"></label>
						<form:errors path="code" cssClass="text-danger" /> 
					 </div>

					<div class="form-row form-control-plaintext">
						<label for="method" class="control-label col-sm-3">Order
							Method </label>
						<form:select path="method" cssClass="form-control col-sm-7">
							<form:option value="">---select---</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select>
						<label class="control-label col-sm-3"></label>
						<form:errors path="method" cssClass="text-danger" />
					</div>

					<div class="form-row form-control-plaintext">
						<label for="accept" class="control-label col-sm-3">Order
							Accept </label>
							
								<div class="form-check form-check-inline">
							     <label class="form-check-label">
						<form:checkbox path="accept" value="Multi-Model" class="form-check-input" />
						Multi-Model
						</label>
  					  </div>
						
							<div class="form-check form-check-inline">
							     <label class="form-check-label">
						<form:checkbox path="accept" value="Accept-Return"  class="form-check-input"/>
						Accept-Return
						</label>
  					  </div>
						<label class="control-label col-sm-1"></label><label class="control-label col-sm-3"></label>
						<form:errors path="accept" cssClass="text-danger" />
					</div>

				<div class="form-row form-control-plaintext">
						<label for="dsc" class="control-label col-sm-3">Description</label>
						<form:textarea path="dsc" cssClass="form-control col-sm-7"
							placeholder="Enter here" />
						<label class="control-label col-sm-3"></label>
						<form:errors path="dsc" cssClass="text-danger" />
					</div>
					
					<div class="form-row form-control-plaintext">
						<label class="control-label col-sm-3"></label><input type="submit"
							value="Submit" class="btn btn-primary col-sm-3" /> <label
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

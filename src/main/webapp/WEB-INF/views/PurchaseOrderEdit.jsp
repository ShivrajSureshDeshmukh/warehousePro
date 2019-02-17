<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<div align="center">
		<h2>Purchase Order Screen#2</h2>
		<table>
			<form:form action="update" method="post" modelAttribute="purchaseOrder">
			<tr>
			<th>Order ID :</th><td><form:input path="purchaseId" readonly="true"/></td>
			</tr>
			<tr>
			<th>Order Code :</th><td><form:input path="purchaseCode"/></td>
			</tr>
				<tr>
					<th>Shipment Code :</th>
					<td><form:select path="shipmentCode.id">
							<form:option value="">---select---</form:option>
							<form:options items="${shipment}" itemLabel="code" itemValue="id"/>
							</form:select></td>
				</tr>
				<tr>
					<th>Vendor :</th>
					<td><form:select path="vendorType">
							<form:option value="">---select---</form:option>
							<form:options items="${vendors}" itemLabel="code" itemValue="id"/>
							</form:select></td>
				</tr>
				<tr>
			<th>Reference Number :</th><td><form:input path="purchaseRef"/></td>
			</tr>	
				<tr>
			<th>Quality Check :</th><td><form:radiobutton path="purchaseQuality" value="Required"/>Required <form:radiobutton path="purchaseQuality" value="NotRequired"/>Not Required</td>
			</tr>
			<tr>
			<th>Default Status :</th><td><form:input path="purchaseStatus" readonly="true" value="OPEN"/></td>
			</tr>
				<tr>
					<th>Description :</th>
					<td><form:textarea path="dsc" />
					<td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Place Order"></td>
				</tr>
			</form:form>
		</table>
		${message}
	</div>
</body>
</html>
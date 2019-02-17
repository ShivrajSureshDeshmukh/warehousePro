<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<div align="center">
		<h2>Create Shipment</h2>
		<table>
			<form:form action="update" method="post" modelAttribute="shipmenttype">
			<tr>
					<th>Shipment Type ID :</th>
					<td><form:input path="id" readonly="true" /></td>
				</tr>
			
				<tr>
					<th>Shipment mode :</th>
					<td><form:select path="mode">
							<form:option value="">---select---</form:option>
							<form:option value="Air">AIR</form:option>
							<form:option value="Truck">TRUCK</form:option>
							<form:option value="Ship">SHIP</form:option>
							<form:option value="Train">TRAIN</form:option>
						</form:select></td>
				</tr>

				<tr>
					<th>Shipment Code :</th>
					<td><form:input path="code" /></td>
				</tr>
				<tr>
					<th>Enable Shipment :</th>
					<td><form:checkbox path="enabled" value="Yes" />YES
					<td>
				</tr>
				<tr>
					<th>Shipment Grade :</th>
					<td><form:radiobutton path="grade" value="A " />A <form:radiobutton
							path="grade" value="B" />B <form:radiobutton path="grade"
							value="C" />C</td>
				</tr>

				<tr>
					<th>Description :</th>
					<td><form:textarea path="dsc" />
					<td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Update Shipment"></td>
				</tr>
			</form:form>
		</table>
		${message}
	</div>
</body>
</html>
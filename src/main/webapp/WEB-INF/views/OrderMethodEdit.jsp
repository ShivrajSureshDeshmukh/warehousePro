<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="BootStrapMenu.jsp" %>

<!DOCTYPE html>
<html>
<body>
	<div align="center">
		<h2>Update Order Method</h2>
		<table>
			<form:form action="update" method="post" modelAttribute="ordermethod">
			<tr>
					<th>Order Method ID :</th>
					<td><form:input path="id" readonly="true" /></td>
				</tr>
			<tr>
			<th>Test Result :</th><td><form:radiobutton path="mode" value="Sale "/>Sale <form:radiobutton path="mode" value="Purchase"/>Purchase</td>
			
			</tr>
			
			<tr>
			<th>Order Code :</th><td><form:input path="code"/></td>
			</tr>
				<tr>
					<th>Order Method :</th>
					<td><form:select path="method">
							<form:option value="">---select---</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th>Order Accept :</th>
					<td><form:checkbox path="accept" value="Multi-Model" />Multi-Model<form:checkbox
							path="accept" value="Accept-Return" />Accept-Return<td>

				</tr>
				<tr>
					<th>Description :</th>
					<td><form:textarea path="dsc" />
					<td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Update Order Method"></td>
				</tr>
			</form:form>
		</table>
		${message}
	</div>
</body>
</html>
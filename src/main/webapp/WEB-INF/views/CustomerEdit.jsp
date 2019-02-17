<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="BootStrapMenu.jsp" %>

<!DOCTYPE html>
<html>
<body>
	<div align="center">
		<h2>Update Customer</h2>
		<table cellpadding="5">
			<form:form action="update" method="post" modelAttribute="customer">
				<tr>
					<th align="right">Customer Id :</th>
					<td align="left"><form:input path="custId" readonly="true" /></td>
				</tr>
				
				<tr>
					<th align="right">Customer Code :</th>
					<td align="left"><form:input path="custCode" /></td>
				</tr>
				<tr>
					<th align="right">Customer Address :</th>
					<td align="left"><form:textarea path="custAddr" /></td>
				</tr>
				<tr>
					<th align="right">Customer Location :</th>
					<td align="left"><form:select path="custLocs" multiple="true">
							<form:option value="">---select---</form:option>
							<form:option value="HYD">Hyderabad</form:option>
							<form:option value="BAN">Bangalore</form:option>
							<form:option value="CHN">Chennai</form:option>
							<form:option value="MAHA">Maharashtra</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th align="right">Customer Enabled :</th>
					<td align="left" ><form:radiobutton path="custEnabled" value="Yes" />Yes <form:radiobutton
							path="custEnabled" value="No" />No</td>
				</tr>
				<tr>
					<th align="right">Customer Email :</th>
					<td align="left"><form:input path="custEmail" /></td>
				</tr>
				<tr>
					<th align="right">Customer Contact :</th>
					<td align="left"><form:input path="custContact" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Update Customer"></td>
				</tr>
			</form:form>
		</table>
		${message}
	</div>
</body>
</html>
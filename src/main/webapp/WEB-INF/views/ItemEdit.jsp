<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<div align="center">
		<h2>Update Item</h2>
		<table width="500">
			<form:form action="update" method="post" modelAttribute="item">

				<tr>
					<th align="right">ID:</th>
					<td><form:input path="itemId" /></td>
				</tr>
				<tr>
					<th align="right">Item Code :</th>
					<td><form:input path="itemCode" /></td>
				</tr>
				<tr>
					<th align="right">Item Dimensions :</th>
					<td>W: <form:input path="itemWidth" size="2" /> L: <form:input
							path="itemLength" size="2" />H: <form:input path="itemHight"
							size="2" /></td>
				</tr>
				<tr>
					<th align="right">Base Cost:</th>
					<td><form:input path="baseCost" /></td>
				</tr>
				<tr>
					<th align="right">Base Currency</th>
					<td><form:select path="baseCurrency">
							<form:option value="INR">INR</form:option>
							<form:option value="USA">USA</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th align="right">Item Uom:</th>
					<td><form:select path="uom.id">
							<form:option value="">--Select--</form:option>
							<form:options items="${uoms}" itemLabel="model" itemValue="id" />
						</form:select></td>
				</tr>
				<tr>
					<th align="right">Order Method Code(Sale):</th>
					<td><form:select path="saleType.id">
							<form:option value="">--Select--</form:option>
							<form:options items="${sales}" itemLabel="code" itemValue="id" />
						</form:select></td>
				</tr>
				<tr>
					<th align="right">Order Method Code(Purchase):</th>
					<td><form:select path="purchaseType.id">
							<form:option value="">--Select--</form:option>
							<form:options items="${purchases}" itemLabel="code"
								itemValue="id" />
						</form:select></td>
				</tr>
				<tr>
					<th align="right">
						<table>
							<tr>
								<td></td>
								<th align="center">Item Vendors <br> <form:select
										path="vendorType" multiple="true">
										<form:options items="${vendors}" itemLabel="code"
											itemValue="id" />
									</form:select>
								</th>
							</tr>
						</table>
					</th>
					<th align="justify">
						<table>
							<tr>
								<td></td>
								<th align="center">Item Customers <br> <form:select
										path="customerType" multiple="true">
										<form:options items="${customers}" itemLabel="code"
											itemValue="id" />
									</form:select></th>
							</tr>
						</table>
					</th>
				</tr>

				<tr>
					<th align="right">Description:</th>
					<td><form:input path="dsc" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="update Item"></td>
				</tr>
			</form:form>
		</table>
		${message}
	</div>
</body>
</html>
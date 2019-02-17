<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<div align="center">
		<h2>Create Vendor</h2>
		<table>
			<form:form action="insert" method="post" modelAttribute="vendor">
				<tr>
					<th>Vendor Name :</th>
					<td><form:input path="venName" /></td>
				</tr>
				
				<tr>
					<th>Vendor Code :</th>
					<td><form:select path="venCode">
							<form:option value="CAT">CAT</form:option>
							<form:option value="RES">RES</form:option>
							</form:select></td>
				</tr>
					<tr>
					<th>Vendor Designation :</th>
					<td><form:radiobutton path="venDesg" value="Sale" />Sale<form:radiobutton
							path="venDesg" value="Service"/>Service<form:radiobutton path="venDesg"
							value="Both" />Both</td>
				</tr>
				<tr>
					<th>Vendor Preserve :</th>
					<td><form:checkbox path="venPreserve" value="A" />A
						<form:checkbox path="venPreserve" value="B" />B
						<form:checkbox path="venPreserve" value="C" />C
					<td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Create Vendor"></td>
				</tr>
			</form:form>
		</table>
		${message}
	</div>
</body>
</html>
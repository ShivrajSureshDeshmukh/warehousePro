<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <head>
<style type="text/css">
.err{
 color:red;
}

</style>
</head>
<body>
<div align="center">
<h2>Create WhUserType</h2>
	<table>
		<form:form action="insert" method="post" modelAttribute="whUserType">
		<tr>
			<th>User Type :</th><td><form:radiobutton path="type" value="Vendor"/>Vendor <form:radiobutton path="type" value="Consumer"/>Consumer</td><td width="200"><form:errors path="type" cssClass="err"/></td>
			</tr>
			
		<tr>
				<th>User Code :</th>
				<td><form:input path="code" /> </td><td width="200"><form:errors path="code" cssClass="err"/></td>
			</tr>
		
	       <tr>
				<th>User for :</th>
				<td><form:input path="forType" /></td>
			</tr>
		   <tr>
				<th>User Email :</th>
				<td><form:input path="email" /></td>
			</tr>
			   <tr>
				<th>User Contact :</th>
				<td><form:input path="contact" /></td>
			</tr>
			<tr>
				<th>User_ID Type :</th>
				<td><form:select path="idType">
						<form:option value="">---select---</form:option>
						<form:option value="Pan Card">PAN CARD</form:option>
						<form:option value="Aadhar Card">AADHAR CARD</form:option>
						<form:option value="Voter Id">VOTER ID</form:option>
						<form:option value="Voter Id">OTHER</form:option>
					</form:select></td>
			</tr>
			<tr>
				<th>If Other :</th>
				<td><form:input path="ifOther" /></td>
			</tr>
			<tr>
				<th>Id Number :</th>
				<td><form:input path="idNum" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Create User"></td>
			</tr>
		</form:form>
	</table>
	${message}
	</div>
</body>
</html>
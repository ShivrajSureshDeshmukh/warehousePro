<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="BootStrapMenu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title>Customer Data</title>
</head>
<body>
	<h2>Customer Details</h2>
	
	<a href="excel">Excel Export</a> | 	<a href="pdf">PDF Export</a>	
<table border="1">
	<tr>
		<th>CUSTOMER ID</th>
		<th>CODE</th>
		<th>ADDRESS</th>
		<th>LOCATION</th>
		<th>ENABLED</th>
		<th>EMIAL</th>
		<th>CONTACT</th>
		<th colspan="2">OPERATIONS</th>
	</tr>
	<c:forEach items="${list}" var="customer">
		<tr>
			<td><c:out value="${customer.custId}"/></td>
			<td><c:out value="${customer.custCode}"/></td>
			<td><c:out value="${customer.custAddr}"/></td>
			<td><c:out value="${customer.custLocs}"/></td>
			<td><c:out value="${customer.custEnabled}"/></td>
			<td><c:out value="${customer.custEmail}"/></td>
			<td><c:out value="${customer.custContact}"/></td>
			
			<td><a href="delete?id=${customer.custId}">DELETE</a></td>
			<td><a href="edit?id=${customer.custId}">EDIT</a></td>
			
		</tr>
	</c:forEach>
</table>
${message}
</body>
</html>
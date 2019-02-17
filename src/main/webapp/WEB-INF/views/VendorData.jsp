<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>VENDOR Data</title>
</head>
<body>
	<h2>Vendor Data</h2>
	<a href="excel">Excel Export</a> | 	<a href="pdf">PDF Export</a>	
<table border="1">
	<tr>
		<th>VENDOR_ID</th>
		<th>VENDOR_NAME</th>
		<th>VENDOR_CODE</th>
		<th>VENDOR_DESIGNATION</th>
		<th>VENDOR_PRESERVE</th>
		<th colspan="2">OPERATIONS</th>
	</tr>
	<c:forEach items="${list}" var="vendor">
		<tr>
			<td><c:out value="${vendor.venId}"></c:out></td>
			<td><c:out value="${vendor.venName}"></c:out></td>
			<td><c:out value="${vendor.venCode}"></c:out></td>
			<td><c:out value="${vendor.venDesg}"></c:out></td>
			<td><c:out value="${vendor.venPreserve}"></c:out></td>
			<td><a href="delete?id=${vendor.venId}">DELETE</a></td>
			<td><a href="edit?id=${vendor.venId}">EDIT</a></td>
			
		</tr>
	</c:forEach>
</table>
${message}
</body>
</html>
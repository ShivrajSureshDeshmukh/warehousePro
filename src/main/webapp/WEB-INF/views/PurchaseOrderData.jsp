<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Purchase Order</title>
</head>
<body>
	<h2>Purchase Order</h2>
	<a href="excel">Excel Export</a> |
	<a href="pdf">PDF Export</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>SHIPMENT CODE</th>
			<th>VENDOR</th>
			<th>REF.NO.</th>
			<th>QUALITY</th>
			<th>STATUS</th>
			<th>NOTE</th>
			<th colspan="2">OPERATIONS</th>

		</tr>
		<c:forEach items="${list}" var="po">
			<tr>
				<td><c:out value="${po.purchaseId}" /></td>
				<td><c:out value="${po.purchaseCode}" /></td>
				<td><c:out value="${po.shipmentCode.code}" /></td>
				<td><c:out value="${po.vendorType.code}" /></td>
				
				
				<td><c:out value="${po.purchaseRef}" /></td>
				<td><c:out value="${po.purchaseQuality}" /></td>
				<td><c:out value="${po.purchaseStatus}" /></td>
				<td><c:out value="${po.dsc}" /></td>
				<td><a href="delete?id=${po.purchaseId}">DELETE</a></td>
				<td><a href="edit?id=${po.purchaseId}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>
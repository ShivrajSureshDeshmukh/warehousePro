<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Item Data</title>
</head>
<body>
	<h2>Item Data</h2>
	<a href="excel">Excel Export</a> |
	<a href="pdf">PDF Export</a>
	<table border="1">
		<tr>
			<th>ITEM_ID</th>
			<th>CODE</th>
			<th>WIDTH</th>
			<th>LENGTH</th>
			<th>HIGHT</th>
			<th>BASE COST</th>
			<th>CURRENCY</th>
			<th>UOM</th>
			<th>SALE CODE</th>
			<th>PURCHASE CODE</th>
			<th>VENDORS</th>
			<th>CUSTOMERS</th>
			<th>NOTE</th>
			<th colspan="2">OPERATIONS</th>

		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td><c:out value="${item.itemId}" /></td>
				<td><c:out value="${item.itemCode}" /></td>
				<td><c:out value="${item.itemWidth}" /></td>
				<td><c:out value="${item.itemLength}" /></td>
				<td><c:out value="${item.itemHight}" /></td>
				<td><c:out value="${item.baseCost}" /></td>
				<td><c:out value="${item.baseCurrency}" /></td>
				<td><c:out value="${item.uom.model}" /></td>
				<td><c:out value="${item.saleType.code}"></c:out></td>
				<td><c:out value="${item.purchaseType.code}"></c:out></td>
				<td><c:forEach items="${item.vendorType}" var="ven">
						<c:out value="${ven.code}" />,
					</c:forEach></td>
				<td><c:forEach items="${item.customerType}" var="cust">
						<c:out value="${cust.code}" />,
					</c:forEach></td>
				<td><c:out value="${item.dsc}"></c:out></td>
				<td><a href="delete?id=${item.itemId}">DELETE</a></td>
				<td><a href="edit?id=${item.itemId}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>
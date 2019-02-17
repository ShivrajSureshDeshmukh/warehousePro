<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>WhUserType Data</title>
</head>
<body>
	<h2>User Data</h2>
<table border="1">
	<tr>
		<th>WH_USER_TYPE ID</th>
		<th>USER TYPE</th>
		<th>USER CODE</th>
		<th>USER FOR</th>
		<th>USER EMAIL</th>
		<th>USER CONTACT</th>
		<th>USER_ID TYPE</th>
		<th>IF OTHER</th>
		<th>ID NUMBER</th>
		<th colspan="2">OPERATIONS</th>
	</tr>
	<c:forEach items="${list}" var="whusertype">
		<tr>
			<td><c:out value="${whusertype.id}"></c:out></td>
			<td><c:out value="${whusertype.type}"></c:out></td>
			<td><c:out value="${whusertype.code}"></c:out></td>
			<td><c:out value="${whusertype.forType}"></c:out></td>
			<td><c:out value="${whusertype.email}"></c:out></td>
			<td><c:out value="${whusertype.contact}"></c:out></td>
			<td><c:out value="${whusertype.idType}"></c:out></td>
			<td><c:out value="${whusertype.ifOther}"></c:out></td>
			<td><c:out value="${whusertype.idNum}"></c:out></td>
			
			<td><a href="delete?id=${whusertype.id}">DELETE</a></td>
			<td><a href="edit?id=${whusertype.id}">EDIT</a></td>
			
		</tr>
	</c:forEach>
</table>
${message}
</body>
</html>
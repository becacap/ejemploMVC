<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
		<style><%@include file="styles.css"%></style>
	</head>
	
	<body>
		
		<div align="center">
			<h1>Welcome home ${user}</h1>
		</div>
		
		<div align="center">
			
			<table class="border">
				<tr>
					<td class="breath">Fecha</td>
					<td class="breath">Concepto</td>
					<td class="breath">Importe</td>
					<td class="breath">Gastos</td>
				</tr>
				<c:forEach var="m" items="${ movimientos }">
					<tr>
						<td class="breath">${ m.fecha }</td>
						<td class="breath">${ m.concepto }</td>
						<td class="breath">${ m.importe }</td>
						<td class="breath">${ m.importe }</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
		
	</body>
	
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transacciones</title>
<style type="text/css">
.rojo {
	color: red;
}

.negro {
	color: black;
}
</style>
</head>
<body>
	<div align="center">


		<table border="1">
			<tr>
				<td align="center"><a href="sortDate">FECHA</a></td>
				<td align="center"><a href="sortConcept">CONCEPTO</a></td>
				<td align="center"><a href="sortImportValue">IMPORTE</a></td>
			</tr>
			<c:set var="estilo" value="negro"></c:set>
			<c:set var="saldo" value="0" />
			<c:forEach items="${movimientos}" var="movimiento">
				<c:set var="saldo" value="${saldo+movimiento.importe}" />

				<c:if test="${movimiento.importe lt 0 }">
					<c:set var="estilo" value="rojo" />
				</c:if>

				<tr>
					<td align="center">${movimiento.fecha}</td>
					<td align="center">${movimiento.concepto}</td>
					<td align="center" class="${estilo} }">${movimiento.importe}</td>
				</tr>
				<c:set var="estilo" value="negro" />
			</c:forEach>

		</table>
		<h1 align="center">Saldo: ${saldo}</h1>
		</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla de movimientos</title>
</head>
<body>
	<h1 align="center">LISTADO DE MOVIMIENTOS</h1>
	<BR>

	<div align="center">


		<table border="1">
			<tr>
				<td align="center">FECHA</td>
				<td align="center">CONCEPTO</td>
				<td align="center">IMPORTE</td>
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
</body>
</html>
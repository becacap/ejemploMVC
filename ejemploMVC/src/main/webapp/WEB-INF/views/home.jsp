<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

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

	<h1 align="center">LISTADO DE MOVIMIENTOS</h1>
	<BR>

	<div align="center">


		<table border="1">
			<tr>
				<td align="center"><a href="orderByDate">FECHA</a></td>
				<td align="center"><a href="orderByConcept">CONCEPTO</a></td>
				<td align="center"><a href="orderByImport">IMPORTE</a></td>
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

		<h1 align="center">${resultado }</h1>
		<h1 align="center">${datos }</h1>

	</div>
</html>




















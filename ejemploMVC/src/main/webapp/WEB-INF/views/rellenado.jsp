<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<style type="text/css">
@import "themes/blue/style.css";
</style>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.tablesorter.js"></script>
<script type="text/javascript">
	$(function() {
		//Cuando la página se cargue convertimos la tabla con id "myTable" en una tabla ordenable
		$("#datos").tablesorter();
	});
</script>
<style>
body {
	font-family: Arial;
}
</style>
</head>
<body>

	<h1 align="center">LISTADO DE MOVIMIENTOS</h1>

	<div align="center">


		<table border="1" class="tablesorter" id="datos">
			<tr>
				<td align="center">USUARIO</td>
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
					<td align="center">${persona.usuario}</td>
					<td align="center">${movimiento.fecha}</td>
					<td align="center">${movimiento.concepto}</td>
					<td align="center" class="${estilo} }">${movimiento.importe}</td>
				</tr>
				<c:set var="estilo" value="negro" />
			</c:forEach>

		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#datos').tablesorter();
		});
	</script>
</body>
</html>




















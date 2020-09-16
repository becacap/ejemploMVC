<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Mukta:wght@200;300;400;500&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Home</title>

<style type="text/css">
body {
	font-family: 'Mukta', sans-serif;
}

.rojo {
	color: red;
}

.negro {
	color: green;
}
</style>
</head>
<body>

	<div class="jumbotron">
		<h1 class="display-4">LISTADO DE MOVIMIENTOS</h1>
	</div>

	<table border="1" class="table table-striped table-dark">
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

	<div class="jumbotron">
		<h1 class="display-4">Saldo: ${saldo}</h1>
		<p class="lead">${resultado }</p>
	</div>
</html>




















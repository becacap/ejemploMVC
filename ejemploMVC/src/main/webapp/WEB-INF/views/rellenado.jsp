<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">LISTADO DE MOVIMIENTOS</h1>
	<BR>

	<div align="center">


		<table border="1">
			<tr>
				<td align="center">FECHA</td>
				<td align="center">CONCEPTO</td>
				<td align="center">DEBE</td>
				<td align="center">HABER</td>
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
					<c:choose>
					<c:when test="${movimiento.importe ge 0 }">
						<td align="center" class="${estilo}">0</td>
					</c:when>
					<c:otherwise>
						<td align="center" class="${estilo}">${movimiento.importe}</td>
					</c:otherwise>
					</c:choose>
					<c:choose>
					<c:when test="${movimiento.importe lt 0 }">
						<td align="center" class="${estilo}">${movimiento.importe}</td>
					</c:when>
					<c:otherwise>
						<td align="center" class="${estilo}">0</td>
					</c:otherwise>
					</c:choose>


				</tr>
				<c:set var="estilo" value="negro" />
			</c:forEach>

		</table>
		<h1 align="center">Saldo: ${saldo}</h1>
</body>
</html>
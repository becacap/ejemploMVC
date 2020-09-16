<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<!--  <title>Home</title>

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


		<spring:form action="rellenado" modelAttribute="persona">
			<div align="center">
				<table>
					<tr>
						<td>Usuario:</td>
						<td><spring:input path="usuario"/> </td>
					</tr>
					<tr>
						<td>Clave:</td>
						<td><spring:password path="clave"/> </td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="registro"></td>

					</tr>

				</table>
			</div>

		</spring:form>
		<h1 align="center">${resultado }</h1>
		<h1 align="center">${datos }</h1>

	</div> -->
	<title>Login</title>
	<h1 align="center">LOGIN</h1>
	<spring:form action="rellenado" modelAttribute="persona">
			<div align="center">
				<table>
					<tr>
						<td>Usuario:</td>
						<td><spring:input path="usuario"/> </td>
					</tr>
					<tr>
						<td>Clave:</td>
						<td><spring:password path="clave"/> </td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="login"></td>

					</tr>

				</table>
			</div>

		</spring:form>
</html>




















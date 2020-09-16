<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>

<%
	/*
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

</div>

*/
%>


<head>
<title>Home</title>

<style type="text/css">
.rojo {
	color: red;
}

.negro {
	color: black;
}

.verde {
	color: green;
}
</style>

</head>

<body style="background-color:#F5FFFA;">
	<h1 style="color:#0000CD;" align="center">Página de login. Introduce tu usuario y tu
		contraseña</h1>
	<BR>

	<div align="center">
		<spring:form action="rellenado" modelAttribute="persona">
			<div align="center">
				<table>
					<tr>
						<td>Usuario:</td>
						<td><spring:input path="usuario" /></td>
					</tr>
					<tr>
						<td>Clave:</td>
						<td><spring:password path="clave" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="registro"></td>

					</tr>

				</table>
			</div>

		</spring:form>
		
		<img
			src="data:image/png;base64,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"
			width="250" height="150" align="bottom">
</body>



</html>




















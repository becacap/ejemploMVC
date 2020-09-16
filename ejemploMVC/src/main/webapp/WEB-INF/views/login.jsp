<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<style type="text/css">
.rojo {
	color: red;
}

.negro {
	color: black;
}
</style>
<head>
<title>Login</title>
</head>
<body>
	<h6>${mensaje}</h6>
	<h6>${movs}</h6>
	<table border="1">
		<tr>
			<td align="center">FECHA</td>
			<td align="center">CONCEPTO</td>
			<td align="center">IMPORTE</td>
		</tr>
		<c:set var="estilo" value="negro"></c:set>
		<c:set var="saldo" value="0" />
		<c:forEach items="${movs}" var="mov">
		
			<c:set var="saldo" value="${saldo+movs.importe}" />

			<!-- Si el movimiento es menor de 0, el importe se muestra en rojo -->
			<c:if test="${movs.importe lt 0 }">
				<c:set var="estilo" value="rojo" />
			</c:if>

			<tr>
				<td align="center">${movs.fecha}</td>
				<td align="center">${movs.concepto}</td>
				<td align="center" class="${estilo}">${movs.importe}</td>
			</tr>
			<!-- La variable vuelve a ser negra al final de cada iteración, para ahorrarnos el else --> 
			<c:set var="estilo" value="negro" />
		</c:forEach>

	</table> 

</body>
</html>




















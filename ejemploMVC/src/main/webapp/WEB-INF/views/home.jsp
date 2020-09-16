<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<h1 align="center">Datos de la cuenta</h1>
	<br>
	<div align="right"><a href="logout">Cerrar Sesion</a></div>
	
	<br>
	<a>Buenas, ${persona.usuario}</a>
	<div align="center">
		<table border="1">
			<tr>
				<td> <a href="sfecha">FECHA</a></td>
				<td><a href="sconcepto">CONCEPTO</a></td>
				<td><a href="simporte">IMPORTE</a></td>
			</tr>
			<c:set var="estilo" value="negro"></c:set>

			<c:forEach items="${movimientos}" var="movimientos">
				<c:if test="${movimientos.importe lt 0}">
					<c:set var="estilo" value="rojo"></c:set>
				</c:if>
				<tr>
					<td>${movimientos.fecha}</td>
					<td>${movimientos.concepto}</td>
					<td class="${estilo}">${movimientos.importe}</td>
				</tr>
				<c:set var="estilo" value="negro"></c:set>
			</c:forEach>
		</table>
	</div>
	<br>
	<br>
</body>
</html>

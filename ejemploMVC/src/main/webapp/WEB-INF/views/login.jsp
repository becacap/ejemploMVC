<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>

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

	<h1 align="center">LOGIN</h1>
	<BR>

	<div align="center">

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
		<c:set var="estilo" value="rojo"></c:set>
		<h2 align="center" class="${estilo} }">${datos}</h2>

	</div>
</html>
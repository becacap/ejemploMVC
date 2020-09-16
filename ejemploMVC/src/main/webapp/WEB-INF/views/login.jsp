<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring"
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

	<h1 align="center">LOG-IN</h1>
	<BR>

	<div align="center">

		<spring:form action="login" modelAttribute="persona">
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
						<td colspan="2" align="center">
							<input type="submit" value="registro">
						</td>

					</tr>

				</table>
			</div>

		</spring:form>

	</div>
	<div align="center"><b><font color=#FF0000>${logError }</font></b></div>
</html>




















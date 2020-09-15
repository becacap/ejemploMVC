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
	<h1 align="center">LOGIN</h1>
	<div align="center">
 
		<form action="login">
			<div align="center">
				<table>
					<tr>
						<td>Usuario:</td>
						<td><input type="text" name="usuario"></td>
					</tr>
					<tr>
						<td>Clave:</td>
						<td><input type="password" name="clave"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="registro"></td>

					</tr>

				</table>
			</div>

		</form>
		<h1 align="center">${resultado }</h1>
		<h1 align="center">${datos }</h1>

	</div>
</html>




















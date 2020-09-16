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
</head>
<body>
	<h1 align="center">Inicio de Sesion</h1>
	<br>
	<br>
	<div>
		<a style={color=red}>${resultado}</a>
	</div>
	<div align="center">
		<form action="login" method="post">
			<table>
				<tr>
					<td>User:</td>
					<td><input type="text" name="usuario"></td>
				</tr>
				<tr>
					<td>pass:</td>
					<td><input type="password" name="clave"></td>
				</tr>
				<tr>
					<td><input type="submit" name="InicioSesion"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

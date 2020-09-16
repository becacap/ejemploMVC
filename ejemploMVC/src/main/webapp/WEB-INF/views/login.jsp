<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://fonts.googleapis.com/css2?family=Mukta:wght@200;300;400;500;600;700;800&display=swap"
	rel="stylesheet">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/login.js" />"></script>
<title>Login BecaCap</title>
</head>
<body>

	<div class="login-reg-panel">
		<div class="login-info-box">

			<h2>¿Ya tienes cuenta?</h2>
			<p>Incia sesion</p>
			<label id="label-register" for="log-reg-show">Login</label> <input
				type="radio" name="active-log-panel" id="log-reg-show"
				checked="checked">
		</div>

		<div class="register-info-box">
			<h2>¿No tienes cuenta?</h2>
			<p>Registrate</p>
			<label id="label-login" for="log-login-show">Registro</label> <input
				type="radio" name="active-log-panel" id="log-login-show">
		</div>


		<div class="white-panel">
			<div class="login-show">
				<h2>LOGIN</h2>
				<!--  
				<form action="login" method="POST">
					<input type="text" placeholder="Nombre" name="usuario"> <input
						type="password" placeholder="Contraseña" name="password">
					<input type="submit" value="Login"> <a href="login">¿Olvidaste
						la contraseña?</a>
					<p id="loginFail">${loginIncorrecto}</p>
				</form>
				-->

				<!-- FORMULARIO DE SPRING QUE RELLENA EL OBJETO PASADO DESDE EL CONTROLLER -->
				<spring:form action="login2" method="POST" modelAttribute="persona">
					<spring:input placeholder="Nombre" path="usuario" />
					<spring:password placeholder="Contraseña" path="clave" />
					<input type="submit" value="Login">
					<a href="login">¿Olvidaste la contraseña?</a>
					<p id="loginFail">${loginIncorrecto}</p>
				</spring:form>

			</div>

			<div class="register-show">
				<h2>REGISTER</h2>
				<input type="text" placeholder="Nombre"> <input
					type="password" placeholder="Contraseña"> <input
					type="password" placeholder="Confirma contraseña"> <input
					type="button" value="Registro">
			</div>

		</div>
	</div>
</body>
</html>
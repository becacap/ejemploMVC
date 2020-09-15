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
	href="https://fonts.googleapis.com/css2?family=Mukta:wght@200;300;400;500&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
body {
	font-family: 'Mukta', sans-serif;
	height: 100vh;
	min-height: 550px;
	background-image:
		url(http://www.planwallpaper.com/static/images/Free-Wallpaper-Nature-Scenes.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	position: relative;
	overflow-y: hidden;
}

a {
	text-decoration: none;
	color: #444444;
}

.login-reg-panel {
	position: relative;
	top: 50%;
	transform: translateY(-50%);
	text-align: center;
	width: 70%;
	right: 0;
	left: 0;
	margin: auto;
	height: 400px;
	background-color: rgba(236, 48, 20, 0.9);
}

.white-panel {
	background-color: rgba(255, 255, 255, 1);
	height: 500px;
	position: absolute;
	top: -50px;
	width: 50%;
	right: calc(50% - 50px);
	transition: .3s ease-in-out;
	z-index: 0;
	box-shadow: 0 0 15px 9px #00000096;
}

.login-reg-panel input[type="radio"] {
	position: relative;
	display: none;
}

.login-reg-panel {
	color: #B8B8B8;
}

.login-reg-panel #label-login, .login-reg-panel #label-register {
	border: 1px solid #9E9E9E;
	padding: 5px 5px;
	width: 150px;
	display: block;
	text-align: center;
	border-radius: 10px;
	cursor: pointer;
	font-weight: 600;
	font-size: 18px;
}

.login-info-box {
	width: 30%;
	padding: 0 50px;
	top: 20%;
	left: 0;
	position: absolute;
	text-align: left;
}

.register-info-box {
	width: 30%;
	padding: 0 50px;
	top: 20%;
	right: 0;
	position: absolute;
	text-align: left;
}

.right-log {
	right: 50px !important;
}

.login-show, .register-show {
	z-index: 1;
	display: none;
	opacity: 0;
	transition: 0.3s ease-in-out;
	color: #242424;
	text-align: left;
	padding: 50px;
}

.show-log-panel {
	display: block;
	opacity: 0.9;
}

.login-show input[type="text"], .login-show input[type="password"] {
	width: 100%;
	display: block;
	margin: 20px 0;
	padding: 15px;
	border: 1px solid #b5b5b5;
	outline: none;
}

.login-show input[type="submit"] {
	max-width: 150px;
	width: 100%;
	background: #444444;
	color: #f9f9f9;
	border: none;
	padding: 10px;
	text-transform: uppercase;
	border-radius: 2px;
	float: right;
	cursor: pointer;
}

.login-show a {
	display: inline-block;
	padding: 10px 0;
}

.register-show input[type="text"], .register-show input[type="password"]
	{
	width: 100%;
	display: block;
	margin: 20px 0;
	padding: 15px;
	border: 1px solid #b5b5b5;
	outline: none;
}

.register-show input[type="button"] {
	max-width: 150px;
	width: 100%;
	background: #444444;
	color: #f9f9f9;
	border: none;
	padding: 10px;
	text-transform: uppercase;
	border-radius: 2px;
	float: right;
	cursor: pointer;
}

.credit {
	position: absolute;
	bottom: 10px;
	left: 10px;
	color: #3B3B25;
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	text-transform: uppercase;
	font-size: 12px;
	font-weight: bold;
	letter-spacing: 1px;
	z-index: 99;
}

a {
	text-decoration: none;
	color: #2c7715;
}
</style>
<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			$('.login-info-box').fadeOut();
			$('.login-show').addClass('show-log-panel');
		});

		$('.login-reg-panel input[type="radio"]').on('change', function() {
			if ($('#log-login-show').is(':checked')) {
				$('.register-info-box').fadeOut();
				$('.login-info-box').fadeIn();

				$('.white-panel').addClass('right-log');
				$('.register-show').addClass('show-log-panel');
				$('.login-show').removeClass('show-log-panel');

			} else if ($('#log-reg-show').is(':checked')) {
				$('.register-info-box').fadeIn();
				$('.login-info-box').fadeOut();

				$('.white-panel').removeClass('right-log');

				$('.login-show').addClass('show-log-panel');
				$('.register-show').removeClass('show-log-panel');
			}
		});
	});
</script>
<title>Login BecaCap</title>
</head>
<body>

	<div class="login-reg-panel">
		<div class="login-info-box">

			<h2>�Ya tienes cuenta?</h2>
			<p>Incia sesion</p>
			<label id="label-register" for="log-reg-show">Login</label> <input
				type="radio" name="active-log-panel" id="log-reg-show"
				checked="checked">
		</div>

		<div class="register-info-box">
			<h2>�No tienes cuenta?</h2>
			<p>Registrate</p>
			<label id="label-login" for="log-login-show">Registro</label> <input
				type="radio" name="active-log-panel" id="log-login-show">
		</div>


		<div class="white-panel">
			<div class="login-show">
				<h2>LOGIN</h2>
				<form action="login" method="POST">
					<input type="text" placeholder="Nombre" name="usuario"> <input
						type="password" placeholder="Contrase�a" name="password">
					<input type="submit" value="Login"> <a href="login">�Olvidaste
						la contrase�a?</a>
					<p>${loginIncorrecto}</p>
				</form>
			</div>

			<div class="register-show">
				<h2>REGISTER</h2>
				<input type="text" placeholder="Nombre"> <input
					type="password" placeholder="Contrase�a"> <input
					type="password" placeholder="Confirma contrase�a"> <input
					type="button" value="Registro">
			</div>

		</div>
	</div>
</body>
</html>
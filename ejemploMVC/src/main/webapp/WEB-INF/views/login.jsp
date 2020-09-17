<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<div>

		<form action="account" method="POST">
			<input type="text" placeholder="Nombre" name="usuario"> 
			<input type="password" placeholder="Contraseña" name="clave"> 
			<input type="submit" value="Login"> <a href="login">¿Olvidaste la contraseña?</a>
			<p id="loginFail">${loginIncorrecto}</p>
		</form>

	</div>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<style><%@include file="styles.css"%></style>
	</head>
	<body>
		<div align="center">
			<spring:form action="home" method="post" >
				<table class="border">
					<tr align="center">
						<td class="breath"><input type="text" placeholder="user" name="user"/></td>
					</tr>
					
					<tr align="center">
						<td class="breath"><input type="password" placeholder="password" name="pass" /></td>
					</tr>
					
					<tr align="center">
						<td class="breath"><input type="submit" value="sign in" /></td>
					</tr>
				</table>
			</spring:form>
		</div>
	</body>
</html>
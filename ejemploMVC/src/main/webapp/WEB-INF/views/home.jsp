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

	<spring:form action="login">

		<div align="center">
			<table>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="registro"></td>
				</tr>
			</table>
		</div>

	</spring:form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to EZTEAM</title>
</head>
<body>
	<%
		boolean isIncorrect = false;
		if (request.getAttribute("incorrect") != null)
			isIncorrect = (boolean) request.getAttribute("incorrect");
	%>
	<form action="login" method="post">
		<input name="email" type="email"> <input name="password"
			type="password">

		<%
			if (isIncorrect == true) {
		%>
		<label>Incorrect email or password</label>
		<%
			}
		%>

		<button type="submit">Login</button>
	</form>
</body>
</html>
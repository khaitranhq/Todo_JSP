<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome to EZTEAM</title>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
	<style>
		body {
			margin: 0px;
			font-family: 'Roboto', sans-serif;
		}
		.root {
			background-image: url('https://colorlib.com/etc/lf/Login_v9/images/bg-01.jpg');
			background-size: cover;
			background-repeat: no-repeat;
			display: flex;
			flex-wrap: wrap;
			min-height: 100vh;
			justify-content: center;
			align-items: center;
		}
		.before {
			background: -webkit-linear-gradient(left,rgba(0,168,255,0.5),rgba(185,0,255,0.5));		
			z-index: 1;	
			width: 100%;
			min-height: 100vh;
			position: absolute;
		}
		.wrap-form {
			background: #fff;
			z-index: 1000;
			position: absolute;
			border-radius: 10px;
			width: 370px;
			padding: 55px 40px 30px;
		}
		.wrap-btn {
			margin-top: 23px;
			display: flex;			
			justify-content: center;
			align-items: center;
			width: 100%;
		}
		button {
			border: none;
			background-color: #bd59d4;
			border-radius: 25px;
			min-width: 160px;
			height: 50px;
			color: #fff;
			font-size: 14px;
			font-weight: 600;
			box-shadow: 0px 3px 6px #00000029;
		}
		input {
			width: 100%;
			height: 62px;
			border: none;
			color: #4b2354;
			font-size: 15px;
			padding: 0px 20px;
			border-color: transparent!important;
			border-radius: 20px;
			box-shadow: 0px 3px 6px #00000029;
			font-weight: 600;
		}
		.title {
			width: 100%;
			text-align: center;
			color: #4b2354;
			font-size: 37px;
			margin-bottom: 35px;
		}
		.wrap-input {
			display: flex;					
			justify-content: center;
			padding: 0px 20px;
			margin: 20px 0px;
		}
		.wrap-sign-up {
			margin-top: 50px;			
			display: flex;					
			justify-content: center;
			color: #4b2354;
			font-size: 14px;
		}
		
	</style>
</head>
<body>
	<div class="before"></div>
	<div class="root">
		<div class="wrap-form">
			<h2 class="title">Sign in</h2>
			<%
				boolean isIncorrect = false;
				if (request.getAttribute("incorrect") != null)
					isIncorrect = (boolean) request.getAttribute("incorrect");
			%>
			<form action="login" method="post">
				<div class="wrap-input">
					<input name="email" type="email" class="email" placeholder="Email">
				</div>
				<div class="wrap-input">
					<input name="password" type="password" class="passowrd" placeholder="Password">
				</div> 
		
				<%
					if (isIncorrect == true) {
				%>
				<label>Incorrect email or password</label>
				<%
					}
				%>
		
				<div class="wrap-btn">
					<button type="submit">SIGN IN</button>
				</div>
				
				<div class="wrap-sign-up">
					<label>Sign Up</label>
				</div>
			</form>
		</div>		
	</div>
</body>
</html>
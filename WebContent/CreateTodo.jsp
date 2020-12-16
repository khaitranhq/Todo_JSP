<%@page import="com.leoaslan.model.beans.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create new task</title>	
	<link rel="preconnect" href="https://fonts.gstatic.com">
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
		.wrap-todo-list {
			background: #fff;
			z-index: 1000;
			position: absolute;
			border-radius: 10px;
			width: 470px;
			padding: 55px 40px 30px;
		}
		.title {
			width: 100%;
			text-align: center;
			color: #4b2354;
			font-size: 37px;
			margin-bottom: 35px;
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
		.wrap-input {
			display: flex;					
			justify-content: center;
			padding: 0px 20px;
			margin: 20px 0px;
		}
		.wrap-btn {
			margin-top: 23px;
			display: flex;			
			justify-content: center;
			align-items: center;
			width: 100%;
		}
	</style>
</head>
<body>
	<div class="before"></div>
	<div class="root">
		<div class="wrap-todo-list">		
			<h2 class="title">Todo</h2>
			<% Task task = (Task) request.getAttribute("task");%>
			<% if (task == null) { %>
				<form action="insert" method="post">
			<% } else { %>
				<form action="edit?taskId=${task.getId()}" method="post">
			<% } %>
			
			<% if (task == null) task = new Task(); %>
				
				<div class="wrap-input">
					<input placeholder="Task Name" name="taskName" value='${task.getTaskName()}'>
				</div>
				
				<div class="wrap-input">
					<input placeholder="Task Description" name="taskDescription" value='${task.getTaskDescription()}'>
				</div>
				
				
				<% if (task.getId() != 0) {%>
					<div class="wrap-input">
						<input placeholder="Status" name=status value='${task.getStatus()}'>
					</div>					
				<% } %>
				
				<div class="wrap-input">
					<input placeholder="Target Date" type="date" name="targetDate" value='${task.getTargetDate() }'>
				</div>
				
				<div class="wrap-btn">
					<button type="submit">Save</button>
				</div>				
			</form>
		</div>
	</div>
	
</body>
</html>
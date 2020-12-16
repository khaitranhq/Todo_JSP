<%@page import="java.util.Objects"%>
<%@page import="com.leoaslan.model.beans.Task"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Todo</title>
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
		.break-line {
			border-top: 1px solid #000;
			width: 100%;
		}
		.wrap-todo {
			padding: 20px 20px;
			display: flex;
			align-items: center;
			justify-content: space-between;
		}
		.wrap-todo-info {
			display: flex;
			justify-content: flex-start;	
			flex-direction: column;		
		}
		.wrap-todo-action {
			display: flex;
			justify-content: flex-end;
		}
		.todo-name {
			font-size: 15px;
			font-weight: 600;
		}
		.todo-status {
			margin-top: 5px;
			font-size: 12px;
		}
		.action {
			height: auto;
			width: 25px;
			margin: 0px 10px;
		}
		.wrap-btn-create {
			display: flex;
			justify-content: flex-end;
			margin-top: 20px;
			margin-bottom: 20px;
		}
		button {
			background: #bd59d4;
			border: none;
			border-radius: 25px;
			min-width: 110px;
			height: 40px;
			color: #fff;
			font-weight: 600;
		}
		.wrap-title {
			display: flex;
			justify-content: center;
			margin-bottom: 30px;
		}
		.title {
			font-size: 37px;
			color: #4b2354;
		}
	</style>
</head>
<body>
	<div class="before"></div>
	<div class="root">
		<div class="wrap-todo-list">
			<div class="wrap-title">
				<h2 class="title">
					Todo List
				</h2>
			</div>
			<form action="form" method="post">
				<div>
					<%
						ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("listTasks");
						for(int i = 0; i < tasks.size(); ++i) {
					%>
						<div>
							<div class="break-line"></div>
							<div class="wrap-todo">	
								<div class="wrap-todo-info">
									<div class="todo-name"><%= tasks.get(i).getTaskName() %></div>
									<div class="todo-status"><%= tasks.get(i).getStatus() %></div>
								</div>
								
								<div class="wrap-todo-action">
									<a href="done?taskId=<%= tasks.get(i).getId() %>">
										<img class="action" src="https://i.ibb.co/gVKQPPY/done.png" alt="done" border="0">
									</a>
									<a href="form?taskId=<%= tasks.get(i).getId() %>">
										<img class="action" src="https://i.ibb.co/4TQM41f/edit.png" alt="edit" border="0">
									</a>
									<a href="delete?taskId=<%= tasks.get(i).getId() %>">
										<img class="action" src="https://i.ibb.co/jZHDMVB/delete.png" alt="delete" border="0">
									</a>
								</div>								
							</div>
							<%
								if (i + 1 == tasks.size()) {
							%>
								<div class="break-line"></div>
							<% } %>
						</div>
					<% 	} %>
				</div>
				
				<div class="wrap-btn-create">
					<button type="submit">ADD TASK</button>
				</div>
			</form>
		</div>	
	</div>	
</body>
</html>
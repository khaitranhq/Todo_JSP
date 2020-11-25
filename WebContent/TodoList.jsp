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
			background-image: url(https://trello-backgrounds.s3.amazonaws.com/SharedBackground/1536x1920/b609d55a104b86f8284e7ad9422efc71/photo-1604541805938-0503816622f4.jpg);
			background-size: cover;
			font-family: 'Roboto', sans-serif;
		}
	</style>
</head>
<body>
	<a href="form">Create new todo</a>
	<%
		ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("listTasks");
		for(int i = 0; i < tasks.size(); ++i) {
	%>
		<div>
			<span><%= tasks.get(i).getTaskName() %></span>
			
			<span><%= tasks.get(i).getStatus() %></span>
			<a href="done?taskId=<%= tasks.get(i).getId() %>">Done</a>
			<a href="form?taskId=<%= tasks.get(i).getId() %>">Edit</a>
			<a href="delete?taskId=<%= tasks.get(i).getId() %>">Delete</a>
		</div>
	<% 	} %>
</body>
</html>
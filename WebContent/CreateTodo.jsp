<%@page import="com.leoaslan.model.beans.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new task</title>
</head>
<body>
	<% Task task = (Task) request.getAttribute("task");%>
	<% if (task == null) { %>
		<form action="insert" method="post">
	<% } else { %>
		<form action="edit?taskId=${task.getId()}" method="post">
	<% } %>
	
	<% if (task == null) task = new Task(); %>
	
		<input placeholder="Task Name" name="taskName" value='${task.getTaskName()}'>
		<input placeholder="Task Description" name="taskDescription" value='${task.getTaskDescription()}'>
		
		<% if (task.getId() != 0) {%>
			<input placeholder="Status" name=status value='${task.getStatus()}'>
		<% } %>
		
		<input placeholder="Target Date" type="date" name="targetDate" value='${task.getTargetDate() }'>
		<button type="submit">Save</button>
	</form>
</body>
</html>
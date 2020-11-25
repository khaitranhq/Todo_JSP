package com.leoaslan.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.leoaslan.model.beans.Task;

public class TaskDAO {
	public ArrayList<Task> getAllTasks(Connection connection) throws SQLException {
		ArrayList<Task> tasks = new ArrayList<Task>();
		
		String getAllTaskQuery = "select * from Tasks"; 
		
		PreparedStatement preparedStatement = connection.prepareStatement(getAllTaskQuery);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String taskName = resultSet.getString("taskName");
			String taskDescription = resultSet.getString("taskDescription");
			String status = resultSet.getString("status");
			Date targetDate = resultSet.getDate("targetDate");
			
			Task task = new Task(id, taskName, taskDescription, status, targetDate);
			tasks.add(task);
		}
		
		return tasks;
	}
	
	public void insertTask(Connection connection, Task task) throws SQLException {
		String insertTaskQuery = "insert into Tasks (taskName, taskDescription, targetDate) values (?, ?, ?)";
		System.out.println(insertTaskQuery);
		
		java.sql.Date sqlDate = new java.sql.Date(task.getTargetDate().getTime());
		
		PreparedStatement preparedStatement = connection.prepareStatement(insertTaskQuery);
		preparedStatement.setString(1, task.getTaskName());
		preparedStatement.setString(2, task.getTaskDescription());
		preparedStatement.setDate(3, sqlDate);
		preparedStatement.executeUpdate();
	}
	
	public void changeStatus(Connection connection, int taskId, String newStatus) throws SQLException {
		String insertTaskQuery = "update Tasks set status=? where id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(insertTaskQuery);
		preparedStatement.setInt(2, taskId);
		preparedStatement.setString(1, newStatus);
		preparedStatement.executeUpdate();
	}
	
	public Task getTaskById(Connection connection, int taskId) throws SQLException {
		String getTaskByIdQuery = "select * from Tasks where id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(getTaskByIdQuery);
		preparedStatement.setInt(1, taskId);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Task task = null;
		if (resultSet.next()) {
			String taskName = resultSet.getString("taskName");
			String taskDescription = resultSet.getString("taskDescription");
			String status = resultSet.getString("status");
			Date targetDate = resultSet.getDate("targetDate");
			
			task = new Task(taskId, taskName, taskDescription, status, targetDate);
		}
		return task;
	}
	
	public void updateTask(Connection connection, Task task) throws SQLException {
		String updateTask = "update Tasks set taskName=?, taskDescription=?, status=?, targetDate=? where id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(updateTask);
		preparedStatement.setString(1, task.getTaskName());
		preparedStatement.setString(2, task.getTaskDescription());
		preparedStatement.setString(3, task.getStatus());
		preparedStatement.setDate(4, new java.sql.Date(task.getTargetDate().getTime()));
		preparedStatement.setInt(5, task.getId());
		
		preparedStatement.executeUpdate();
	}
	
	public void deleteTask(Connection connection, int taskId) throws SQLException {
		String deletTaskQuery = "delete from Tasks where id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(deletTaskQuery);
		preparedStatement.setInt(1, taskId);
		preparedStatement.executeUpdate();
	}
}

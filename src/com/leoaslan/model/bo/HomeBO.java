package com.leoaslan.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.leoaslan.conn.Connector;
import com.leoaslan.model.beans.Task;
import com.leoaslan.model.dao.TaskDAO;

public class HomeBO {
	TaskDAO taskDAO = new TaskDAO();	
	Connector connector = new Connector();
	
	public ArrayList<Task> getAllTasks() throws ClassNotFoundException, SQLException {
		return taskDAO.getAllTasks(Connector.getMySQLConnection());
	}
	
	public void insertTask(Task task) throws ClassNotFoundException, SQLException {
		taskDAO.insertTask(Connector.getMySQLConnection(), task);
	}
	
	public void changeStatus(int taskId, String newStatus) throws ClassNotFoundException, SQLException {
		taskDAO.changeStatus(Connector.getMySQLConnection(), taskId, newStatus);
	}
	
	public Task getTaskById(int taskId) throws ClassNotFoundException, SQLException {
		return taskDAO.getTaskById(Connector.getMySQLConnection(), taskId);
	}
	
	public void updateTask(Task task) throws ClassNotFoundException, SQLException {
		taskDAO.updateTask(Connector.getMySQLConnection(), task);
	}
	
	public void deleteTask(int taskId) throws ClassNotFoundException, SQLException {
		taskDAO.deleteTask(Connector.getMySQLConnection(), taskId);
	}
}

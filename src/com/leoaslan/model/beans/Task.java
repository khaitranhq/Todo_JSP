package com.leoaslan.model.beans;

import java.util.Date;

public class Task {
	private int id;
	private String taskName;
	private String taskDescription;
	private String status;
	private Date targetDate;
	
	public String getTaskName() {
		return taskName;
	}

	public Task() {
		super();
		this.id = 0;
		this.taskName = "";
		this.taskDescription = "";
		this.status = "";
		this.targetDate = new Date();
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTargetDate() {
		return targetDate;
	}

	public Task(String taskName, String taskDescription, Date targetDate) {
		super();
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.targetDate = targetDate;
	}

	public Task(int id, String taskName, String taskDescription, String status, Date targetDate) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.status = status;
		this.targetDate = targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

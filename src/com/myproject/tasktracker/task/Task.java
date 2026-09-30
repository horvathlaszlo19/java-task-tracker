package com.myproject.tasktracker.task;

import java.time.LocalDateTime;

public class Task {
	
	private int id;
	private String descreption;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Status status;
	
	public Task(int id, String descreption) {
		this.id = id;
		this.descreption = descreption;
		this.status = Status.TODO;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = createdAt;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	

}

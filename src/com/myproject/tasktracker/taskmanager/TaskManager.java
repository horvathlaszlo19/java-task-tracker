package com.myproject.tasktracker.taskmanager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.myproject.tasktracker.task.Status;
import com.myproject.tasktracker.task.Task;

public class TaskManager {
	
	private List<Task> tasks;
	
	public TaskManager() {
		this.tasks = new ArrayList<>();
	}
	
	public int getSize() {
		return tasks.size();
	}
	
	public Task getTask(int idx) {
		return tasks.get(idx);
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public void deleteTask(int idx) {
		tasks.remove(idx);
	}
	
	public void updateTaskDescreption(int idx, String descreption) {
		tasks.get(idx).setDescreption(descreption);
		tasks.get(idx).setUpdatedAt(LocalDateTime.now());
	}

	public void markTaskInprogres(int idx) {
		tasks.get(idx).setStatus(Status.INPROGRES);
		tasks.get(idx).setUpdatedAt(LocalDateTime.now());
	}

	public void markTaskDone(int idx) {
		tasks.get(idx).setStatus(Status.DONE);
		tasks.get(idx).setUpdatedAt(LocalDateTime.now());
	}


}

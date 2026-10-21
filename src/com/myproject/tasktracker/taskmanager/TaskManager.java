package com.myproject.tasktracker.taskmanager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
	
	public Task getTask(int id) {
		return tasks.get(getTaskIndex(id));
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public void deleteTask(int id) {
		tasks.remove(getTaskIndex(id));
	}
	
	public void updateTaskDescreption(int id, String descreption) {
		if (descreption.length() == 0) throw new IllegalArgumentException("Descreption lenght cannot be 0.");
		tasks.get(id).setDescreption(descreption);
		tasks.get(id).setUpdatedAt(LocalDateTime.now());
	}

	public void markTaskInprogres(int id) {
		tasks.get(id).setStatus(Status.INPROGRES);
		tasks.get(id).setUpdatedAt(LocalDateTime.now());
	}

	public void markTaskDone(int id) {
		tasks.get(id).setStatus(Status.DONE);
		tasks.get(id).setUpdatedAt(LocalDateTime.now());
	}
	
	public List<Task> listAllTasks() {
		return tasks;
	}
	
	public List<Task> listTask(Predicate<Task> filter) {
		return tasks.stream().filter(filter).toList();
	}
	
	public void showTasksList(List<Task> list) {
		list.stream().forEach(System.out::println);
	}
	
	public Optional<Integer> getMaxId() {
		return tasks.stream().map(Task::getId).max((t1,t2) -> Integer.compare(t1, t2));
		
	}
	
	private int getTaskIndex(int id) {
		Task task = null;
		for (Task t : tasks) {
			if(t.getId() == id) task = t;
		}
		if(task == null) throw new IllegalArgumentException("Task with ID: " + id + " not exits.");
		return tasks.indexOf(task);
	}


}

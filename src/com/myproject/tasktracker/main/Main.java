package com.myproject.tasktracker.main;

import java.io.IOException;

import com.myproject.tasktracker.filehandle.JsonFileHandle;
import com.myproject.tasktracker.task.Status;
import com.myproject.tasktracker.task.Task;
import com.myproject.tasktracker.taskmanager.TaskManager;

public class Main {

	public static void main(String[] args) {
		
		TaskManager tm;
		JsonFileHandle fh = new JsonFileHandle();

		try {
			tm = fh.read();
			if(args[0].equals("add")) {
				StringBuilder sb = new StringBuilder();
				for (int i=1; i < args.length; i++) {
					sb.append(args[i] + " ");
					
				}
				
				int id = tm.getMaxId().orElse(0) + 1;
				Task task = new Task(id,sb.toString());
				tm.addTask(task);	
				
			}
			else if(args[0].equals("show-all")) {
				tm.showTasksList(tm.listAllTasks());
			}
			else if(args[0].equals("show-in")) {
				tm.showTasksList(tm.listTask(t -> t.getStatus() == Status.INPROGRES));
			}
			else if(args[0].equals("show-done")) {
				tm.showTasksList(tm.listTask(t -> t.getStatus() == Status.DONE));
			}
			else if(args[0].equals("show-todo")) {
				tm.showTasksList(tm.listTask(t -> t.getStatus() == Status.TODO));
			}
			else if(args[0].equals("delete")) {
				int idx = Integer.parseInt(args[1]);
				tm.deleteTask(idx);					
			}
			else if(args[0].equals("mark-in")) {
				int idx = Integer.parseInt(args[1]);
				tm.markTaskInprogres(idx);
			}
			else if(args[0].equals("mark-done")) {
				int idx = Integer.parseInt(args[2]);
				tm.markTaskDone(idx);
			}
			else if(args[0].equals("update")) {
				int idx = Integer.parseInt(args[1]);
				StringBuilder sb = new StringBuilder();
				for(int i=1; i < args.length; i++) {
					sb.append(args[i] + " ");
				}
				tm.updateTaskDescreption(idx, sb.toString());
			}
			
			fh.write(tm);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
			
		

	}
	
	private void displayHelp() {
		System.out.println("Available commands for the task-tracker program.");
		System.out.println("add -- Create a new task for your to-do list. After 'add', type your task description.");
		System.out.println("delete -- Delete a selected task by typing its ID number after the 'delete' command.");
		System.out.println("update -- Update the description of a selected task "
		        + "by typing the task's ID number and the new description.");
		System.out.println("show-all -- Show all tasks.");
		System.out.println("show-in-progress -- Show all tasks that are in progress.");
		System.out.println("show-done -- Show all completed tasks.");
		System.out.println("help -- Display available commands.");
	}

}

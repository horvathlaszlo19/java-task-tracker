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
				fh.write(tm);
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		

	}

}

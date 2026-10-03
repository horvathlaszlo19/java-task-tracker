package com.myproject.tasktracker.filehandle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.myproject.tasktracker.task.Task;
import com.myproject.tasktracker.taskmanager.TaskManager;

public class JsonFileHandle {
	
	public JsonFileHandle() {}
	
	public void write(TaskManager taskmanager) throws IOException {
		try(FileWriter out = new FileWriter("tasks.json")) {
			out.write("{\n");
			out.write("\s\"tasks\": [\n");
			for(int i=0; i < taskmanager.getSize(); i++) {
				out.write("\t{\n");
				out.write("\t\t\"id\": " + taskmanager.getTask(i).getId() + ",\n");
				out.write("\t\t\"descreption\": " + "\"" + taskmanager.getTask(i).getDescreption() + "\"" + ",\n");
				out.write("\t\t\"created\": " + "\"" + taskmanager.getTask(i).getCreatedAt() + "\"" + ",\n");
				out.write("\t\t\"updated\": " + "\"" + taskmanager.getTask(i).getUpdatedAt() + "\"" + ",\n");
				out.write("\t\t\"status\": " + "\"" + taskmanager.getTask(i).getStatus() + "\"" + "\n");
				if(i == taskmanager.getSize()-1) {
					out.write("\t}\n");					
				} else {
					out.write("\t},\n");
				}
			}
			out.write("\s]\n");
			out.write("}");
		}
	}
	
	public TaskManager read() throws FileNotFoundException, IOException {
		TaskManager tm = new TaskManager();
		try(BufferedReader br = new BufferedReader(new FileReader("tasks.json"))) {
			String line;
			String token;
			String[] tokens = new String[5];
			int count = 0;
			while((line = br.readLine()) != null) {
				if(line.contains("{") || line.contains("tasks") || 
				   line.contains("},") || line.contains("}") || line.contains("]")) {
					continue;
				}
				
				token = line.split(": ")[1];
				if(token.contains(",")) {
					token = token.split(",")[0];
				}
				if(token.contains("\"")) {
					token = token.split("\"")[1];
				}
				tokens[count] = token;
				count++;
				if(count == 5) {
					Task task = new Task(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
					tm.addTask(task);
					count = 0;
					continue;
				}
				
			}
		}
		return tm;
	}

}

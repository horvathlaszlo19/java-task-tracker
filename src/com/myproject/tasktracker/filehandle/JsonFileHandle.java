package com.myproject.tasktracker.filehandle;

import java.io.FileWriter;
import java.io.IOException;

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

}

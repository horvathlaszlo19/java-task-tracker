package com.myproject.tasktracker.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.myproject.tasktracker.task.Status;
import com.myproject.tasktracker.task.Task;
import com.myproject.tasktracker.taskmanager.TaskManager;

class TaskManagerTest {
	
	private TaskManager tm;
	
	@BeforeEach
	void init() {
		 this.tm = new TaskManager();
	}

	@Test
	void initTaskManager() {
		assertEquals(0, tm.getSize());
	}
	
	@Test
	void addOneTaskToManager() {
		tm.addTask(new Task(1,"aaa"));
		assertEquals(1, tm.getSize());
	}
	
	@Test
	void deleteOneTask() {
		tm.addTask(new Task(1,"aaa"));
		tm.deleteTask(0);
		assertEquals(0, tm.getSize());		
	}
	
	@Test
	void updateTask() {
		tm.addTask(new Task(1,"aaa"));
		tm.updateTaskDescreption(0, "bbb");
		assertEquals("bbb", tm.getTask(0).getDescreption());
		
	}
	
	@Test
	void markInprogresTest() {
		tm.addTask(new Task(1,"aaa"));
		tm.markTaskInprogres(0);
		assertEquals(Status.INPROGRES, tm.getTask(0).getStatus());
	}
	
	@Test
	void markDoneTest() {
		tm.addTask(new Task(1,"aaa"));
		tm.markTaskDone(0);
		assertEquals(Status.DONE, tm.getTask(0).getStatus());
	}

}

package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.todo.model.Task;
import com.todo.service.TaskService;

@Controller
public class TaskController {
   
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public String getTasks(Model model) {
		
		List<Task> tasks = taskService.findAllTasks();
		model.addAttribute("tasks",tasks);
		return "tasks";
	}
}

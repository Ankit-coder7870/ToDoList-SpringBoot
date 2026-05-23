package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.todo.model.Task;
import com.todo.repository.TaskRepository;

@Service
public class TaskService {
  
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAllTasks(){
		return taskRepository.findAll();
	}

	public void createTask(String title) {
		
		Task task = new Task();
		task.setCompleted(false);
		task.setTitle(title);
		
		taskRepository.save(task);
		
	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
		
	}

	public void toggleTask(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Task Id"));
		
		task.setCompleted(!task.isCompleted());
		
		taskRepository.save(task);
	}
}

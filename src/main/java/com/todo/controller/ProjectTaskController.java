package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.Util.CustomExcp;
import com.todo.pojos.ProjectTask;
import com.todo.serviceImpl.ProjectTaskServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class ProjectTaskController {

	@Autowired
	private ProjectTaskServiceImpl projectTask;
	
	//Adding a task...
	@PostMapping("/addtask")
	public ResponseEntity<ProjectTask> addTask(@RequestBody ProjectTask addtask){
		ProjectTask newTask=projectTask.saveTask(addtask);
		return new ResponseEntity<ProjectTask>(newTask,HttpStatus.CREATED);
		
	}
	
	//fetching all tasks..
	
	@GetMapping("/getalltasks")
	public List<ProjectTask> getall(){
		return projectTask.findAll();
	}
	
	//Fetching task by id...
	@GetMapping("/gettask/{taskid}")
	public ResponseEntity<ProjectTask> getTaskById(@PathVariable("taskid") Long id) throws CustomExcp {
		ProjectTask getTask=projectTask.getTaskById(id);
		return new ResponseEntity<ProjectTask>(getTask,HttpStatus.OK);
	}
	
	
	//Delete Task by id..
	@DeleteMapping("/delete/{taskid}")
	public ResponseEntity<String> deleteTask(@PathVariable("taskid") Long id) throws CustomExcp{
		ProjectTask delete=projectTask.deleteTask(id);
		return new ResponseEntity<String>("Project task deleted",HttpStatus.OK);
	}
	
}

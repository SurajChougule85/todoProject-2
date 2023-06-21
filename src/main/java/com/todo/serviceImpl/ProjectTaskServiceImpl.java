package com.todo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.Util.CustomExcp;
import com.todo.pojos.ProjectTask;
import com.todo.repository.ProjectTaskRepo;
import com.todo.service.ProjectTaskService;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

	@Autowired
	private ProjectTaskRepo taskRepo;
	
	
	//Adding a task...
	@Override
	public ProjectTask saveTask(ProjectTask task) {
		
		ProjectTask newTask=taskRepo.save(task);
		return newTask;
	}

   //Get all tasks...
	@Override
	public List<ProjectTask> findAll() {
		
		return taskRepo.findAll(); 
	}

	//Get task by Id...
	@Override
	public ProjectTask getTaskById(Long id) throws CustomExcp {
		ProjectTask get=taskRepo.findById(id).orElseThrow(() -> new CustomExcp("Invalid Id"));
		return get;
	}

	@Override
	public ProjectTask updateTask(ProjectTask updateTask, Long id) {
		
		return null;
	}

	//Delete Task by Id...
	@Override
	public ProjectTask deleteTask(Long id) throws CustomExcp {
		ProjectTask get=getTaskById(id);
		taskRepo.delete(get);
		return get;
	}

}

package com.todo.service;

import java.util.List;

import com.todo.Util.CustomExcp;
import com.todo.pojos.ProjectTask;

public interface ProjectTaskService {
	
	ProjectTask saveTask(ProjectTask task);

	List<ProjectTask> findAll();
	
	ProjectTask getTaskById(Long id) throws CustomExcp;
	
	ProjectTask updateTask(ProjectTask updateTask, Long id);
	
	ProjectTask deleteTask (Long id) throws CustomExcp;
}

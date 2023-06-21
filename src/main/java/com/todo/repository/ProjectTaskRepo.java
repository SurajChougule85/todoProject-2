package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.pojos.ProjectTask;

public interface ProjectTaskRepo extends JpaRepository<ProjectTask, Long> {

}

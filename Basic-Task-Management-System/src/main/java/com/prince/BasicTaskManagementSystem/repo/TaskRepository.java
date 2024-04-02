package com.prince.BasicTaskManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prince.BasicTaskManagementSystem.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	
	

}

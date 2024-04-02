package com.prince.BasicTaskManagementSystem.service;

import java.util.List;

import com.prince.BasicTaskManagementSystem.dto.TasksRequest;
import com.prince.BasicTaskManagementSystem.dto.TasksResponse;

public interface TasksService {

	TasksResponse createTask(TasksRequest tasksRequest);

	TasksResponse updateTask(Integer taskId, TasksRequest tasksRequest);

	List<TasksResponse> getAllTasks();

}

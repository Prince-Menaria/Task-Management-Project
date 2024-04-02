package com.prince.BasicTaskManagementSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prince.BasicTaskManagementSystem.dto.TasksRequest;
import com.prince.BasicTaskManagementSystem.dto.TasksResponse;
import com.prince.BasicTaskManagementSystem.service.TasksService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskController {

	private final TasksService tasksService;

	@PostMapping("/task")
	public ResponseEntity<TasksResponse> createTask(@RequestBody TasksRequest tasksRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tasksService.createTask(tasksRequest));
	}

	@PutMapping("/task/{taskId}")
	public ResponseEntity<TasksResponse> updateTask(@PathVariable Integer taskId,
			@RequestBody TasksRequest tasksRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(tasksService.updateTask(taskId, tasksRequest));
	}

	@GetMapping("/tasks")
	public ResponseEntity<List<TasksResponse>> getAllTasks() {
		return ResponseEntity.status(HttpStatus.OK).body(tasksService.getAllTasks());
	}

}

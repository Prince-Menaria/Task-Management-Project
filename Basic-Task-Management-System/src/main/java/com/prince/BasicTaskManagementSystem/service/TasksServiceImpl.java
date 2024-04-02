package com.prince.BasicTaskManagementSystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.prince.BasicTaskManagementSystem.dto.TasksRequest;
import com.prince.BasicTaskManagementSystem.dto.TasksResponse;
import com.prince.BasicTaskManagementSystem.entity.Task;
import com.prince.BasicTaskManagementSystem.exception.ResourceNotFoundException;
import com.prince.BasicTaskManagementSystem.repo.TaskRepository;

@Service
public class TasksServiceImpl implements TasksService {

	private final TaskRepository taskRepository;

	public TasksServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public TasksResponse createTask(TasksRequest tasksRequest) {
		try {
			Task task = dtoToTask(tasksRequest);
			Task saveTask = saveTask(task);

			return taskToDto(saveTask);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public TasksResponse updateTask(Integer taskId, TasksRequest tasksRequest) {
		try {
			Task task = findByTaskId(taskId);

			TasksResponse response = new TasksResponse();

			if (!ObjectUtils.isEmpty(task)) {
				task.setTitle(tasksRequest.getTitle());
				task.setDescription(tasksRequest.getDescription());
				task.setDueDate(LocalDate.now());

				Task updateTask = updateTask(task);
				response = taskToDto(updateTask);

			}

			return response;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<TasksResponse> getAllTasks() {
		List<Task> tasks = allTasks();

		return tasks.stream().map(task -> taskToDto(task)).collect(Collectors.toList());
	}

	private Task updateTask(Task task) {

		return taskRepository.save(task);
	}

	private Task saveTask(Task task) {

		return taskRepository.save(task);
	}

	private List<Task> allTasks() {

		return taskRepository.findAll();
	}

	private Task findByTaskId(Integer taskId) {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
//		Task task = tasks.get();
		return task;
	}

	private TasksResponse taskToDto(Task task) {
		try {
			TasksResponse response = new TasksResponse();

			response.setId(task.getId());
			response.setTitle(task.getTitle());
			response.setDescription(task.getDescription());
			response.setDueDate(task.getDueDate());

			response.setCreatedAt(task.getCreatedAt());
			response.setUpdatedAt(task.getUpdatedAt());

			return response;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private Task dtoToTask(TasksRequest tasksRequest) {
		try {
			Task task = new Task();

			task.setTitle(tasksRequest.getTitle());
			task.setDescription(tasksRequest.getDescription());
			task.setDueDate(LocalDate.now());
			return task;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}

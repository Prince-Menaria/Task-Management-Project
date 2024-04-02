package com.prince.BasicTaskManagementSystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TasksResponse {
	
	private Integer id;
	private String title;
	private String description;
	private LocalDate dueDate;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

}

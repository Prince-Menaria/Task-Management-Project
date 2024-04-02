package com.prince.BasicTaskManagementSystem.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TasksRequest {
	
	private String title;
	private String description;
	private Date dueDate;

}

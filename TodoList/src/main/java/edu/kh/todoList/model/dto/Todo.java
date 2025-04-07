package edu.kh.todoList.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Todo {

	private int todoNo;
	private String todoTitle;
	private String todoDetail;
	private boolean todoComplete;
	private String regDate;
}

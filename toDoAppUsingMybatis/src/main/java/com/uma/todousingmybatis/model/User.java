package com.uma.todousingmybatis.model;

import java.util.List;

public class User {

	private int id;
	private String fullName;
	private String email;
	private String mobile;
	private String password;
	
	private List<ToDoItem> toDoItems;
	
	
	

	public List<ToDoItem> getToDoItems() {
		return toDoItems;
	}

	public void setToDoItems(List<ToDoItem> toDoItems) {
		this.toDoItems = toDoItems;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}

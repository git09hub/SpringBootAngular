package com.boot.classes;

public class ToDo {

	public int id;
	public String toDoName;
	public String description;
	public boolean done;

	public ToDo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToDoName() {
		return toDoName;
	}

	public void setToDoName(String toDoName) {
		this.toDoName = toDoName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public ToDo(int id, String toDoName, String description, boolean done) {
		super();
		this.id = id;
		this.toDoName = toDoName;
		this.description = description;
		this.done = done;
	}
}

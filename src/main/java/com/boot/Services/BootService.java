package com.boot.Services;

import java.util.List;

import com.boot.classes.ToDo;

public interface BootService {
	
	public String getGreetings(String name);

	public boolean addToDo(ToDo toDo);
	
	public List<ToDo> listToDos();
	
	public boolean deleteToDo(int toDoId);

	public boolean completeToDo(int id);
}

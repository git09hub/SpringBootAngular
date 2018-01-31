package com.boot.DAO;

import java.util.List;

import com.boot.classes.ToDo;

public interface BootDAO {
	public String getData(String name);
	
	public List<ToDo> getToDoList();
	
	public boolean addToDo(ToDo toDo);
	
	public boolean deleteToDo(int toDoId);

	public boolean completeToDo(int id);
}

package com.boot.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.DAO.BootDAO;
import com.boot.classes.ToDo;

@Service("bootService")
public class BootServiceImpl implements BootService {

	@Autowired
	BootDAO bootDAO;
	
	@Override
	public String getGreetings(String name) {
		return "Hello "+name;
		//return bootDAO.getData(name);
	}

	@Override
	public boolean addToDo(ToDo toDo) {
		boolean result = false;
		if(bootDAO.addToDo(toDo)) {
			result = true;
		}
		return result;
	}

	@Override
	public List<ToDo> listToDos() {
		return bootDAO.getToDoList();
	}

	@Override
	public boolean deleteToDo(int toDoId) {
		boolean result = false;
		if(bootDAO.deleteToDo(toDoId)) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean completeToDo(int id) {
		boolean result = false;
		if(bootDAO.completeToDo(id)) {
			result = true;
		}
		return result;
	}
}

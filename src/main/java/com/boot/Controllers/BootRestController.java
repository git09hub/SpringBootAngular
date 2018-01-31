package com.boot.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.Services.BootService;
import com.boot.classes.ToDo;

/*Web services controller*/
@RestController
public class BootRestController {

	@Autowired
	BootService bootService;

	/* Web Services Built with Boot */
	@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		return bootService.getGreetings(name);
	}

	@PostMapping("/addToDo")
	public Map addToDo(@RequestBody ToDo toDo) {
		Map<String, String> response = new HashMap<String, String>();
		if (bootService.addToDo(toDo)) {
			response.put("status", "200");
			response.put("response", "added successfully!");
		} else {
			response.put("fail", "500");
			response.put("response", "failed to add todo!");
		}
		return response;
	}

	@RequestMapping("/listToDos")
	public Map<String, Object> listToDos() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ToDo> toDosList = bootService.listToDos();
		if (toDosList.size() > 0) {
			result.put("status", "200");
			result.put("response", toDosList);
		} else {
			result.put("status", "500");
			result.put("response", "No Data Found!");
		}
		return result;
	}

	@PostMapping(value = "/deleteToDo")
	public Map<String, Object> deleteToDo(@RequestParam int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (bootService.deleteToDo(id)) {
			result.put("status", "200");
			result.put("response", "Deleted Successfully!");
		} else {
			result.put("status", "500");
			result.put("response", "Failed to Delete!");
		}
		return result;
	}
	
	@PostMapping(value = "/completeToDo")
	public Map<String, Object> completeToDo(@RequestParam int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (bootService.completeToDo(id)) {
			result.put("status", "200");
			result.put("response", "Updates Successfully!");
		} else {
			result.put("status", "500");
			result.put("response", "Failed to Delete!");
		}
		return result;
	}
	
}

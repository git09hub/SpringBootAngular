package com.boot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.Services.BootService;

@Controller
public class BootController {

	@Autowired
	BootService bootService;
	
	@RequestMapping(value="/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/home")
	public String error() {
		return "home";
	}
	
	
	
}

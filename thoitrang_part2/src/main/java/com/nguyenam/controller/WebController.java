package com.nguyenam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
	
	@RequestMapping("/")
	@ResponseBody 
	public String sayHello() {
		return "Nguyen Van Nam say Hello";
	}
	
	@RequestMapping("/home")
	public String viewHomePage() {
		return "index";
	}
}

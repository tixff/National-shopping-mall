package com.e3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping("/")
	public String getIndex(){
		return "index";
	}
	@RequestMapping("/{page}")
	public String pageTo(@PathVariable String page){
		return page;
	}

}

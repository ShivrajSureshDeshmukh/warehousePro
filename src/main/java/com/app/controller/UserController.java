package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("user", new User());
		return "UserCreate";
	}

	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String saveReg(@ModelAttribute User user,ModelMap map) {
		service.saveUser(user);
		map.addAttribute("user", new User());
		map.addAttribute("message", "User Created Succesfully");
		return "UserCreate";
	}


}
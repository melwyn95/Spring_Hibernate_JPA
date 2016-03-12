package org.crce.interns.controller;

import java.util.List;

import org.crce.interns.beans.UserBean;
import org.crce.interns.model.User;
import org.crce.interns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView initApp() {
		System.out.println("In UserController initApp");
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/SubmitForm", method=RequestMethod.POST)
	public ModelAndView submitForm(@ModelAttribute("user")UserBean userBean, BindingResult result, SessionStatus status) {
		System.out.println("In UserController submitForm");
		userService.addUser(userBean);
		System.out.println("End of submitForm +++++++");
		status.setComplete();
		return new ModelAndView("success");
	}
	
	@ModelAttribute("allUsers")
	public List<User> setModel() {
		return userService.viewUsers();
	}
	
	@RequestMapping(value="/ViewUsers", method=RequestMethod.GET)
	public ModelAndView viewUsers() {
		setModel();
		return new ModelAndView("viewUsers");
	}
	
	@ModelAttribute("user")
	public UserBean setBean(String name) {
		return userService.getUser(name);
	}
	
	@RequestMapping(value="/ViewByName", method=RequestMethod.POST) 
	public ModelAndView viewByName(@RequestParam("name")String name) {
		setBean(name);
		return new ModelAndView("viewByName");
	}
	
	@RequestMapping("/ViewName")
	public ModelAndView viewName() {
		return new ModelAndView("viewName");
	}
}

package com.ty.springsmvc_prc.contraller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.springsmvc_prc.dto.Employee;
import com.ty.springsmvc_prc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}

	@RequestMapping("signup")
	public ModelAndView signup() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("employee", new Employee());
		return modelAndView;

	}
	@RequestMapping("saveemployee")
	public ModelAndView saveStudent(@ModelAttribute Employee employee) {
		service.saveStudent(employee);
		ModelAndView modelAndView= new ModelAndView(); 
		modelAndView.setViewName("index.jsp");
		return modelAndView;
	}
}

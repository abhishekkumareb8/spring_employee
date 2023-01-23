package com.ty.springsmvc_prc.contraller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		modelAndView.addObject("employeeget", new Employee());
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
	@RequestMapping("getemployee")
	public ModelAndView getEmployee(@ModelAttribute Employee employee) {
		ModelAndView modelAndView= new ModelAndView(); 
		Employee employee2 = service.getEmployeeByEmail(employee);
		if(employee2 !=null) {
			modelAndView.addObject("name", employee2.getName());
			modelAndView.addObject("slist", service.getAllEmployee());
			modelAndView.setViewName("view.jsp");
		}
		else
			modelAndView.setViewName("index.jsp");
		return modelAndView;
	}
	@RequestMapping("view")
	public ModelAndView viewEmployee() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("slist", service.getAllEmployee());
		modelAndView.setViewName("view.jsp");
		return modelAndView;
	}
	
	@RequestMapping("delete")
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		service.deleteEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view");
		dispatcher.forward(request, response);
	}
	@RequestMapping("edit")
	public ModelAndView editEmployee(@RequestParam int id) {
		
		Employee employee = service.getEmployeeById(id);
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("employee", employee);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}
	@RequestMapping("updatestudent")
		public void updateEmployee(@ModelAttribute Employee employee, HttpServletRequest request, HttpServletResponse response  ) throws ServletException, IOException {
			service.updateEmployee(employee);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view");
			dispatcher.forward(request, response);
		}
}

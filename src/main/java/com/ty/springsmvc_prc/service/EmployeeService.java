package com.ty.springsmvc_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.springsmvc_prc.dao.Employeedao;
import com.ty.springsmvc_prc.dto.Employee;

@Service
public class EmployeeService {
	
	
		@Autowired
		Employeedao employeedao ;
		public Employee saveStudent(Employee employee) {
			employeedao.saveEmplyee(employee);
			return employee;
		}

}

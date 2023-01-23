package com.ty.springsmvc_prc.service;

import java.util.List;

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
		public Employee getEmployeeByEmail(Employee employee) {
			Employee receiveEmployee= employeedao.getEmployeeEmail(employee.getEmail());
			
			if(employee.getPass().equals(receiveEmployee.getPass())) {
				return receiveEmployee;
			}
			return null;
		}
		
		public List<Employee> getAllEmployee(){
			return  employeedao.getEmployee();
		}
		
		public void deleteEmployee(int id) {
			employeedao.deleteEmployee(id);
		}
		
		
		public Employee getEmployeeById(int id) {
			return employeedao.getEmployeeById(id);
		}
		
		
		public void updateEmployee(Employee employee) {
			employeedao.updateEmployee(employee);
		}

}

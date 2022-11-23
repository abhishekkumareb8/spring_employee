package com.ty.springsmvc_prc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.springsmvc_prc.dto.Employee;

@Repository
public class Employeedao {

	@Autowired
	private EntityManagerFactory entityManagerFactory ;
	
	public Employee saveEmplyee(Employee employee ) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
	
	public Employee updateEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return employee;
	}
	
	public boolean deleteEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();

		return true;
	}
	
	public Employee getEmployeeById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Employee.class, id);
	}
	
	public void getEmployee() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query= entityManager.createQuery("select e from Employee s",Employee.class);
		List<Employee>employee= query.getResultList();
	}
}

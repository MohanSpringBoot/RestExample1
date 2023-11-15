package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rest.bean.Employee;

@Repository
public interface EmployeRepo extends JpaRepository<Employee, Integer>{

	
	

}
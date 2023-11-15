package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.rest.bean.Employee;


public interface EmpService {
	
	public Integer saveEmp(Employee emp);

	public Employee getbydata(Integer id);

	public List<Employee> getAlldata();

	public void empdelId(Integer id);


}

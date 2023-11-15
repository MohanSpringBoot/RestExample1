package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repo.EmployeRepo;
import com.app.rest.bean.Employee;
import com.app.service.EmpService;

@Service
public class empServiceImpl implements EmpService{
	@Autowired
	private EmployeRepo repo;

	@Override
	public Integer saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp).getId();
	}

	@Override
	public Employee getbydata(Integer id) {
		
		Optional<Employee> empsv = repo.findById(id);
		if(empsv.isPresent()) {
			return empsv.get();
		}
		return null;
		
	}

	@Override
	public List<Employee> getAlldata() {
		return repo.findAll();
	}

	@Override
	public void empdelId(Integer id) {
		repo.deleteById(id);
	}


	
	



}